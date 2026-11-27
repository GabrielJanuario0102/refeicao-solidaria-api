package com.refeicaosolidaria.api.service;

import com.refeicaosolidaria.api.domain.Doacao;
import com.refeicaosolidaria.api.domain.Solicitacao;
import com.refeicaosolidaria.api.domain.StatusDoacao;
import com.refeicaosolidaria.api.domain.StatusSolicitacao;
import com.refeicaosolidaria.api.domain.TipoUsuario;
import com.refeicaosolidaria.api.domain.Usuario;
import com.refeicaosolidaria.api.dto.DoacaoRequisicao;
import com.refeicaosolidaria.api.dto.DoacaoResposta;
import com.refeicaosolidaria.api.exception.RecursoNaoEncontradoException;
import com.refeicaosolidaria.api.exception.RegraNegocioException;
import com.refeicaosolidaria.api.repository.DoacaoRepository;
import com.refeicaosolidaria.api.repository.SolicitacaoRepository;
import com.refeicaosolidaria.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DoacaoService {
    private final DoacaoRepository doacoes;
    private final SolicitacaoRepository solicitacoes;
    private final UsuarioRepository usuarios;

    public DoacaoService(DoacaoRepository doacoes, SolicitacaoRepository solicitacoes,
                         UsuarioRepository usuarios) {
        this.doacoes = doacoes;
        this.solicitacoes = solicitacoes;
        this.usuarios = usuarios;
    }

    @Transactional
    public DoacaoResposta criar(DoacaoRequisicao dados) {
        validar(dados);
        Usuario doador = usuarios.findById(dados.idDoador())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Doador não encontrado."));
        if (doador.getTipo() != TipoUsuario.DOADOR) {
            throw new RegraNegocioException("O usuário informado não possui perfil de doador.");
        }
        Doacao doacao = new Doacao();
        doacao.setDoador(doador);
        preencher(doacao, dados);
        doacao.setStatus(StatusDoacao.DISPONIVEL);
        doacao.aoCriar();
        return DoacaoResposta.de(doacoes.save(doacao));
    }

    @Transactional(readOnly = true)
    public List<DoacaoResposta> listar(StatusDoacao status, Long idDoador) {
        List<Doacao> resultado;
        if (status != null && idDoador != null) {
            resultado = doacoes.findByDoador_IdAndStatus(idDoador, status);
        } else if (status != null) {
            resultado = doacoes.findByStatus(status);
        } else if (idDoador != null) {
            resultado = doacoes.findByDoador_Id(idDoador);
        } else {
            resultado = doacoes.findAll();
        }
        return resultado.stream().map(DoacaoResposta::de).toList();
    }

    @Transactional(readOnly = true)
    public DoacaoResposta buscar(Long id) {
        return DoacaoResposta.de(buscarEntidade(id));
    }

    @Transactional
    public DoacaoResposta editar(Long id, DoacaoRequisicao dados) {
        Doacao doacao = buscarEntidade(id);
        if (doacao.getStatus() != StatusDoacao.DISPONIVEL) {
            throw new RegraNegocioException("A edição só é permitida enquanto a doação estiver disponível.");
        }
        if (!doacao.getDoador().getId().equals(dados.idDoador())) {
            throw new RegraNegocioException("Não é possível alterar o doador de uma publicação.");
        }
        validar(dados);
        preencher(doacao, dados);
        return DoacaoResposta.de(doacoes.save(doacao));
    }

    @Transactional
    public DoacaoResposta cancelar(Long id, String motivo) {
        if (motivo == null || motivo.isBlank()) {
            throw new RegraNegocioException("Informe o motivo do cancelamento.");
        }
        Doacao doacao = buscarEntidade(id);
        if (doacao.getStatus() != StatusDoacao.DISPONIVEL
                && doacao.getStatus() != StatusDoacao.PARCIALMENTE_RESERVADA) {
            throw new RegraNegocioException("A doação não pode ser cancelada no estado atual.");
        }
        for (Solicitacao solicitacao : solicitacoes.findByDoacao_Id(id)) {
            if (solicitacao.getStatus() == StatusSolicitacao.PENDENTE
                    || solicitacao.getStatus() == StatusSolicitacao.APROVADA) {
                solicitacao.setStatus(StatusSolicitacao.CANCELADA);
                solicitacao.setMotivoCancelamento(motivo.trim());
                solicitacoes.save(solicitacao);
            }
        }
        doacao.setStatus(StatusDoacao.CANCELADA);
        return DoacaoResposta.de(doacoes.save(doacao));
    }

    private Doacao buscarEntidade(Long id) {
        return doacoes.findById(id).orElseThrow(
                () -> new RecursoNaoEncontradoException("Doação não encontrada: " + id));
    }

    private static void validar(DoacaoRequisicao dados) {
        if (dados == null) throw new RegraNegocioException("Dados da doação não informados.");
        if (dados.idDoador() == null || dados.idDoador() <= 0) {
            throw new RegraNegocioException("Informe um doador válido.");
        }
        if (dados.nomeAlimento() == null || dados.nomeAlimento().isBlank()) {
            throw new RegraNegocioException("Informe o nome do alimento.");
        }
        if (dados.nomeAlimento().trim().length() > 150) {
            throw new RegraNegocioException("Nome do alimento acima do limite de 150 caracteres.");
        }
        if (dados.quantidadeDisponivel() == null || dados.quantidadeDisponivel() <= 0) {
            throw new RegraNegocioException("A quantidade deve ser maior que zero.");
        }
        if (!Boolean.TRUE.equals(dados.declaracaoDoadorAceite())) {
            throw new RegraNegocioException("É necessário confirmar as condições do alimento.");
        }
        if (dados.armazenamentoConservacao() == null || dados.armazenamentoConservacao().isBlank()
                || dados.localRetirada() == null || dados.localRetirada().isBlank()) {
            throw new RegraNegocioException("Informe a conservação e o local de retirada.");
        }
        LocalDateTime agora = LocalDateTime.now();
        if (dados.validadeConsumo() == null || !dados.validadeConsumo().isAfter(agora)) {
            throw new RegraNegocioException("A validade de consumo deve estar no futuro.");
        }
        if (dados.horarioLimiteRetirada() == null
                || !dados.horarioLimiteRetirada().isAfter(agora)) {
            throw new RegraNegocioException("O limite de retirada deve estar no futuro.");
        }
        if (dados.horarioLimiteRetirada().isAfter(dados.validadeConsumo())) {
            throw new RegraNegocioException("A retirada não pode ocorrer depois da validade.");
        }
        if (dados.dataHoraPreparo() != null && dados.dataHoraPreparo().isAfter(dados.validadeConsumo())) {
            throw new RegraNegocioException("O preparo não pode ser posterior à validade.");
        }
        if (dados.fotoUrl() != null && dados.fotoUrl().length() > 500) {
            throw new RegraNegocioException("Endereço da foto acima do limite permitido.");
        }
    }

    private static void preencher(Doacao doacao, DoacaoRequisicao dados) {
        doacao.setNomeAlimento(dados.nomeAlimento().trim());
        doacao.setDescricao(dados.descricao());
        doacao.setQuantidadeDisponivel(dados.quantidadeDisponivel());
        doacao.setDataHoraPreparo(dados.dataHoraPreparo());
        doacao.setValidadeConsumo(dados.validadeConsumo());
        doacao.setArmazenamentoConservacao(dados.armazenamentoConservacao().trim());
        doacao.setDeclaracaoDoadorAceite(dados.declaracaoDoadorAceite());
        doacao.setLocalRetirada(dados.localRetirada().trim());
        doacao.setHorarioLimiteRetirada(dados.horarioLimiteRetirada());
        doacao.setFotoUrl(dados.fotoUrl());
    }
}

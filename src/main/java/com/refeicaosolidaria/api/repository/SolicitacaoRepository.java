package com.refeicaosolidaria.api.repository;

import com.refeicaosolidaria.api.domain.Solicitacao;
import com.refeicaosolidaria.api.domain.StatusSolicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
    List<Solicitacao> findByStatus(StatusSolicitacao status);
    List<Solicitacao> findByInstituicao_Id(Long idInstituicao);
    List<Solicitacao> findByDoacao_Id(Long idDoacao);
    List<Solicitacao> findByInstituicao_IdAndStatus(Long idInstituicao, StatusSolicitacao status);
    List<Solicitacao> findByDoacao_IdAndStatus(Long idDoacao, StatusSolicitacao status);
}

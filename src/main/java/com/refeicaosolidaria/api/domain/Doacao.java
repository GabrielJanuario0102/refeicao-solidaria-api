package com.refeicaosolidaria.api.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "doacoes")
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_doador", nullable = false)
    private Usuario doador;

    @Column(name = "nome_alimento", nullable = false, length = 150)
    private String nomeAlimento;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "quantidade_disponivel", nullable = false)
    private Integer quantidadeDisponivel;

    @Column(name = "data_hora_preparo")
    private LocalDateTime dataHoraPreparo;

    @Column(name = "validade_consumo", nullable = false)
    private LocalDateTime validadeConsumo;

    @Column(name = "armazenamento_conservacao", nullable = false, columnDefinition = "TEXT")
    private String armazenamentoConservacao;

    @Column(name = "declaracao_doador_aceite", nullable = false)
    private Boolean declaracaoDoadorAceite;

    @Column(name = "local_retirada", nullable = false, columnDefinition = "TEXT")
    private String localRetirada;

    @Column(name = "horario_limite_retirada", nullable = false)
    private LocalDateTime horarioLimiteRetirada;

    @Column(name = "foto_url", length = 500)
    private String fotoUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private StatusDoacao status;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    public Doacao() { }

    @PrePersist
    public void aoCriar() {
        if (status == null) status = StatusDoacao.DISPONIVEL;
        if (dataCriacao == null) dataCriacao = LocalDateTime.now();
        if (declaracaoDoadorAceite == null) declaracaoDoadorAceite = false;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getDoador() { return doador; }
    public void setDoador(Usuario doador) { this.doador = doador; }

    public String getNomeAlimento() { return nomeAlimento; }
    public void setNomeAlimento(String nomeAlimento) { this.nomeAlimento = nomeAlimento; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getQuantidadeDisponivel() { return quantidadeDisponivel; }
    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) { this.quantidadeDisponivel = quantidadeDisponivel; }

    public LocalDateTime getDataHoraPreparo() { return dataHoraPreparo; }
    public void setDataHoraPreparo(LocalDateTime dataHoraPreparo) { this.dataHoraPreparo = dataHoraPreparo; }

    public LocalDateTime getValidadeConsumo() { return validadeConsumo; }
    public void setValidadeConsumo(LocalDateTime validadeConsumo) { this.validadeConsumo = validadeConsumo; }

    public String getArmazenamentoConservacao() { return armazenamentoConservacao; }
    public void setArmazenamentoConservacao(String armazenamentoConservacao) { this.armazenamentoConservacao = armazenamentoConservacao; }

    public Boolean getDeclaracaoDoadorAceite() { return declaracaoDoadorAceite; }
    public void setDeclaracaoDoadorAceite(Boolean declaracaoDoadorAceite) { this.declaracaoDoadorAceite = declaracaoDoadorAceite; }

    public String getLocalRetirada() { return localRetirada; }
    public void setLocalRetirada(String localRetirada) { this.localRetirada = localRetirada; }

    public LocalDateTime getHorarioLimiteRetirada() { return horarioLimiteRetirada; }
    public void setHorarioLimiteRetirada(LocalDateTime horarioLimiteRetirada) { this.horarioLimiteRetirada = horarioLimiteRetirada; }

    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }

    public StatusDoacao getStatus() { return status; }
    public void setStatus(StatusDoacao status) { this.status = status; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}

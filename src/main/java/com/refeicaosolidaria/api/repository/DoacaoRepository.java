package com.refeicaosolidaria.api.repository;

import com.refeicaosolidaria.api.domain.Doacao;
import com.refeicaosolidaria.api.domain.StatusDoacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DoacaoRepository extends JpaRepository<Doacao, Long> {
    List<Doacao> findByStatus(StatusDoacao status);
    List<Doacao> findByDoador_Id(Long idDoador);
    List<Doacao> findByDoador_IdAndStatus(Long idDoador, StatusDoacao status);
}

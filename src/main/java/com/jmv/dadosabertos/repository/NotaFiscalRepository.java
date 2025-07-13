package com.jmv.dadosabertos.repository;

import com.jmv.dadosabertos.api.controller.dto.resumo.ResumoNotasPorEstadoDTO;
import com.jmv.dadosabertos.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Integer>,
        JpaSpecificationExecutor<NotaFiscal> {

    Optional<NotaFiscal> findByChaveAcesso(String chaveAcesso);

    @Query("SELECT new com.jmv.dadosabertos.api.controller.dto.resumo.ResumoNotasPorEstadoDTO(f.uf, COUNT(n), SUM(n.valorNotaFiscal)) " +
            "FROM NotaFiscal n " +
            "JOIN n.fornecedor f " +
            "GROUP BY f.uf " +
            "ORDER BY f.uf")
    List<ResumoNotasPorEstadoDTO> buscarResumoNotasPorEstado();

}

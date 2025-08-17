package com.jmv.dadosabertos.repository;

import com.jmv.dadosabertos.api.controller.dto.fornecedor.FornecedorItensDTO;
import com.jmv.dadosabertos.model.NotaItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaItemRepository extends JpaRepository<NotaItem, Integer> {

    @Query("SELECT new com.jmv.dadosabertos.api.controller.dto.fornecedor.FornecedorItensDTO(" +
            "ni.descricaoProdutoServico, ni.unidadeMedida, ni.valorUnitario) " +
            "FROM NotaItem ni " +
            "JOIN ni.notaFiscal n " +
            "JOIN n.fornecedor f " +
            "WHERE f.id = :idFornecedor " +
            "GROUP BY ni.descricaoProdutoServico, ni.unidadeMedida, ni.valorUnitario " +
            "ORDER BY ni.descricaoProdutoServico")
    Page<FornecedorItensDTO> listarItensFornecedor(@Param("idFornecedor") Integer idFornecedor, Pageable pageable);

}

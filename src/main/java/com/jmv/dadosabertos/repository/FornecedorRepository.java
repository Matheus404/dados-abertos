package com.jmv.dadosabertos.repository;

import com.jmv.dadosabertos.api.controller.dto.dashboard.ValorTotalFornecedorNfAnoDTO;
import com.jmv.dadosabertos.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>,
        JpaSpecificationExecutor<Fornecedor> {

    @Query("SELECT new com.jmv.dadosabertos.api.controller.dto.dashboard.ValorTotalFornecedorNfAnoDTO(f.razaoSocial, f.cpfOuCnpj, SUM(n.valorNotaFiscal), f.uf) " +
           "FROM NotaFiscal n " +
           "JOIN n.fornecedor f " +
           "WHERE YEAR(n.dataEmissao) = :ano " +
           "GROUP BY f.id, f.razaoSocial, f.cpfOuCnpj, f.uf " +
           "ORDER BY SUM(n.valorNotaFiscal) DESC")
    List<ValorTotalFornecedorNfAnoDTO> fornecedorValorTotalAno(@Param("ano") int ano);

}

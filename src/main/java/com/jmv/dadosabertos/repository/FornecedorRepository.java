package com.jmv.dadosabertos.repository;

import com.jmv.dadosabertos.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>,
        JpaSpecificationExecutor<Fornecedor> {

}

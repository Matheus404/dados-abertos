package com.jmv.dados_abertos.repository;

import com.jmv.dados_abertos.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Integer> {

    Optional<NotaFiscal> findByChaveAcesso(String chaveAcesso);

}

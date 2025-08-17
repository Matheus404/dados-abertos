package com.jmv.dadosabertos.repository;

import com.jmv.dadosabertos.model.Orgao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao, Integer>,
        JpaSpecificationExecutor<Orgao> {

}

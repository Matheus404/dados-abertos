package com.jmv.dados_abertos.model;

import com.jmv.dados_abertos.enumeration.UnidadeFederativa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @Column(name = "id_fornecedor")
    private Integer id;

    @Column(name = "cpf_cnpj_emitente")
    private String cpfOuCnpj;

    @Column(name = "razao_social_emitente")
    private String razaoSocial;

    @Column(name = "inscricao_estadual_emitente")
    private String inscricaoEstadual;

    @Column(name = "uf_emitente", columnDefinition = "bpchar(2)")
    @Enumerated(EnumType.STRING)
    private UnidadeFederativa uf;

    @Column(name = "municipio_emitente")
    private String municipio;

    @Column(name = "mei")
    private boolean mei;

}

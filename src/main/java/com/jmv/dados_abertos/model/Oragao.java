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
@Table(name = "orgao_publico")
public class Oragao {

    @Id
    @Column(name = "id_orgao")
    private Integer id;

    @Column(name = "cnpj_destinatario")
    private  String cnpj;

    @Column(name = "nome_destinatario")
    private String nome;

    @Column(name = "uf_destinatario", columnDefinition = "bpchar(2)")
    @Enumerated(EnumType.STRING)
    private UnidadeFederativa uf;

    @Column(name = "indicador_ie_destinatario")
    private String indicadorContribuinte;

}

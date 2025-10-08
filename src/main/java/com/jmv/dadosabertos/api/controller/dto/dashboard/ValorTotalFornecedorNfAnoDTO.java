package com.jmv.dadosabertos.api.controller.dto.dashboard;

import com.jmv.dadosabertos.enumeration.UnidadeFederativa;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ValorTotalFornecedorNfAnoDTO {
    private String nome;
    private String cnpjOuCpf;
    private BigDecimal valorTotal;
    private String uf;

    public ValorTotalFornecedorNfAnoDTO(String nome, String cnpjOuCpf, BigDecimal valorTotal, UnidadeFederativa uf) {
        this.nome = nome;
        this.cnpjOuCpf = cnpjOuCpf;
        this.valorTotal = valorTotal;
        this.uf = uf.getNome();
    }
}

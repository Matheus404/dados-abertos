package com.jmv.dadosabertos.api.controller.dto.resumo;

import com.jmv.dadosabertos.enumeration.UnidadeFederativa;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ResumoNotasPorEstadoDTO {
    private UnidadeFederativa uf;
    private Long quantidadeNotas;
    private BigDecimal valorTotalNotas;

    public ResumoNotasPorEstadoDTO(UnidadeFederativa uf, Long quantidadeNotas, BigDecimal valorTotalNotas) {
        this.uf = uf;
        this.quantidadeNotas = quantidadeNotas;
        this.valorTotalNotas = valorTotalNotas;
    }

}

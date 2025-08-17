package com.jmv.dadosabertos.api.controller.dto.fornecedor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class FornecedorItensDTO {
    String descricaoProdutoServico;
    String unidadeMedida;
    BigDecimal valorUnitario;

    public FornecedorItensDTO(String descricaoProdutoServico, String unidadeMedida, BigDecimal valorUnitario) {
        this.descricaoProdutoServico = descricaoProdutoServico;
        this.unidadeMedida = unidadeMedida;
        this.valorUnitario = valorUnitario;
    }
}

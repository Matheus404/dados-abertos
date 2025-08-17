package com.jmv.dadosabertos.api.controller.dto.fornecedor;

import com.jmv.dadosabertos.enumeration.UnidadeFederativa;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class FornecedorDTO {
    private String cpfOuCnpj;
    private String razaoSocial;
    private String inscricaoEstadual;
    private UnidadeFederativa uf;
    private String municipio;
    private boolean mei;
    private Page<FornecedorItensDTO> itensPaginados;
}

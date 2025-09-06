package com.jmv.dadosabertos.api.controller.dto.dashboard;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResumoQuantidadesRegistrosDTO {
    private long quantidadeOrgaos;
    private long quantidadeFornecedores;
    private long quantidadeNotasFiscais;
}

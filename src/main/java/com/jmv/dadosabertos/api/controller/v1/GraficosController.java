package com.jmv.dadosabertos.api.controller.v1;

import com.jmv.dadosabertos.api.controller.dto.dashboard.ResumoNotasPorEstadoDTO;
import com.jmv.dadosabertos.api.controller.dto.dashboard.ResumoQuantidadesRegistrosDTO;
import com.jmv.dadosabertos.api.controller.dto.dashboard.ValorTotalFornecedorNfAnoDTO;
import com.jmv.dadosabertos.service.FornecedorService;
import com.jmv.dadosabertos.service.NotaFiscalService;
import com.jmv.dadosabertos.service.OrgaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/graficos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class GraficosController {

    private final NotaFiscalService notaFiscalService;
    private final FornecedorService fornecedorService;
    private final OrgaoService orgaoService;

    @GetMapping("/notas/uf/resumo")
    public List<ResumoNotasPorEstadoDTO> buscarResumoNotasPorEstadoApi() {
        return notaFiscalService.buscarResumoNotasPorEstadoService();
    }

    @GetMapping("contar/registros/resumo")
    public ResumoQuantidadesRegistrosDTO resumoQuantidadeRegistrosApi() {
        return ResumoQuantidadesRegistrosDTO.builder()
                .quantidadeOrgaos(orgaoService.quantidadeOrgaos())
                .quantidadeFornecedores(fornecedorService.quantidadeFornecedores())
                .quantidadeNotasFiscais(notaFiscalService.quantidadeNotasFiscais())
                .build();
    }

    @GetMapping("/fornecedores/valor-total")
    public List<ValorTotalFornecedorNfAnoDTO> fornecedorValorTotalAnoApi(@RequestParam int ano) {
        return fornecedorService.valorTotalPorFornecedor(ano);
    }

}

package com.jmv.dadosabertos.api.controller.v1;

import com.jmv.dadosabertos.api.controller.dto.resumo.ResumoNotasPorEstadoDTO;
import com.jmv.dadosabertos.service.NotaFiscalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/graficos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class GraficosController {

    private final NotaFiscalService notaFiscalService;

    @GetMapping("/notas/uf/resumo")
    public List<ResumoNotasPorEstadoDTO> buscarResumoNotasPorEstadoApi() {
        return notaFiscalService.buscarResumoNotasPorEstadoService();
    }

}

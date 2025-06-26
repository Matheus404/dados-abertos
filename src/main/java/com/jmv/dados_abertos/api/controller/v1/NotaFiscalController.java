package com.jmv.dados_abertos.api.controller.v1;

import com.jmv.dados_abertos.model.NotaFiscal;
import com.jmv.dados_abertos.service.NotaFiscalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/notas-fiscais")
@RequiredArgsConstructor
@CrossOrigin("*")
public class NotaFiscalController {

    private final NotaFiscalService notaFiscalService;

    @GetMapping
    public Page<NotaFiscal> listarNotasFiscaisApi(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        return notaFiscalService.listarNotasFiscais(page, size);
    }

    @GetMapping("/chave-acesso")
    public NotaFiscal buscarNotaFiscalPorChaveAcesso(@RequestParam String chaveAcesso) {
        return notaFiscalService.buscarNotaFiscalPorChaveAcesso(chaveAcesso);
    }

}

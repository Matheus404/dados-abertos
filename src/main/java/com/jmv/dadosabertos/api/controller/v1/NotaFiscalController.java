package com.jmv.dadosabertos.api.controller.v1;

import com.jmv.dadosabertos.api.controller.dto.dashboard.ValorTotalNfAnoDTO;
import com.jmv.dadosabertos.model.NotaFiscal;
import com.jmv.dadosabertos.service.NotaFiscalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1/notas-fiscais")
@RequiredArgsConstructor
@CrossOrigin("*")
public class NotaFiscalController {

    private final NotaFiscalService notaFiscalService;

    @GetMapping
    public Page<NotaFiscal> listarNotasFiscaisApi(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String cpfOuCnpjFornecedor,
            @RequestParam(required = false) String cnpjOrgao,
            @RequestParam(required = false) String nomeOrgao,
            @RequestParam(required = false) String razaoSocialFornecedor,
            @RequestParam(required = false) Integer numero
    ) {
        return notaFiscalService.listarNotasFiscaisFiltradas(
                page, size, cpfOuCnpjFornecedor, cnpjOrgao, nomeOrgao, razaoSocialFornecedor, numero);
    }

    @GetMapping("/chave-acesso")
    public NotaFiscal buscarNotaFiscalPorChaveAcesso(@RequestParam String chaveAcesso) {
        return notaFiscalService.buscarNotaFiscalPorChaveAcesso(chaveAcesso);
    }

    @GetMapping("/{id}")
    public NotaFiscal buscarNotaFiscalPorId(@PathVariable Integer id) {
        return notaFiscalService.findByIdNota(id);
    }

    @GetMapping("/valor-total-ano")
    public ValorTotalNfAnoDTO valorTotalNotasAnoApi(@RequestParam int ano) {
        BigDecimal valorTotal = notaFiscalService
                .valorTotalNotasPorAno(ano) == null ?
                    BigDecimal.ZERO : notaFiscalService.valorTotalNotasPorAno(ano);

        return new ValorTotalNfAnoDTO(valorTotal);
    }

}

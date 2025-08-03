package com.jmv.dadosabertos.api.controller.v1;

import com.jmv.dadosabertos.model.Fornecedor;
import com.jmv.dadosabertos.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/fornecedores")
@RequiredArgsConstructor
@CrossOrigin("*")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @GetMapping
    public Page<Fornecedor> listarFornecedoresApi(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String cpfOuCnpj,
            @RequestParam(required = false) String razaoSocial,
            @RequestParam(required = false) String uf,
            @RequestParam(required = false) Boolean mei
    ) {
        return fornecedorService.listarForneceedoresFiltrados(page, size, cpfOuCnpj, razaoSocial, uf, mei);
    }

}

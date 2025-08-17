package com.jmv.dadosabertos.api.controller.v1;

import com.jmv.dadosabertos.model.Orgao;
import com.jmv.dadosabertos.service.OrgaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orgaos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class OrgaoController {

    private final OrgaoService  orgaoService;

    @GetMapping
    public Page<Orgao> listarOrgaosApi(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String cnpj,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String uf
    ) {
        return orgaoService.listarOrgaosFiltrados(page, size, cnpj, nome, uf);
    }

}

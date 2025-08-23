package com.jmv.dadosabertos.service;

import com.jmv.dadosabertos.model.Orgao;
import com.jmv.dadosabertos.repository.OrgaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrgaoService {

    private final OrgaoRepository orgaoRepository;

    public Page<Orgao> listarOrgaosFiltrados(int page, int size,
                                             String cnpj,
                                             String nome,
                                             String uf
    ) {
        Specification<Orgao> spec = Specification.allOf();

        if (cnpj != null &&  !cnpj.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("cnpj"), cnpj));
        }

        if (nome != null && !nome.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%"));
        }

        if (uf != null && !uf.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("uf"), uf.toUpperCase()));
        }

        Pageable  pageable = PageRequest.of(page, size);
        return orgaoRepository.findAll(spec, pageable);
    }

}

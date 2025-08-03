package com.jmv.dadosabertos.service;

import com.jmv.dadosabertos.model.Fornecedor;
import com.jmv.dadosabertos.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public Page<Fornecedor> listarForneceedoresFiltrados(int page, int size,
                                                         String cpfOuCnpj,
                                                         String razaoSocial,
                                                         String uf,
                                                         Boolean mei
    ) {
        Specification<Fornecedor> spec = Specification.allOf();

        if (cpfOuCnpj != null && !cpfOuCnpj.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("cpfOuCnpj"), cpfOuCnpj));
        }

        if (razaoSocial != null && !razaoSocial.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("razaoSocial")), "%" + razaoSocial.toLowerCase() + "%"));
        }

        if (uf != null && !uf.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("uf"), uf));
        }


        if (mei != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("mei"), mei));
        }

        Pageable pageable = PageRequest.of(page, size);
        return fornecedorRepository.findAll(spec, pageable);
    }

}

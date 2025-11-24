package com.jmv.dadosabertos.service;

import com.jmv.dadosabertos.api.controller.dto.dashboard.ValorTotalFornecedorNfAnoDTO;
import com.jmv.dadosabertos.api.controller.dto.fornecedor.FornecedorDTO;
import com.jmv.dadosabertos.api.controller.dto.fornecedor.FornecedorItensDTO;
import com.jmv.dadosabertos.exception.EntidadeNaoEncontradaException;
import com.jmv.dadosabertos.mapper.FornecedorMapper;
import com.jmv.dadosabertos.model.Fornecedor;
import com.jmv.dadosabertos.model.NotaItem;
import com.jmv.dadosabertos.repository.FornecedorRepository;
import com.jmv.dadosabertos.repository.NotaItemRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;
    private final NotaItemRepository  notaItemRepository;
    private final FornecedorMapper fornecedorMapper;

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

    public FornecedorDTO buscarFornecedorPorId(Integer id, int page, int size) {
        Fornecedor fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                            String.format("Fornecedor não encontrado com id: %d", id))
                );

        Pageable pageable = PageRequest.of(page, size);
        Page<FornecedorItensDTO> itens = notaItemRepository.listarItensFornecedor(id, pageable);

        return fornecedorMapper.toDtoWithItens(fornecedor, itens);
    }

    public long quantidadeFornecedores() {
        return fornecedorRepository.count();
    }

    public List<ValorTotalFornecedorNfAnoDTO> valorTotalPorFornecedor(int ano) {
        return fornecedorRepository.fornecedorValorTotalAno(ano)
                .stream()
                .limit(100)
                .toList();
    }

}

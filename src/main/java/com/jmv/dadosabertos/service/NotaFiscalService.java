package com.jmv.dadosabertos.service;

import com.jmv.dadosabertos.api.controller.dto.resumo.ResumoNotasPorEstadoDTO;
import com.jmv.dadosabertos.exception.EntidadeNaoEncontradaException;
import com.jmv.dadosabertos.model.NotaFiscal;
import com.jmv.dadosabertos.repository.NotaFiscalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {

    private final NotaFiscalRepository notaFiscalRepository;

    public Page<NotaFiscal> listarNotasFiscais(int page, int size) {
        return notaFiscalRepository.findAll(PageRequest.of(page, size));
    }

    public NotaFiscal buscarNotaFiscalPorChaveAcesso(String chaveAcesso) {
        return notaFiscalRepository.findByChaveAcesso(chaveAcesso)
                .orElseThrow(() -> new RuntimeException("Nota fiscal não encontrada com a chave de acesso: " + chaveAcesso));
    }

    public Page<NotaFiscal> listarNotasFiscaisFiltradas(int page, int size,
                                                        String cpfOuCnpjFornecedor,
                                                        String cnpjOrgao,
                                                        String nomeOrgao,
                                                        String razaoSocialFornecedor,
                                                        Integer numero
    ) {
        Specification<NotaFiscal> spec = Specification.allOf();

        if (cpfOuCnpjFornecedor != null && !cpfOuCnpjFornecedor.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("cpfOuCnpjFornecedor"), cpfOuCnpjFornecedor));
        }

        if (cnpjOrgao != null && !cnpjOrgao.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("cnpjOrgao"), cnpjOrgao));
        }

        if (nomeOrgao != null && !nomeOrgao.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("orgaoPublico").get("nome")), "%" + nomeOrgao.toLowerCase() + "%"));
        }

        if (razaoSocialFornecedor != null && !razaoSocialFornecedor.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("fornecedor").get("razaoSocial")), "%" + razaoSocialFornecedor.toLowerCase() + "%"));
        }

        if (numero != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("numero"), numero));
        }

        Pageable pageable = PageRequest.of(page, size);
        return notaFiscalRepository.findAll(spec, pageable);
    }

    public NotaFiscal findByIdNota(Integer id) {
        return notaFiscalRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                                String.format("Nota fiscal não encontrada com id: %d", id)
                        )
                );
    }

    public List<ResumoNotasPorEstadoDTO> buscarResumoNotasPorEstadoService() {
        return notaFiscalRepository.buscarResumoNotasPorEstado();
    }

    public long quantidadeNotasFiscais() {
        return notaFiscalRepository.count();
    }

    public BigDecimal valorTotalNotasPorAno(int ano) {
        return notaFiscalRepository.valorTotalNotasPorAno(ano);
    }

}

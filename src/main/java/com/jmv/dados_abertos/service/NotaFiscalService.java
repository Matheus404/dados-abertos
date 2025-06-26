package com.jmv.dados_abertos.service;

import com.jmv.dados_abertos.model.NotaFiscal;
import com.jmv.dados_abertos.repository.NotaFiscalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
}

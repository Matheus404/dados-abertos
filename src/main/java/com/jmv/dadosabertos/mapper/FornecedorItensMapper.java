package com.jmv.dadosabertos.mapper;

import com.jmv.dadosabertos.api.controller.dto.fornecedor.FornecedorItensDTO;
import com.jmv.dadosabertos.model.NotaItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FornecedorItensMapper {
    FornecedorItensDTO toDto(NotaItem item);
    
    List<FornecedorItensDTO> toDtoList(List<NotaItem> itens);
}
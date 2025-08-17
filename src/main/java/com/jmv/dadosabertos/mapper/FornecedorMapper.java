package com.jmv.dadosabertos.mapper;

import com.jmv.dadosabertos.api.controller.dto.fornecedor.FornecedorDTO;
import com.jmv.dadosabertos.api.controller.dto.fornecedor.FornecedorItensDTO;
import com.jmv.dadosabertos.model.Fornecedor;
import com.jmv.dadosabertos.model.NotaItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface FornecedorMapper {

    @Mapping(target = "itensPaginados", source = "itensPage")
    FornecedorDTO toDtoWithItens(Fornecedor fornecedor, Page<FornecedorItensDTO> itensPage);

    @Named("toFornecedorItensDTO")
    FornecedorItensDTO notaItemToFornecedorItensDTO(NotaItem item);

    default Page<FornecedorItensDTO> mapPage(Page<NotaItem> page) {
        return page.map(this::notaItemToFornecedorItensDTO);
    }
}
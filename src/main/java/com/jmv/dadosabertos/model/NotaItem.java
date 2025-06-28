package com.jmv.dadosabertos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nota_item")
public class NotaItem {

    @Id
    @Column(name = "id_item")
    private Integer id;

    @Column(name = "chave_de_acesso")
    private String chaveAcesso;

    @Column(name = "numero_produto")
    private int numeroProduto;

    @Column(name = "descricao_do_produto_servico")
    private String descricaoProdutoServico;

    @Column(name = "codigo_ncm_sh")
    private String codigoNcmSh;

    @Column(name = "ncm_sh_tipo_de_produto", columnDefinition = "text")
    private String ncmShTipoDeProduto;

    @Column(name = "cfop")
    private String cfop;

    @Column(name = "quantidade")
    private BigDecimal quantidade;

    @Column(name = "unidade")
    private String unidadeMedida;

    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nota", foreignKey = @ForeignKey(name = "fk_nota"))
    @JsonIgnore
    private NotaFiscal notaFiscal;

}

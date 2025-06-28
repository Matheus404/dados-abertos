package com.jmv.dadosabertos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nota")
public class NotaFiscal {

    @Id
    @Column(name = "id_nota")
    private Integer id;

    @Column(name = "chave_de_acesso")
    private String chaveAcesso;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "serie")
    private String serie;

    @Column(name = "numero")
    private int numero;

    @Column(name = "natureza_da_operacao")
    private String naturezaOperacao;

    @Column(name = "data_emissao")
    private LocalDateTime dataEmissao;

    @Column(name = "evento_mais_recente")
    private String eventoRecente;

    @Column(name = "data_hora_evento_mais_recente")
    private LocalDateTime dataHoraEventoRecente;

    @Column(name = "cpf_cnpj_emitente")
    private String cpfOuCnpjFornecedor;

    @Column(name = "cnpj_destinatario")
    private String cnpjOrgao;

    @Column(name = "destino_da_operacao")
    private String destinoOperacao;

    @Column(name = "consumidor_final")
    private String consumidorFinal;

    @Column(name = "presenca_do_comprador")
    private String presencaComprador;

    @Column(name = "valor_nota_fiscal")
    private BigDecimal valorNotaFiscal;

    @OneToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

    @OneToOne
    @JoinColumn(name = "id_orgao")
    private Oragao orgaoPublico;

    @OneToMany(mappedBy = "notaFiscal")
    private List<NotaItem> itens;

}

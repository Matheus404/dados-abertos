-- Tabela fornecedor
CREATE TABLE fornecedor (
                            ID_FORNECEDOR INTEGER PRIMARY KEY,
                            CPF_CNPJ_Emitente VARCHAR(18) NOT NULL,
                            RAZAO_SOCIAL_EMITENTE VARCHAR(100),
                            INSCRICAO_ESTADUAL_EMITENTE VARCHAR(20),
                            UF_EMITENTE CHAR(2),
                            MUNICIPIO_EMITENTE VARCHAR(50),
                            MEI BOOLEAN
);

COPY fornecedor (
    cpf_cnpj_emitente,
    razao_social_emitente,
    inscricao_estadual_emitente,
    uf_emitente,
    municipio_emitente,
    id_fornecedor,
    mei
    )
    FROM 'C:\temp\notas\fornecedor.csv'
    WITH (FORMAT csv, DELIMITER ',', HEADER true, ENCODING 'UTF8');


-- Tabela orgao_publico
CREATE TABLE orgao_publico (
                               ID_ORGAO INTEGER PRIMARY KEY,
                               CNPJ_DESTINATARIO VARCHAR(18) NOT NULL,
                               NOME_DESTINATARIO VARCHAR(100),
                               UF_DESTINATARIO CHAR(2),
                               INDICADOR_IE_DESTINATARIO VARCHAR(50)
);

COPY orgao_publico (
    cnpj_destinatario,
    nome_destinatario,
    uf_destinatario,
    indicador_ie_destinatario,
    id_orgao
    )
    FROM 'C:\temp\notas\orgao_publico.csv'
    WITH (FORMAT csv, DELIMITER ',', HEADER true, ENCODING 'UTF8');

-- Tabela notas
CREATE TABLE nota (
                      ID_NOTA INTEGER PRIMARY KEY,
                      CHAVE_DE_ACESSO VARCHAR(44) NOT NULL,
                      MODELO VARCHAR(100),
                      SERIE VARCHAR(10),
                      NUMERO INTEGER,
                      NATUREZA_DA_OPERACAO VARCHAR(100),
                      DATA_EMISSAO TIMESTAMP,
                      EVENTO_MAIS_RECENTE VARCHAR(100),
                      DATA_HORA_EVENTO_MAIS_RECENTE TIMESTAMP,
                      CPF_CNPJ_Emitente VARCHAR(18),
                      CNPJ_DESTINATARIO VARCHAR(18),
                      DESTINO_DA_OPERACAO VARCHAR(50),
                      CONSUMIDOR_FINAL VARCHAR(20),
                      PRESENCA_DO_COMPRADOR VARCHAR(50),
                      VALOR_NOTA_FISCAL NUMERIC(15, 2),
                      ID_FORNECEDOR INTEGER REFERENCES fornecedor(ID_FORNECEDOR),
                      ID_ORGAO INTEGER REFERENCES orgao_publico(ID_ORGAO)
);

COPY nota (
    CHAVE_DE_ACESSO,
    MODELO,
    SERIE,
    NUMERO,
    NATUREZA_DA_OPERACAO,
    DATA_EMISSAO,
    EVENTO_MAIS_RECENTE,
    DATA_HORA_EVENTO_MAIS_RECENTE,
    CPF_CNPJ_Emitente,
    CNPJ_DESTINATARIO,
    DESTINO_DA_OPERACAO,
    CONSUMIDOR_FINAL,
    PRESENCA_DO_COMPRADOR,
    VALOR_NOTA_FISCAL,
    ID_FORNECEDOR,
    ID_ORGAO,
    ID_NOTA
    )
    FROM 'C:\temp\notas\notas_ajustada.csv'
    WITH (FORMAT csv, DELIMITER ',', HEADER true, ENCODING 'UTF8');

-- Tabela itens
CREATE TABLE nota_item (
                           ID_ITEM INTEGER PRIMARY KEY,
                           CHAVE_DE_ACESSO VARCHAR(44) NOT NULL,
                           NUMERO_PRODUTO INTEGER NOT NULL,
                           DESCRICAO_DO_PRODUTO_SERVICO TEXT,
                           CODIGO_NCM_SH VARCHAR(10),
                           NCM_SH_TIPO_DE_PRODUTO TEXT,
                           CFOP VARCHAR(10),
                           QUANTIDADE NUMERIC(15,4),
                           UNIDADE VARCHAR(20),
                           VALOR_UNITARIO NUMERIC(15,2),
                           VALOR_TOTAL NUMERIC(15,2),
                           ID_NOTA INTEGER NOT NULL,

                           CONSTRAINT fk_nota FOREIGN KEY (ID_NOTA) REFERENCES nota(ID_NOTA)
);

COPY nota_item (
    CHAVE_DE_ACESSO, NUMERO_PRODUTO, DESCRICAO_DO_PRODUTO_SERVICO,
    CODIGO_NCM_SH, NCM_SH_TIPO_DE_PRODUTO, CFOP, QUANTIDADE,
    UNIDADE, VALOR_UNITARIO, VALOR_TOTAL, ID_NOTA, ID_ITEM
    )
    FROM 'C:\temp\notas\itens_ajustado.csv'
    WITH (FORMAT csv, DELIMITER ';', HEADER true, ENCODING 'UTF8');

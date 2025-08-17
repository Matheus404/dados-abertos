-- TESTES DE CONSULTAS

SELECT COUNT(*) FROM fornecedor; -- 18.843

SELECT COUNT(*) FROM nota; -- 113.142

SELECT COUNT(*) FROM nota_item; -- 410.014

-- FORNECEDOR QUE MAIS VENDEU

SELECT
    f.razao_social_emitente,
    f.cpf_cnpj_emitente,
    f.uf_emitente,
    SUM(n.valor_nota_fiscal) AS valor_total
FROM
    fornecedor f
        LEFT JOIN nota n ON
        f.id_fornecedor = n.id_fornecedor
GROUP BY
    f.razao_social_emitente,
    f.cpf_cnpj_emitente,
    f.uf_emitente
ORDER BY
    valor_total DESC;

-- ORGÃO QUE MAIS GASTOU

SELECT
    o.nome_destinatario,
    o.cnpj_destinatario,
    o.uf_destinatario,
    SUM(n.valor_nota_fiscal) AS valor_total
FROM
    orgao_publico o
        LEFT JOIN nota n ON
        o.id_orgao = n.id_orgao
GROUP BY
    o.nome_destinatario,
    o.cnpj_destinatario,
    o.uf_destinatario
ORDER BY
    valor_total DESC;

-- GRAFICO QUANTIDADE DE NOTAS TOTAL + VALOR TOTAL POR UF

SELECT
  f.uf_emitente AS estado,
  COUNT(n.id_nota) AS quantidade_notas,
  SUM(n.valor_nota_fiscal) AS valor_total
FROM
  nota n
JOIN
  fornecedor f ON n.id_fornecedor = f.id_fornecedor
GROUP BY
  f.uf_emitente
ORDER BY
  quantidade_notas DESC;

-- NOTAS COMPLETO

SELECT
	n.id_nota,
	n.chave_de_acesso,
	n.data_emissao,
	n.numero,
	n.valor_nota_fiscal,
	f.razao_social_emitente,
	f.cpf_cnpj_emitente,
	f.uf_emitente,
	f.municipio_emitente,
	op.nome_destinatario,
	op.cnpj_destinatario,
	ni.descricao_do_produto_servico
FROM
	nota n
LEFT JOIN fornecedor f ON
	n.id_fornecedor = f.id_fornecedor
LEFT JOIN orgao_publico op ON 
	n.id_orgao = op.id_orgao
LEFT JOIN nota_item ni ON 
	n.id_nota = ni.id_nota;
	

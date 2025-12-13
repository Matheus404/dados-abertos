# Dados Abertos Brasil

API REST para consulta de dados abertos do Brasil.

## Sobre o Projeto

Esta aplicação web contou com um trabalho ETL no qual os dados disponibilizados de Notas Fiscais Eletrônicas do Governo Federal se tornaram um banco relacional, com Fornecedores, Órgãos, Notas e Itens da Nota.

Em cima desses dados foram criadas APIs REST que facilitam a visualização e consulta desses dados organizados.

### Frontend

O frontend desta aplicação está disponível em: [dados-abertos-cli](https://github.com/Matheus404/dados-abertos-cli)

## Requisitos

- Java 21
- Maven 3.6+
- PostgreSQL 12+ (veja instruções de setup abaixo)

## Configuração do Banco de Dados

O banco de dados PostgreSQL com Docker estará disponível na branch `docker`. Para utilizá-lo:

```bash
git checkout docker
```

Siga as instruções disponíveis naquela branch para subir o banco de dados.

## Configuração da Aplicação

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/dados-abertos.git
cd dados-abertos
```

2. Configure as credenciais do banco de dados no arquivo `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dados_abertos
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## Executando a Aplicação

### Via Maven

```bash
mvn spring-boot:run
```

### Via JAR

```bash
mvn clean package
java -jar target/dados-abertos-0.0.1-SNAPSHOT.jar
```

## Documentação da API

Após iniciar a aplicação, acesse a documentação interativa do Swagger em:

```
http://localhost:8082/swagger-ui.html
```

## Tecnologias

- Spring Boot 3.5.7
- Spring Data JPA
- PostgreSQL
- MapStruct 1.6.3
- Lombok
- SpringDoc OpenAPI (Swagger)

## Licença

Este projeto é de código aberto e está disponível para uso público.

---

**Nota:** Certifique-se de ter o PostgreSQL rodando antes de iniciar a aplicação. Para facilitar, utilize a configuração Docker disponível na branch `docker`.

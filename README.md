# Secure Password API

## Descrição do Projeto

Esta é uma API REST que valida a força de senhas, assegurando que elas atendam a critérios de segurança. A API foi desenvolvida em **Java 17** utilizando o **Spring Boot**.

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

- **DTO**: Classes que transportam dados entre processos. Utilizei DTOs tanto para encapsular a senha que será validada quanto para o corpo da resposta de falha.
- **Controller**: Gerencia as requisições HTTP e direciona as chamadas para os serviços apropriados.
- **Service**: Contém a lógica de negócio, incluindo a validação da senha usando expressões regulares (regex) para garantir que as senhas atendam aos critérios de segurança.

## Critérios de Segurança
A validação da senha considera os seguintes critérios:

- Mínimo de 8 caracteres.
- Pelo menos uma letra **maiúscula**.
- Pelo menos uma letra **minúscula**.
- Pelo menos um **dígito**.
- Pelo menos um **caractere especial**.

## Endpoint

### `POST /validate-password`

**Descrição**: Valida a segurança da senha enviada.

**Corpo da Requisição**:
```json
{
  "password": "sua_senha_aqui"
}
```
## Resposta
- **204: OK** se a senha for segura.
- **400: BAD REQUEST** se a senha não cumprir as validações.
```json
{
	"failures": [
		"A senha deve possuir pelo menos 08 caracteres.",
		"A senha deve possuir pelo menos uma letra maiúscula.",
		"A senha deve possuir pelo menos uma letra minúscula.",
		"A senha deve possuir pelo menos um digito numérico.",
		"A senha deve possuir pelo menos um caractere especial (e.g, !@#$%)."
	]
}
```
# Como Executar o Projeto

Para executar este projeto na sua máquina local, siga os passos abaixo:

## Pré-requisitos

- Java 17 instalado.
- Maven (ou Gradle) para gerenciamento de dependências.
- IDE (como IntelliJ IDEA ou Eclipse) para desenvolvimento.

## Passos

1. Clone o repositório:

```bash
git clone https://github.com/5alomao/secure-password-api.git
cd secure-password-api
```

2. Navegue até a pasta do projeto.

3. Execute o projeto com **Maven** ou **Gradle**
- Maven: `mvn spring-boot:run`
- Gradle: `gradle bootRun`

## Testes

Sinta-se à vontade para testar a API utilizando ferramentas como Postman, Insomnia ou cURL.

### Exemplo de Teste com cURL

```bash
curl -X POST http://localhost:8080/validate-password -H "Content-Type: application/json" -d '{"password": "SuaSenhaForte123!"}'
```

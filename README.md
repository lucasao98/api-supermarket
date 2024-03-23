# Projeto de API em Spring

Esse projeto utiliza Spring para gerenciar produtos de um supermercado, com a criação, exclusão, consulta e edição de produtos

## Modelo Fisico Banco de Dados
Essa modelagem para do banco de dados, conta com duas tabelas, uma tabela de ***Usuários*** com algumas informações essenciais para esse tipo de projeto como id do usuário, que nesse projeto foi utilizado o tipo INTEIRO para o id, nome do usuário, email, senha, se ele está ativo ou não, o cargo daquele usuário dentro do sistema, o numereo de contato do cliente, e seu cpf.

obs: Essa tabela poderia ser normalizada com a primeira forma normal(1FN) de banco de dados para garantir a atomicidade ao banco. 
Porém por questões de abstração não foi realizada essa normalização.

A outra tabela de ***Produtos***, contem dados importantes para a construção do sistema, como id do produto, nome, preço, data de vencimento, descrição data de fabricação do produto. Existe um campo chamado supplier_id, ele serve para identificar o fornecedor daquele produto. Nesse caso, como registrado na imagem, temos a cardinalidade 1:1, onde um produto possui um e somente um usuário e ele deve ter o cargo de fornecedor, porém o usuário pode ter relacionamento com um produto ou nenhum. 

## Tecnologias
  - H2 Database Engine: Banco de Dados em memória para facilitar a replicação em outras máquinas;
  - Spring;
  - JPA: Java Persistance API, para fazer a persistência dos dados no banco;
  - Flyway: Para gerenciar as migrations;
  - Lombok;
  - Maven: Gerenciador de Dependencias.

![Captura de tela de 2024-03-23 10-34-36](https://github.com/lucasao98/api-supermarket/assets/53714997/90c9a7c2-a6d9-443b-8cf5-ccd45f9b4685)



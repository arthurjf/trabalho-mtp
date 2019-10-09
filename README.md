# Trabalho MTP
Trabalho de MTP do IFG 2019/2
* Data de entrega
09/12/2019
#
## Criação da tabela "post"
**CREATE TABLE** post (id **SERIAL PRIMARY KEY**, texto **VARCHAR(140) NOT NULL**, imagem **bytea**, pessoa_id **int**, **FOREIGN KEY** (pessoa_id) **REFERENCES** pessoa(id), data **TIMESTAMP**);
#
## Criação da tabela "pessoa"
**CREATE TABLE** pessoa (id **SERIAL PRIMARY KEY**, nome **VARCHAR(100)**, email **VARCHAR(45)**, senha **VARCHAR(45)**, cidade_estado **VARCHAR(45)**, foto **bytea**);
#
# Requisitos do trabalho
- [X] O sistema deve permitir que, por meio de uma tela inicial, o usuário possa escolher se quer acessar o sistema ou cadastrar-se.

- [X] O  sistema  deve  permitir  que  o  usuário  possa  alterar seus dados.

- [ ] O sistema deve permitir que, após feito o login, o usuário possa visualizar uma tela com seus 03(três)últimosposts.A tela pode ter os contêineresfixosdos posts, mudando apenas os valores de acordo com os dados do banco de dados.

- [ ] O sistema deve permitir que o usuário possa criar um post. Um post poderá ser composto somente de texto, ou de texto e imagem.

- [ ] O sistema deverá mostrar o total de “likes” de cada post.

- [X] O sistema deve tratar as mensagens de erro e devolvê-lasde forma amigável ao usuário.

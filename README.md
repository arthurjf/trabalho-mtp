# Trabalho MTP
Trabalho de MTP do IFG 2019/2
* Data de entrega 09/12/2019

## Criação da tabela "post"
**CREATE TABLE** post (id **SERIAL PRIMARY KEY**, texto **VARCHAR(140) NOT NULL**, imagem **bytea**, pessoa_id **int**, **FOREIGN KEY** (pessoa_id) **REFERENCES** pessoa(id), data **TIMESTAMP**);

## Criação da tabela "pessoa"
**CREATE TABLE** pessoa (id **SERIAL PRIMARY KEY**, nome **VARCHAR(100) NOT NULL**, email **VARCHAR(45) NOT NULL**, senha **VARCHAR(45)**, cidade_estado **VARCHAR(45) NOT NULL**, foto **bytea**, **UNIQUE(**email**)**);

## Criação da tabela "like_post"
create table like_post (id serial PRIMARY KEY NOT NULL, pessoa_id int, post_id int, data TIMESTAMP, FOREIGN KEY (pessoa_id) REFERENCES pessoa(id), FOREIGN KEY (post_id) REFERENCES post(id));

# Requisitos e regras do trabalho
- [X] O sistema deve permitir que, por meio de uma tela inicial, o usuário possa escolher se quer acessar o sistema ou cadastrar-se.

- [X] O  sistema  deve  permitir  que  o  usuário  possa  alterar seus dados.

- [X] O sistema deve permitir que, após feito o login, o usuário possa visualizar uma tela com seus 03(três) últimos posts. 

- [X] A tela pode ter os contêineres fixos dos posts, mudando apenas os valores de acordo com os dados do banco de dados.

- [X] O sistema deve permitir que o usuário possa criar um post. Um post poderá ser composto somente de texto, ou de texto e imagem.

- [ ] O sistema deverá mostrar o total de “likes” de cada post.

- [X] O sistema deve tratar as mensagens de erro e devolvê-las de forma amigável ao usuário.

- [X] E-mails devem ser únicos. O acesso ao sistema deve ser feito por meio do endereço de e-mail.

- [X] O usuário não poderá alterar seu e-mail.

- [X] Cada post não poderá ter mais que 140 caracteres.

- [X] Um post pode conter somente uma imagem.

- [X] Somente usuários logados podem criar e “dar like” em posts.

- [X] As fotos dos posts podem ser fixas e obtidas diretamente do ~~disco rígido~~ banco de dados.

- [X] *{EXTRA}* Gravar as imagens no banco de dados ao invés do disco rígido.

- [X] *{EXTRA}* Permitir que o usuário possa, em seu cadastro, inserir sua foto.

- [X] *{EXTRA}* Ao invés de utilizar contêineres fixos, construí-los de forma dinâmica de acordo com a lista buscada do banco de dados.

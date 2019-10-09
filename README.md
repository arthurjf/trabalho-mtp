# Trabalho MTP
Trabalho de MTP do IFG 2019/2

* Data de entrega
09/12/2019

## Criação da tabela post
CREATE TABLE post (id SERIAL PRIMARY KEY, texto VARCHAR(140) NOT NULL, imagem bytea, pessoa_id int, FOREIGN KEY (pessoa_id) REFERENCES pessoa(id), data TIMESTAMP);

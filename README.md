# 🍔 Sistema de Delivery em Java

## 📌 Sobre o Projeto

Este projeto é um sistema de delivery desenvolvido em **Java**, com integração em um banco de dados, permitindo o gerenciamento de pedidos, funcionários, clientes e produtos.

O objetivo do sistema é simular uma aplicação real de delivery, aplicando conceitos de:

- Programação Orientada a Objetos (POO)
- Integração com banco de dados PostgreSQL
- CRUD's completos
- Boas práticas com OO, MVC e interfaces coerentes

---

# 🚀 Funcionalidades

- ✅ Cadastro de clientes
- ✅ Cadastro de produtos
- ✅ Cadastro de funcionários
- ✅ Gerenciamento de pedidos
- ✅ Integração com banco de dados
- ✅ Consulta de cadastros
- ✅ Atualização de status
- ✅ Exclusão de registros

---

# 🛠️ Tecnologias Utilizadas

## Banco de Dados
- PostgreSQL 

## Creates utilizados

CREATE TABLE clientes(
id SERIAL PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
telefone CHAR(11) NOT NULL,
cpf CHAR(11) UNIQUE NOT NULL,
endereco VARCHAR(255) NOT NULL
);

CREATE TABLE funcionarios(
id SERIAL PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
cpf CHAR(11) NOT NULL,
telefone CHAR(11) NOT NULL,
funcao VARCHAR(255) NOT NULL,
salario NUMERIC NOT NULL
);

CREATE TABLE produtos(
id SERIAL PRIMARY KEY,
descricao VARCHAR(255),
preco NUMERIC NOT NULL,
estoque NUMERIC NOT NULL
);

CREATE TABLE pedidos(
id SERIAL PRIMARY KEY,
cliente_id INT NOT NULL,
funcionario_id INT NOT NULL,
data_pedido VARCHAR(255) NOT NULL,
status CHAR(1) NOT NULL,
forma_pagamento VARCHAR(255) NOT NULL,
observacoes VARCHAR(255),
FOREIGN KEY (cliente_id) REFERENCES clientes(id),
FOREIGN KEY (funcionario_id) REFERENCES funcionarios(id)
);

CREATE TABLE produtosPedido(
id SERIAL PRIMARY KEY,
pedido_id INT NOT NULL,
produto_id INT NOT NULL,
preco NUMERIC NOT NULL,
quantidade NUMERIC NOT NULL,
FOREIGN KEY (pedido_id) REFERENCES pedidos(id),
FOREIGN KEY (produto_id) REFERENCES produtos(id)
);

---

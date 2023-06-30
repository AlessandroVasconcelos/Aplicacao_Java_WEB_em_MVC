# Aplicação Java WEB em Model-View-Controller

Este projeto consiste em uma aplicação Java para web que segue a arquitetura MVC (Model-View-Controller). A aplicação permite o gerenciamento de informações relacionadas a carros e seus proprietários, com recursos de inserção, alteração e remoção de dados. A camada de visualização é implementada em XHTML, enquanto o Model e o Controller são implementados em Java.

## Versões do Projeto

O projeto é dividido em duas versões, cada uma com uma forma diferente de armazenamento dos dados:

### Projeto 01

Nesta versão, os dados são armazenados em uma estrutura de dados do tipo ArrayList. Isso significa que as informações dos carros e proprietários são mantidas em memória durante a execução da aplicação. 

### Projeto 02

Nesta versão, os dados são armazenados em um banco de dados. O projeto inclui um arquivo chamado "veiculos.sql", que contém o esquema do banco de dados necessário para armazenar as informações dos carros e proprietários.

## Executando o Projeto 02

Para executar o Projeto 02, siga os passos a seguir:

Preparação do Banco de Dados "veiculos":
1. Execute o XAMPP Control Panel e inicie como administrador o serviço do MySQL.
2. Crie um novo banco de dados chamado "producao".
3. Importe o arquivo "veiculos.sql" para o banco de dados criado.
4. Verifique se o banco de dados foi criado corretamente com suas respectivas tabelas.

Configuração da conexão do NetBeans com o Banco de Dados:
1. Baixe o arquivo "mysql-connector-java-8.0.11.jar".
2. No NetBeans, acesse a aba "Services".
3. Clique com o botão direito em "Databases" e selecione "New Connection".
4. Escolha "MySQL (Connector/J Driver)".
5. Adicione o arquivo do connector 8 que você baixou e clique em "Next".
6. No campo "Database", insira "veiculos" e depois clique em "Next".

Execução da aplicação:
1. No NetBeans, abra o projeto "Projeto_02_Banco_de_Dados".
2. Clique com o botão direito do mouse no projeto e vá em "Propriedades".
3. Em "Run", confirme que o servidor é o GlassFish Server e clique em "OK".
4. Em "Web Pages", clique com o botão direito do mouse em "index.xhtml" e selecione "Run File".

## Tecnologias Utilizadas

- IDE: Apache NetBeans 13.0
- Servidor de Aplicação: GlassFish Server 5.1.0
- Servidor de Banco de Dados: XAMPP v3.3.0
- Linguagem: Java 8

# Aplicação Java WEB em Model-View-Controller

Este projeto consiste em uma aplicação Java para web que segue a arquitetura MVC (Model-View-Controller), assim a camada de visualização é implementada em XHTML, enquanto o Model e o Controller são implementados em Java. A aplicação permite o gerenciamento de informações relacionadas a carros e seus proprietários, com recursos de inserção, alteração e remoção de dados. Tendo em vista, que inclue as seguintes entidades:
- Proprietario(id, nome, cpf) 
- Carro(id, placa, marca, modelo, proprietarioId)     

## Versões do Projeto

O projeto é dividido em duas versões, cada uma com uma forma diferente de armazenamento dos dados:

### Projeto 01 (ArrayList)

Nesta versão, os dados são armazenados em uma estrutura de dados do tipo ArrayList. Isso significa que as informações dos carros e proprietários são mantidas em memória durante a execução da aplicação. 

### Projeto 02 (Banco de Dados)

Nesta versão, os dados são armazenados em um banco de dados. O projeto inclui um arquivo chamado "veiculos.sql", que contém o esquema do banco de dados necessário para armazenar as informações dos carros e proprietários.

## Executando o Projeto 02

Para executar o Projeto 02, siga os passos a seguir:

Preparação do Banco de Dados "veiculos":
1. Execute o XAMPP Control Panel e inicie como administrador o serviço do MySQL.
2. Crie um novo banco de dados chamado "producao".
3. Importe o arquivo ["veiculos.sql"](https://github.com/AlessandroVasconcelos/Aplicacao_Java_WEB_em_MVC/blob/main/Projeto%2002%20(Banco%20de%20Dados)/veiculos.sql) para o banco de dados criado.
4. Verifique se o banco de dados foi criado corretamente com suas respectivas tabelas.

Configuração da conexão do NetBeans com o Banco de Dados:
1. Baixe o arquivo ["mysql-connector-java-8.0.11.jar"](https://github.com/AlessandroVasconcelos/Aplicacao_Java_WEB_em_MVC/blob/main/Projeto%2002%20(Banco%20de%20Dados)/mysql-connector-java-8.0.11.jar).
2. No NetBeans, acesse a aba "Services".
3. Clique com o botão direito em "Databases" e selecione "New Connection".
4. Escolha "MySQL (Connector/J Driver)".
5. Adicione o arquivo do connector 8 que você baixou e clique em "Next".
6. No campo "Database", insira "veiculos" e depois clique em "Next".

Execução da aplicação:
1. No NetBeans, abra o projeto ["Projeto_02_Banco_de_Dados"](https://github.com/AlessandroVasconcelos/Aplicacao_Java_WEB_em_MVC/tree/main/Projeto%2002%20(Banco%20de%20Dados)/Projeto_02_Banco_de_Dados).
2. Clique com o botão direito do mouse no projeto e vá em "Propriedades".
3. Em "Run", confirme que o servidor é o GlassFish Server e clique em "OK".
4. Em "Web Pages", clique com o botão direito do mouse em "index.xhtml" e selecione "Run File".

## Tecnologias Utilizadas

- <a href ="https://netbeans.apache.org/download/nb13/nb13.html"><img src="https://img.shields.io/badge/IDE:%20apache%20netbeans 13-1B6AC6?style=for-the-badge&logo=apache%20netbeans%20IDE&logoColor=white"></a>
- <a href ="https://www.oracle.com/middleware/technologies/glassfish-downloads.html"><img src="https://img.shields.io/badge/Servidor%20de%20Aplica%C3%A7%C3%A3o:%20GlassFish%20Server%205.1.0-5B0AC6?style=for-the-badge&logo=apache%20netbeans%20IDE&logoColor=white"></a>
- <a href ="https://sourceforge.net/projects/xampp/files/XAMPP%20Windows/8.2.0/xampp-windows-x64-8.2.0-0-VS16-installer.exe/download"><img src="https://img.shields.io/badge/Servidor%20de%20Banco%20de%20Dados:%20XAMPP%208.2.0-600?style=for-the-badge&logo=xampp"></a>
- <a href ="https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html"><img src="https://img.shields.io/badge/Linguagem:%20Java%208-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"></a>

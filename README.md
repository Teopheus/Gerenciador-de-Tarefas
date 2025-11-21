# Gerenciador de Tarefas (Java + SQLite)

Aplicação de linha de comando (CLI) para gerenciamento de tarefas (To-Do List), implementando persistência de dados com banco de dados relacional **SQLite**.

O projeto foi desenvolvido para aplicar conceitos fundamentais de **JDBC (Java Database Connectivity)** e o padrão de arquitetura **DAO (Data Access Object)**.

## Funcionalidades

- **Adicionar Tarefa:** Insere novos registros no banco de dados.
- **Listar Tarefas:** Consulta (SELECT) e exibe todos os dados persistidos.
- **Excluir Tarefa:** Remove registros através do ID.
- **Persistência Real:** Os dados não são perdidos ao fechar o programa, pois ficam salvos no arquivo local `banco_tarefas.db`.

## Tecnologias e Conceitos

- **Java 17+**
- **SQLite:** Banco de dados relacional leve (Serverless).
- **JDBC:** API padrão para conexão Java com Banco de Dados.
- **Padrão DAO:** Separação da lógica de negócios da lógica de acesso a dados.

## Como Rodar

Este projeto requer o driver JDBC do SQLite. O arquivo `sqlite-jdbc-3.42.0.0.jar` (ou versão similar) deve estar na raiz do projeto.

1. **Compile o código:**
   (Windows)
   ```bash
   javac -cp ".;sqlite-jdbc-3.42.0.0.jar" *.java

  (Linux + Mac)
  javac -cp ".:sqlite-jdbc-3.42.0.0.jar" *.java

2. **Execute a aplicação:** (Windows)
   java -cp ".;sqlite-jdbc-3.42.0.0.jar" Principal

   (Linux + Mac)
   java -cp ".:sqlite-jdbc-3.42.0.0.jar" Principal

   

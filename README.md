# LiterAlura: Catálogo de Livros

Bem-vindo ao desafio LiterAlura, onde você terá a oportunidade de desenvolver um catálogo de livros interativo. 
Este projeto é projetado para melhorar suas habilidades em manipulação de APIs, 
gerenciamento de dados JSON e interação com bancos de dados, tudo enquanto cria uma interface de usuário no console.

### Objetivo

O objetivo deste projeto é desenvolver um Catálogo de Livros que permite a interação textual com os usuários, 
oferecendo pelo menos 5 opções de interação. Os livros serão obtidos através de uma API específica, que será detalhada nas etapas seguintes. 
Os usuários poderão filtrar e explorar livros e autores de interesse, tornando a experiência informativa e envolvente.

### Tecnologias Utilizadas

- Java
- Spring Boot 
- Maven
- Project Gutenberg  : API utilizada para obter Lista de Livros.
- Json : Utilizar biblioteca Jackson para ler e interpretar Json.
- PostgreSQL : Banco de Dados.

### Funcionalidades Principais

1. Buscar Livros via API: Realizar solicitações a uma API de livros para obter dados atualizados.
2. Manipulação de Dados JSON: Analisar e processar as respostas em formato JSON fornecidas pela API.
3. Armazenamento em Banco de Dados: Inserir e consultar os dados no banco de dados para uma gestão eficiente das informações.
4. Interação com Usuários: Fornecer pelo menos 5 opções de interação através do console, como buscar livros, listar autores, filtrar por categorias, etc.
5. Exibição de Resultados: Apresentar de forma clara e organizada os resultados das consultas aos usuários.

### Pré-requisitos

- Java (versão 17 em diante)
- Maven (Initializr utiliza a versão 4)
- Spring Boot (versão 3.2.3)
- Spring Data JPA 
- Postgres Driver
- Internet (para acessar a API de Livros)
## 2024-06-26 - Configurações do banco de dados
Foi configurado o arquivo [application.properties](.\src\main\resources\application.properties) para estabelecer conexão com o banco de dados. Foram usados os seguintes parâmetros:
```
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/listadetarefas?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Onde:
- **spring.datasource.driver-class-name:** Define a classe do driver JDBC para MySQL.

- **spring.datasource.url:** URL de conexão com o banco de dados MySQL no localhost na porta 3306. O parâmetro createDatabaseIfNotExist=true indica que o banco de dados será criado se não existir.

- **spring.datasource.username:** Nome de usuário para acessar o banco de dados (neste caso, 'root').

- **spring.datasource.password:** Senha do usuário do banco de dados (neste caso, 'root').

- **spring.jpa.hibernate.ddl-auto:** Define o comportamento do Hibernate ao inicializar o banco de dados. Neste caso, 'update' permite que o Hibernate atualize automaticamente o esquema do banco de dados com base nas entidades.

- **spring.jpa.show-sql:** Habilita a exibição de SQL gerado pelo Hibernate no console para fins de depuração.



## 2024-06-25 - Dependências
Inicialmente, foram baixadas as dependências necessárias do Spring Boot. As dependências incluem

- **Spring Boot Starter Data JPA:** Fornece suporte ao uso do JPA (Java Persistence API) para interação com banco de dados relacional.

- **Spring Boot Starter Web:** Oferece suporte para o desenvolvimento de APIs web utilizando o Spring MVC.

- **Spring Boot DevTools:** Facilita o desenvolvimento fornecendo recursos como reinicialização automática da aplicação.

- **H2 Database:** Banco de dados em memória, adequado para ambiente de desenvolvimento.

- **MySQL Connector:** Driver JDBC para MySQL, usado para conectar a aplicação a um banco de dados MySQL em ambiente de produção.

- **Spring Boot Starter Test:** Contém dependências necessárias para testes unitários e de integração com Spring Boot.

Para configurar o projeto, criado o arquivo [pom.xml](./pom.xml) e foi utilizado o Maven como gerenciador de dependências e build.
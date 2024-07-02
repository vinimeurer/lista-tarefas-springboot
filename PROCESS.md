## 2024-07-01 Criação do modelo de usuário
Foi criado o arquivo [Usuario.java](./src/main/java/com/listadetarefas/listadetarefas/models/Usuario.java) e nele foi usado o framework Jakarta Persistence (JPA) para mapeamento objeto-relacional e Bean Validation para validação de dados. Também foi importada a dependência `Starter-validation`para validar os dados

		<dependency>
    		<groupId>org.springframework.boot</groupId>
    		<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>




#### Classe `Usuario`

A classe `Usuario` representa um usuário na aplicação e possui os seguintes atributos:

- `id`: Identificador único do usuário, gerado automaticamente.
- `nomeusuario`: Nome do usuário, utilizado como identificador de login.
- `senha`: Senha do usuário, armazenada com hash e protegida de acesso direto.

#### Anotações de JPA

- `@Entity`: Indica que a classe é uma entidade JPA, mapeada a uma tabela no banco de dados.
- `@Table(name = "usuario")`: Especifica o nome da tabela no banco de dados associada à entidade `Usuario`.
- `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)`: Define que o campo `id` é a chave primária, com geração automática de valor.
- `@Column`: Especifica detalhes da coluna no banco de dados, como nome, tamanho e restrições de nulidade.

#### Anotações de Validação

- `@NotNull`, `@NotEmpty`: Garantem que os campos `nomeusuario` e `senha` não sejam nulos ou vazios.
- `@Size(min = 2, max = 100)`, `@Size(min = 8, max = 60)`: Define os tamanhos mínimos e máximos para `nomeusuario` e `senha`, respectivamente.

#### JSON Property

- `@JsonProperty(access = Access.WRITE_ONLY)`: Garante que a senha seja serializada apenas para operações de escrita (não é retornada nas consultas).

#### Construtores e Métodos Auxiliares

- Construtores: `Usuario()`, `Usuario(Long id, String nomeusuario, String senha)`.
- Getters e setters para todos os campos.

#### Métodos Sobrescritos

- `equals(Object obj)`: Sobrescrito para comparar objetos `Usuario` baseado nos campos `id`, `nomeusuario` e `senha`.
- `hashCode()`: Sobrescrito para calcular o código hash baseado no `id`.

#### Exemplo de Objeto JSON

Abaixo está um exemplo de como um objeto `Usuario` seria representado em JSON:

```json
{
  "id": 1,
  "nomeusuario": "fulano123",
  "senha": "********"
}
```


## 2024-06-26 - Configurações do banco de dados
Foi configurado o arquivo [application.properties](./src/main/resources/application.properties) para estabelecer conexão com o banco de dados. Foram usados os seguintes parâmetros:
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
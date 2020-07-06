# Instruções para instalação do Back-end
* Baixar os arquivos da pasta backend
* Se possível utilizar a IDE Eclipse para importar o projeto como Maven
* Instalar as dependências (Se for no Eclipse esse passo executará automaticamente)
* Configurar um banco de dados postgresSQL na porta 5432
* Criar uma Base de dados com o nome "desafio_finances"
* Editar o arquivo "application.properties" na pasta "src/main/resources"

````
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

spring.datasource.url= jdbc:postgresql://localhost:5432/desafio_finances

spring.datasource.username=nome_exemplo

spring.datasource.password=senha_exemplo

spring.jpa.hibernate.ddl-auto=update

spring.datasource.driverClassName=org.postgresql.Driver

````
 * Entrar na pasta "src/main/java", no pacote "com.desafio.apifinances" rodar o arquivo da pasta como Java Application

# Instruções para instalação do Front-end

* Baixar a pasta do projeto frontend
* Rodar o comando yarn para instalar todas as dependências
* Rodar o comando yarn serve para iniciar o servidor de desenvolvimento

Made with 💜 by [Arthur Ramires](https://github.com/arthurramires) 🚀
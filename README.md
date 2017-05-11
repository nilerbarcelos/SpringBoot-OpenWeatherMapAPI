# Integração SpringBoot OpenWeatherMap API

**Back-end**
  - Foi utilizado Spring Boot que atualmente é um framework com bastante aderência no mercado, isso facilita por ele disponibilizar toda infraestrutura de container embarcada;
  - A API é acessada através do service para realizar a persistencia dos dados;
  - Na classe CidadeService são declarados os métodos e também é realizado a injeção de dependência da classe CidadeRepository, para realizar as operações no Banco de Dados;
  - Na classe CidadeController é realizada a injeção de dependência da classe CidadeService e o mapeamento das chamadas realizadas na aplicação, assim todas as camadas se integram. Todo o trafego é realizado através de JSON;

**Front-end**
  - Para implementar o front-end utilizei thymeleaf, angularjs e bootstrap.

**Banco de dados utilizado: MySQL**
  - Criar um banco chamado: `cidadesdb`
  - Usuário: `root`
  - Senha: 
  
  **Executando o Projeto**
  - Realizar clone: `git clone https://github.com/nilerbarcelos/SpringBoot-OpenWeatherMapAPI.git`
  - Acessar o diretório onde o projeto foi clonado
  - Executar o comando: `mvn package && java -jar target/testeHbsis-0.0.1-SNAPSHOT.jar`
  - Acessar o projeto no browser através do endereço: `http://localhost:8080/`

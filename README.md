<img alt="logo Tomorrow Tech Talents" src="https://github.com/joaomhernandes/TomorrowTechTalents/blob/main/assets/TomorrowTechTalentsLogo.svg" style="width: 300%, height: auto, margin-left: auto, margin-left: auto" />


# Tomorrow Tech Talents

## PROGRAMAÇÃO WEB II - Projeto LetsGoal

### Descrição

- Será desenvolvido uma API para criação de um time de futebol utilizando a base de dados do Cartola.
- As classes e regras de negócio seguiram o descrito no diagrama abaixo:

<img alt="Diagrama do projeto Let's Goal" src="https://github.com/hugobrendow/letsgoal/tree/joaomhernandes/assets/diagrama.svg" style="width: 300%, height: auto, margin-left: auto, margin-left: auto" />


### Tecnologias utilizadas

- Spring boot;
- API REST;
- PostgreSQL;
- Docker.

### Desenvolvimento em aula

- Iniciado o projeto através do [Spring initialize](https://start.spring.io/), adicionando-se as dependencias:
  - Spring Web;
  - Spring Data;
  - Spring Boot DevTools ;
  - Lombok.
  - Swagger2

- Criado os pacotes model e controller. 
  - Em model, foram criadas as classes Formacao, Patrocinador e Posicao.
  - Em Controller foram criadas as classes FormacaoController e PatrocinadorController.
- Criado os pacotes Repository e Service
- Desenvolvido as funcionalidades savePatrocinador, findAll e findById para a classe Patrocinador.
- Criado endpoint "/patrocinadores".
- Criado Exception para PatrocinadorNotFoundException.
- Feito a integração com o banco de dados PostgreSQL.
- Adicionada a dependencia do Swagger2 e realizada a sua configuração. (Acessar por: [Swagger-ui](http://localhost:8081/swagger-ui.html)).
- Criada a exception DadoExistenteException para os casos de tentativa de criação de dados em duplicidade.

### Desenvolvimento fora da aula

- Adicionado no pacote model as classes Clube, Escudo, Jogador, LetsClube, Mercado e Partida, e no pacote controller a classe LetsClubeController.
- Desenvolvido a funcionalidade updatePatrocinador.
- Desenvolvido as camadas Service, Controller e Repository para as classes Clube, Escudo, Jogador e LetsClube com as funções do CRUD solicitadas.
- Criadas Exceptions paras as "Classe"NotFoundException
- Dividido a camada Service de todas as classes numa ‘interface’, Service, e uma classe que a implementa, ServiceImp. 
- Individualizado o logger por Controller.
- Criado DTOs para todas as entidades.
- Controllers passam a devolver uma response como DTO.
- Criado o relacionamento entre entidades.
- Criado constraints para validação dos dados de entrada.

### Integração do projeto

- Integrado o projeto com a API do Cartola.
- Criado DTOs para a entrada de dados provenientes da api do Cartola.
- Criado O Cliente Http para requisição dos clubes e jogadores.
- Criado a classe que carrega as informações do Cartola ao iniciar a aplicação.
- Criado o serviço para salvar as listas de clubes, escudos e jogadores, adiquiridos da API do Cartola, no banco de dados.

### Pendencias

- Ao realizar a integração com a API do Cartola, a aplicação apresentou erro, que ainda não consegui solucionar. (TODO).
- Devido à falha apresentada, ficou pendente a implementação de algumas regras de negócio passadas pelo professor em aula.


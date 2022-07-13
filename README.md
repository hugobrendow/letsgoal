<img alt="Logo Tomorrow Tech Talents" src="https://github.com/joaomhernandes/TomorrowTechTalents/blob/main/assets/TomorrowTechTalentsLogo.svg" style="width: 300%, height: auto, margin: auto" width="300"/>

# Tomorrow Tech Talents

## PROGRAMAÇÃO WEB II - Projeto LetsGoal

### Descrição

- Será desenvolvido uma API para criação de um time de futebol utilizando a base de dados do Cartola.
- As classes e regras de negócio seguiram o descrito no diagrama abaixo:
![](https://github.com/hugobrendow/letsgoal/tree/joaomhernandes/assets/diagrama.png)

### Tecnologias utilizadas

- Spring boot;
- API REST;
- PostgreSQL;
- Docker.

### Desenvolvimento em aula

- Iniciado o projeto através do [Spring initialize](https://start.spring.io/), adicionando-se as dependencias:
  - Spring Web;
  - Spring Boot DevTools ;
  - Lombok.

- Criado os pacotes model e controller. 
  - Em model, foram criadas as classes Formacao, Patrocinador e Posicao.
  - Em Controller foram criadas as classes FormacaoController e PatrocinadorController.
- Criado os pacotes Repository e Service
- Desenvolvido as funcionalidades savePatrocinador, findAll e findById para a classe Patrocinador.
- Criado endpoint "/patrocinadores".
- Feito a integração com o banco de dados PostgreSQL

### Desenvolvimento fora da aula

- Adicionado no pacote model as classes Clube, Escudo, Jogador, LetsClube, Mercado e Partida, e no pacote controller a classe LetsClubeController.
- Desenvolvido a funcionalidade updatePatrocinador.
- Desenvolvido as camadas Service, Controller e Repository para as classes Clube, Escudo, Jogador e LetsClube com as funções do CRUD solicitadas.
- Dividido a camada Service de todas as classes numa interface, Service, e uma classe que a implementa, ServiceImp.  

### Integração do projeto


# Gestão de logística 
Esse microsserviço cuida das operações de logística comuns a um site de vendas online


## Pré requisitos

Para executar a aplicação localmente é preciso usar :

-   Java 17
-   Maven
- Docker Compose 


Utilizar fazer o comando

```
mvn clean install 

```
Depois executar o comando: 

    docker-compose up -d 

Para a criação do container de execução do projeto. 
**Pontos de atenção:**  Importante adaptar os dados do application.properties/docker-compose para os dados da base existentes localmente. O projeto está criado e configurado para as credenciais da base local.
 

 - É preciso adaptar a variável GOOGLE_API_KEY para a execução dos endpoints listados. 

### Tecnologias Usadas


-   Para o desenvolvimento do batch foi usado :
-   Spring Web
-   Spring JPA
-   Kafka
-  Spring Stream 
-   PostgreSQL

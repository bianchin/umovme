# umovme





### PROBLEM

Calcule os seguintes descontos para as entradas dado o preço dos ingressos:

- Crianças: R$ 5.50
- Estudantes: R$ 8.00
- Idosos: R$ 6.00

Segunda-Feira:
- 10% para todos(crianças, idosos, estudantes)

Terça-Feira:
- 15% idosos e crianças;
- 5% estudantes;

Quarta-Feira:
- 40% idosos
- 30% crianças
- 50% estudantes

Quinta-Feira
- 30% idosos e estudantes

Sexta-Feira
- 11% crianças

Domingo/Sábados/Feriados
- 5% Idosos

OBS1.: Todo estudante mediante apresentação da carteirinha de estudante
possui para todos os dias da semana, exceto finais de semana,
35% de desconto em todos os ingressos;

OBS2.: Descontos não são cumulativos

### RUN
mvn spring-boot:run


### RUN by Docker

docker build  -t umovme .

docker run -p 8080:8080 umovme



### DOC
http://localhost:8080/swagger-ui/index.html

#### EXAMPLE

curl --location 'http://localhost:8080/tickets?date=2023-10-12&type=SENIOR&hasCard=false'

# Projeto_API
Este é um projeto de aplicação Java / Maven / Spring Boot (versão 2.5.0).

Implementado um serviço de Back End (com um modelo e persistência de dados) que provê uma RESTFul API.

## Para rodar essa aplicação

* Clone o repositorio.
* Esteja usando JDK 1.8 e Maven 3.x.
* Baixe e importe o banco de dados  ```projetoapi.sql``` para uma data base mySQL. 
* Uma vez o banco funcionando no root e sem password você consegue rodar o serviço através de API Client(Postman,Insominia Rest...).

## Configuração do MySQL

Dentro de ```application.propreties``` da aplicação as **configurações** estão assim:
```
spring.datasource.url=jdbc:mysql://localhost:3306/projetoapi
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update 
```

## Sobre o Serviço

O serviço permite que o cliente possa visualizar dispositivos e streams ativos, registrar novos dispositivos e vincular/registrar novas streams aos mesmos. Para as streams, é possível consultar o fluxo de dados que vai sendo publicado pelos sensores reais ao longo do tempo. A API permite interagir com duas entidades principais, dispositivos (```SensorDevice```) e streams (```DataStream```) através de mensagens em JSON.

Ele utiliza relational database (MySQL). Uma vez conectado, você pode chamar os endpoints definidos em ```com.dev.projetoAPI.controller``` em *port 8080*.

Cadastrado previamente existe um usuario (User), o user1, com ele você pode começar chamando o endpoint {userName}/SensorDevices. A partir dele você consegue visualizar as keys dos dispositivos e de suas streams, e dai fazer consultas ou registros específicos nos outros endpoints operacionais (veja a lista completa abaixo).
 
Aqui estão alguns **endpoints** que você pode chamar:

### [GET] Consultar sobre unidades de medidas, dispositivos, dados de um Stream, etc.

```
http://localhost:8090/MeasureUnit
http://localhost:8080/{userName}/SensorDevices
http://localhost:8080/SensorDevices/{device key}
http://localhost:8080/DataStream/{stream key}
```

### [POST] Registrar dispositivo

```
POST http://localhost:8080/user1/SensorDevices
Accept: application/json
Content-Type: application/json

{
  "label" : "Kitchen's freezer sensor (Arduino)",
  "description" : "Kitchen's freezer sensor (Arduino)"
}

RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8091/SensorDevices/{device_id}
```

#### [POST] Registrar Stream (```DataStream```) para Dispositivo (```SensorDevice```)

```
POST http://localhost:8080/SensorDevices/{device key}/DataStream
Accept: application/json
Content-Type: application/json

{
  "label": "temperature",
  "unitId": 1
}

RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8091/DataStream/{stream_id}
```

#### [POST] Publicar medição em uma Stream (```DataStream```)

```
POST http://localhost:8080/DataStream/{stream key}/
Accept: application/json
Content-Type: application/json

{
  "label": "temperature",
  "unitId": 1
}

RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8091/DataStream/{stream_id}/SensorData
```

### Para ver documentação Swagger 2 API 

Dê Run no server e busque por ```localhost:8080/swagger-ui.html```.

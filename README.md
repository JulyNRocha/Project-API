# Project_API
This is a Java application project / Maven / Spring Boot (version 2.5.0).

Implemented a Back End service (with a model and data persistence) that provides a restful API.

## To run this application

* Clone the repository.
* Be using JDK 1.8 and Maven 3.x.
* Download and import the database  ```projectoapi.sql``` to a mysql base data. 
* Once the bank is working in root and without password you can run the service through API Client (Postman,Insominia Rest...).

## Configuration of MySQL

Within ```application.propreties``` of the application the **settings** look like this:
```
spring.datasource.url=jdbc:mysql://localhost:3306/projetoapi
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update 
```

## About the Service

The service allows the customer to view active devices and streams, register new devices and link/register new streams to them. For the streams, it is possible to query the data flow that is being published by the real sensors over time. The API allows interacting with two main entities, devices (```SensorDevice```) and streams (```Datastream````) via JSON messages.

It uses Relational database (MySQL). Once connected, you can call the endpoints defined in ```com.dev.projectAPI.controller```` in *port 8080*.

Previously registered there is a user (User), the user1, with it you can start by calling the endpoint {username}/SensorDevices. From it you can view the Keys of the devices and their streams, and then make specific queries or records on the other operational endpoints (see the full list below).
 
Here are some **endpoints** you can call:

### [GET] Query about units of measurement, devices, data from a Stream, etc.

```
http://localhost:8090/MeasureUnit
http://localhost:8080/{userName}/SensorDevices
http://localhost:8080/SensorDevices/{device key}
http://localhost:8080/DataStream/{stream key}
```

### [POST] Register device

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

### To see documentation Swagger 2 API 

Run the server and search for ```localhost:8080/swagger-ui.html```.

# Aplicación de Gestión de Superhéroes

Este es un proyecto de Spring Boot que ofrece una API para la gestión de superhéroes. Puede realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en superhéroes utilizando esta API.

## Tecnologías Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Base de datos H2 (en memoria)
- Maven
- Docker

## Funcionalidades

La API ofrece las siguientes funcionalidades:

- Consultar todos los superhéroes
- Consultar un solo superhéroe por ID
- Consultar superhéroes basados en un parámetro en el nombre
- Crear un nuevo superhéroe
- Actualizar un superhéroe existente
- Eliminar un superhéroe

## Configuración

Para ejecutar la aplicación en su entorno local, siga estos pasos:

1. Clone el repositorio de GitHub:
    
    - https://github.com/Olavorangel18/superheroes_test.git

2. Navegue hasta el directorio del proyecto:

    - cd superheroes_test

### Docker

1. Construya la imagen de Docker:

    - docker build -t superheroe  .

2. Ejecute el contenedor de Docker:

    - docker run -p 8080:8080 superheroe

3. Acceda a la API en `http://localhost:8080`.

### MVN 

1. mvn spring-boot:run
2. mvn clean install
3. Acceda a la API en `http://localhost:8080`.

## Uso de la API

Puede utilizar la API para interactuar con superhéroes. Aquí hay algunos ejemplos de cómo usar la API:

- Consultar todos los superhéroes: `GET /superheroes`
- Consultar un superhéroe por ID: `GET /superheroes/{id}`
- Consultar superhéroes por nombre: `GET /superheroes?name={nombre}`
- Crear un nuevo superhéroe: `POST /superheroes`
- Actualizar un superhéroe existente: `PUT /superheroes/{id}`
- Eliminar un superhéroe: `DELETE /superheroes/{id}`

Recuerde proporcionar los datos necesarios en el cuerpo de las solicitudes POST y PUT en formato JSON.


# Sistema de Reservas

Este proyecto es un sistema de gestión de reservas para servicios como restaurantes u hoteles. El backend está desarrollado con Spring Boot y se encarga de manejar reservas, modificaciones, cancelaciones y visualización de reservas.

## Características

- Gestión de reservas: creación, modificación y cancelación.
- Visualización de reservas por cliente y servicio.
- Autenticación de usuarios.
- Gestión de servicios vinculados a las reservas.
- Integración con bases de datos para mantener la integridad de los datos.
- Documentación API.

## Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Postgres
- Maven
- Swagger para documentación API (URL http://localhost:3000/swagger-ui/index.html)
- Git para control de versiones

## Requisitos Previos

- Java 17 instalado
- Maven instalado
- Postgres base de datos configurado

## Instalación

1. Clonar el repositorio:

    ```bash
    git clone https://github.com/Mulato96/LinkTicBk
    cd LinkTicBk
	git checkout develop
    ```
	

2. Configurar la base de datos en el archivo `application.properties`:

    ```properties
    server.port=3000
	spring.datasource.url=jdbc:postgresql://localhost:5432/linkticbd
	spring.datasource.username=postgres
	spring.datasource.password=postgres
	spring.datasource.driverClassName=org.postgresql.Driver
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.show-sql=true
	token.signing.key=413F4428472B4B6250655368566D5970337336763979244226452948404D6351
    ```

3. Construir y ejecutar la aplicación:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. La aplicación estará disponible en `http://localhost:3000`.

## Uso

### Endpoints Principales

- **GET /api/reservas**: Obtener todas las reservas.
- **POST /api/reservas**: Crear una nueva reserva.
- **PUT /api/reservas/{id}**: Actualizar una reserva existente.
- **DELETE /api/reservas/{id}**: Eliminar una reserva.

### Autenticación

La aplicación utiliza autenticación basada en tokens JWT. Para obtener un token, se debe enviar una solicitud de inicio de sesión con las credenciales del usuario.

```bash
POST /api/auth/login



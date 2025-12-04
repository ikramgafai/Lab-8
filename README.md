# LAB 8 - REST API Application

This project demonstrates a complete REST service based on Spring Boot, allowing the management of bank accounts through CRUD operations.

The application uses an in-memory H2 database, provides interactive documentation via Swagger/OpenAPI, and returns responses in JSON or XML according to the request.

## Features

- REST API with CRUD operations
- H2 in-memory database
- Swagger/OpenAPI documentation
- JSON and XML support
- Spring Boot 3.5.7

## Running the Application

Start the Spring Boot application:

```bash
mvn spring-boot:run
```

The application will be available at:
- API: http://localhost:8082/banque/comptes
- Swagger UI: http://localhost:8082/swagger-ui.html
- H2 Console: http://localhost:8082/h2-console

## API Endpoints

- GET `/banque/comptes` - Get all accounts
- GET `/banque/comptes/{id}` - Get account by ID
- POST `/banque/comptes` - Create a new account
- PUT `/banque/comptes/{id}` - Update an existing account
- DELETE `/banque/comptes/{id}` - Delete an account

All endpoints support both JSON and XML formats.

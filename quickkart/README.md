# QuickKart

QuickKart is a Spring Boot backend for the QuickKart e-commerce platform. It currently includes product CRUD, validation, PostgreSQL persistence, JWT authentication, and role-based product authorization.

## Technologies Used

- Java 21
- Spring Boot 3.x
- Maven
- Spring Web
- Spring Data JPA and PostgreSQL
- Spring Security, BCrypt, and JWT
- Spring Boot DevTools

## How to Run

1. Open a terminal in the project root.
2. Run:
   ```bash
   mvn spring-boot:run
   ```
3. The application will start on port 8080.

JWT configuration can be supplied through environment variables:

- `JWT_SECRET`: signing secret of at least 32 characters; replace the development default outside local development.
- `JWT_EXPIRATION`: token lifetime in milliseconds (the default is 15 minutes).

## Health Check API

- Endpoint: `GET /api/health`
- Expected response: `QuickKart Backend is running!`

## Authentication APIs

- `POST /api/auth/register`: registers a `CUSTOMER` and hashes the password with BCrypt.
- `POST /api/auth/login`: returns a Bearer JWT.

`GET /api/products` and `GET /api/products/{id}` are public. Product creation, update, and deletion require an `ADMIN` JWT. A normal registration request cannot select the ADMIN role.

For development testing, promote a registered user directly in PostgreSQL instead of exposing an admin-registration API:

```sql
UPDATE users SET role = 'ADMIN' WHERE email = 'admin@example.com';
```

Never store a plain-text password or commit a production JWT secret.

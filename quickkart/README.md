# QuickKart

QuickKart is a simple Spring Boot backend project created for Phase 1 of the major project. It establishes the project foundation and exposes a basic health-check endpoint.

## Technologies Used

- Java 21
- Spring Boot 3.x
- Maven
- Spring Web
- Spring Boot DevTools

## How to Run

1. Open a terminal in the project root.
2. Run:
   ```bash
   mvn spring-boot:run
   ```
3. The application will start on port 8080.

## Health Check API

- Endpoint: `GET /api/health`
- Expected response: `QuickKart Backend is running!`

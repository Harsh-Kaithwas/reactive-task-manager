# Reactive REST API with WebFlux & R2DBC (Task Management System)

This is the final Capstone Project for the Advanced Java Development course. It is a fully reactive, non-blocking REST API for a Task Management System built using modern Java practices.

## Tech Stack & Features
- **Spring Boot 3.2.2**
- **Spring WebFlux**: For building reactive and asynchronous REST endpoints using `Mono` and `Flux`.
- **Spring Data R2DBC**: Reactive Relational Database Connectivity to handle asynchronous database operations.
- **H2 Database**: An in-memory database used for reactive data persistence.
- **Non-blocking Architecture**: End-to-end reactive pipeline from the HTTP layer down to the database.

## API Endpoints

### 1. Create a New Task
- **URL:** `/api/tasks`
- **Method:** `POST`
- **Headers:** `Content-Type: application/json`
- **Body:**
```json
{
  "title": "Complete Capstone Project",
  "description": "Finish Java WebFlux assignment",
  "completed": false
}
```

### 2. Get All Tasks
- **URL:** `/api/tasks`
- **Method:** `GET`

## How to Run the Project
Run the following command in the terminal to start the Spring Boot application:
```bash
mvn spring-boot:run
```

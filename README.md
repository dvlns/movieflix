# 🎬 Movieflix API

A Spring Boot project providing a RESTful API for managing a movie catalog. This application features secure user authentication using Spring Security and JWT, and it manages database schema changes with Flyway.

---

## ✨ Core Features

* **Secure API:** Endpoints are secured using Spring Security, with user authentication handled by JSON Web Tokens (JWT).
* **Full CRUD Operations:** Provides complete API endpoints for managing Movies, Categories, and Streaming platforms.
* **DTO Pattern:** Uses Request (`MovieRequest`) and Response (`MovieResponse`) objects to ensure a clean API contract and separation from database entities.
* **Mapper Pattern:** Utilizes mappers (`MovieMapper`) to convert data between DTOs and JPA Entities.
* **Database Migrations:** Uses **Flyway** to manage database schema versions, ensuring consistency across environments.
* **Data Validation:** Includes `spring-boot-starter-validation` for validating incoming request bodies.

---

## 🛠️ Tech Stack & Dependencies

This project is built with **Java 17** and **Spring Boot 3.5.4**. Key dependencies include:

* **Spring Boot:**
    * `spring-boot-starter-web`: For building RESTful APIs.
    * `spring-boot-starter-data-jpa`: For data persistence with JPA/Hibernate.
    * `spring-boot-starter-security`: For authentication and authorization.
    * `spring-boot-starter-validation`: For request data validation.
* **Database:**
    * `postgresql`: PostgreSQL database driver.
    * `flyway-core`: For automated database migrations.
    * `flyway-database-postgresql`: PostgreSQL-specific Flyway support.
* **Security:**
    * `com.auth0:java-jwt`: Library for creating and verifying JSON Web Tokens.
* **Utilities:**
    * `lombok`: To reduce boilerplate code (e.g., getters, setters, constructors).
* **Build:**
    * `maven`: For project build and dependency management.

---

## 🚀 How to Run the Project

### Prerequisites
Before you begin, ensure you have the following installed on your system:
* **Java 17 (JDK)**
* **Maven**
* **PostgreSQL** (a running instance)

### 1. Clone the Repository
```sh
git clone [https://github.com/YOUR_USERNAME/movieflix.git](https://github.com/YOUR_USERNAME/movieflix.git)
cd movieflix
```

### 2. Configure the Database
This project uses Flyway, so you must configure your database credentials.

1.  Create a PostgreSQL database (e.g., `movieflix`).
2.  Open the `src/main/resources/application.yaml` file.
3.  Ensure the configuration matches the following (adjust your `username` and `password` as needed):

    ```yaml
    spring:
      application:
        name: movieflix
      
      datasource:
        url: jdbc:postgresql://localhost:5432/movieflix
        username: postgres
        password: post
        driver-class-name: org.postgresql.Driver
        
      jpa:
        database-platform: org.hibernate.dialect.PostgreSQLDialect
        show-sql: true
        
      flyway:
        enabled: true

    movieflix:
      security:
        secret: "palavra-secreta" # <-- IMPORTANT: Change this to a strong, random secret
    ```

### 3. Run the Application
You can now run the application using the Maven Spring Boot plugin:

```sh
mvn spring-boot:run
```
The application will start, run the Flyway migrations, and be available at `http://localhost:8080`.

---

## 🔐 API Endpoints

The base path for all API endpoints is `/movieflix`.

### Authentication (`/movieflix/auth`)
These endpoints are public and used for user registration and login.

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/register` | Registers a new user in the system. |
| `POST` | `/login` | Authenticates a user and returns a JWT. |

---
### Movies (`/movieflix/movie`)
These endpoints are protected and require a valid JWT in the `Authorization` header.

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/` | Saves a new movie to the database. |
| `GET` | `/` | Retrieves a list of all movies. |
| `GET` | `/{id}` | Finds a single movie by its ID. |
| `PUT` | `/{id}` | Updates an existing movie by its ID. |
| `DELETE` | `/{id}` | Deletes a movie by its ID. |
| `GET` | `/search` | Finds all movies by a specific category ID (e.g., `/search?category=1`). |

---
### Categories (`/movieflix/category`)
These endpoints are protected and require a valid JWT.

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/` | Saves a new movie category. |
| `GET` | `/` | Retrieves a list of all categories. |
| `GET` | `/{id}` | Finds a single category by its ID. |
| `DELETE` | `/{id}` | Deletes a category by its ID. |

---
### Streaming (`/movieflix/streaming`)
These endpoints are protected and require a valid JWT.

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/` | Saves a new streaming platform (e.g., Netflix). |
| `GET` | `/` | Retrieves a list of all streaming platforms. |
| `GET` | `/{id}` | Finds a single streaming platform by its ID. |
| `DELETE` | `/{id}` | Deletes a streaming platform by its ID. |

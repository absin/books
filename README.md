# Books Demo Application

This is a simple Spring Boot application for managing a catalog of books. It provides a RESTful API for creating, reading, updating, and deleting book records in an in-memory H2 database.

## Features
- CRUD operations on books (title, author, year, genre)
- Spring Data JPA with H2 in-memory database
- REST endpoints via Spring Web
- Packaged as a WAR for embedded Tomcat

## Prerequisites
- Java 17 or newer (tested with Java 21)
- Maven (wrapper scripts are included)

## Building the Application
```bash
cd books
./mvnw clean package
```

## Running the Application
```bash
cd books
./mvnw spring-boot:run
```

By default, the application starts on port **8081** (see `application.properties`).

## API Endpoints
| Method | Path                | Description                     |
|--------|---------------------|---------------------------------|
| GET    | `/books/api/books`      | List all books                  |
| GET    | `/books/api/books/{id}` | Get a book by ID                |
| POST   | `/books/api/books`      | Create a new book               |
| PUT    | `/books/api/books/{id}` | Update an existing book         |
| DELETE | `/books/api/books/{id}` | Delete a book by ID             |

Example (create a book):
```bash
curl -X POST http://localhost:8081/books/api/books \
  -H 'Content-Type: application/json' \
  -d '{"title":"1984","author":"George Orwell","publishedYear":1949,"genre":"Dystopian"}'
```

## H2 Console
You can access the H2 database console at [http://localhost:8081/h2-console](http://localhost:8081/h2-console) using JDBC URL `jdbc:h2:mem:testdb`, user `sa`, password `password`.

## Further Reading
See `books/HELP.md` for links to official Spring Boot and Maven documentation.

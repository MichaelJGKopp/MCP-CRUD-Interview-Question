# MCP-CRUD-Interview-Question

A Spring Boot-based Model Control Protocol (MCP) server designed to manage a database of interview questions. This project leverages Spring AI's MCP capabilities to provide tool-based access to interview questions data.

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen)
![Java](https://img.shields.io/badge/Java-24-orange)
![Spring AI](https://img.shields.io/badge/Spring%20AI-1.0.0--M7-blue)

## Overview

This project serves as an MCP (Model Control Protocol) server built with Spring Boot and Spring AI. It provides a service for managing interview questions through tool-based interactions, making it easy to retrieve, create, update, and delete interview questions from a database.

## Features

- **Interview Question Management**: Create, read, update, and delete interview questions
- **Category-based Filtering**: Retrieve questions by specific categories
- **Tool-based API**: Spring AI's tool annotations for easy integration
- **MySQL Database Integration**: Persistence for interview questions

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── io/
│   │       └── michaeljgkopp/
│   │           └── github/
│   │               ├── dao/
│   │               │   └── InterviewQuestionRepository.java
│   │               ├── entity/
│   │               │   └── InterviewQuestion.java
│   │               ├── service/
│   │               │   └── InterviewQuestionService.java
│   │               └── SpringMcpServerApplication.java
│   └── resources/
│       ├── application.properties
│       └── create_db.sql
```

## Requirements

- Java 24
- MySQL Database
- Maven 3.6+ or compatible build tool

## Installation

### Clone the Repository

```bash
git clone https://github.com/MichaelJGKopp/MCP-CRUD-Interview-Question.git
cd MCP-CRUD-Interview-Question
```

### Database Setup

1. Create the required MySQL database:

```sql
CREATE DATABASE IF NOT EXISTS mcp_interview_questions_db;
```

2. Configure a MySQL user with appropriate permissions (or use existing credentials with proper access)

### Configuration

The application is configured via `application.properties`. You can customize these settings or override them using environment variables:

```properties
spring.application.name=interview-questions-mcp-server
spring.main.web-application-type=none
spring.ai.mcp.server.name=interview-questions-mcp-server
spring.ai.mcp.server.version=0.0.1

server.port=${SERVER_PORT:3001}

spring.jpa.hibernate.ddl-auto=update

spring.datasource.url=${DB_URL:jdbc:mysql://localhost:3306/mcp_interview_questions_db}
spring.datasource.username=${DB_USERNAME:springstudent}
spring.datasource.password=${DB_PASSWORD:springstudent}
```

### Build the Project

```bash
mvn clean package
```

### Run the Server

```bash
java -jar target/spring-mcp-server-0.0.1-SNAPSHOT.jar
```

Or with custom environment variables:

```bash
SERVER_PORT=3002 DB_USERNAME=custom_user DB_PASSWORD=secure_password java -jar target/spring-mcp-server-0.0.1-SNAPSHOT.jar
```

## Available Tools

The MCP server exposes the following tools for interaction:

| Tool Name | Description |
|-----------|-------------|
| `iqs_get_interview_questions_by_category` | Retrieves interview questions filtered by a specific category |
| `iqs_get_interview_questions_all` | Retrieves all interview questions in the database |
| `iqs_save_interview_question` | Creates a new interview question or updates an existing one |
| `iqs_delete_interview_question_by_id` | Deletes an interview question by its ID |
| `iqs_delete_all_interview_questions` | Deletes all interview questions (use with caution) |

## Interview Question Model

Each interview question consists of the following fields:

| Field | Description |
|-------|-------------|
| id | Unique identifier (auto-generated) |
| difficulty | Difficulty level of the question (limited to 10 characters) |
| category | Category of the question (e.g., "Java", "SQL", "Spring") |
| title | Brief title for the question |
| question | The interview question text (limited to 1000 characters) |
| answer | The answer or solution (limited to 10000 characters) |

## Integration with AI Models

This MCP server is designed to work with Spring AI, allowing AI models to interact with the interview questions database using the provided tools. The server does not expose a traditional web interface as indicated by `spring.main.web-application-type=none` in the configuration.

## Development

### Adding New Categories

The system supports any string-based category. To add questions in a new category, simply use that category name when creating questions.

### Extending the Model

To extend the `InterviewQuestion` model with additional fields:

1. Update the `InterviewQuestion.java` entity class
2. Add appropriate getters and setters
3. Restart the application (the database schema will update automatically due to `spring.jpa.hibernate.ddl-auto=update`)

## License

This project is open source. For detailed license information, please contact the repository owner.

## Contact

For questions or support, please contact [Michael J.G. Kopp](https://github.com/MichaelJGKopp).

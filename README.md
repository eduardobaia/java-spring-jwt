# Java Spring JWT Demo Project

This project is a simple demonstration of how to implement JSON Web Tokens (JWT) authentication using Java Spring Boot 2.7. It showcases the basic functionality of JWT-based authentication in a Spring application.

## Requirements

- Java 17
- Maven

## Setup

1. Clone the repository:

   ```bash
   git clone https://https://github.com/eduardobaia/java-spring-jwt.git

2. Navigate to the project directory:

   cd your-project
3.Build the project using Maven:
mvn clean install

## Configuration
Before running the application, you need to configure a few properties:


1. Open the application.properties file located in the src/main/resources directory.

2. Modify the following properties according to your needs:

jwt.secret: Replace with a secure secret key used for signing JWTs.
jwt.expiration: Set the expiration time for JWTs (in milliseconds).

## Running the Application
You can run the Spring Boot application using Maven:

mvn spring-boot:run

Once the application is up and running, you can access it at http://localhost:8080.

## Endpoints
The following endpoints are available in this demo project:

POST /api/authenticate: Authenticates a user and generates a JWT.
GET /api/hello: Returns a greeting message. This endpoint requires a valid JWT.
## Usage
To authenticate a user and obtain a JWT, send a POST request to /api/authenticate with the following JSON payload:
{
  "username": "your-username",
  "password": "your-password"
}



# VollMed API 

Welcome to the VollMed API documentation! This API allows you to manage patient and medic data, as well as schedule appointments within the VollMed system.

## API Routes and Methods 

### Patients
- **GET /patients**: Retrieves a list of all patients.
- **GET /patients/{id}**: Retrieves a specific patient by its ID.
- **POST /patients**: Creates a new patient.
- **PUT /patients/{id}**: Updates an existing patient.
- **DELETE /patients/{id}**: Deletes a patient.

### Medics
- **GET /medics**: Retrieves a list of all medics.
- **GET /medics/{id}**: Retrieves a specific medic by its ID.
- **POST /medics**: Creates a new medic.
- **PUT /medics/{id}**: Updates an existing medic.
- **DELETE /medics/{id}**: Deletes a medic.

### Appointments
- **POST /appointments**: Creates a new appointment.

> **Note:** The specific parameters required for each request and the expected response formats may vary depending on the API implementation. Please refer to the API documentation for detailed information.

Authentication may be required for certain routes. Ensure you have the necessary credentials and follow the authentication guidelines provided by the API.

## Technologies Used

The VollMed API is built using the following technologies:
- **Maven**: Project management and build automation tool.
- **Spring Boot**: Framework for building production-ready applications.
- **JUnit**: Testing framework for Java applications.
- **Lombok**: Library to reduce boilerplate code in Java.
- **Spring Data JPA**: To simplify database interactions.
- **Spring Security**: For securing the application and managing authentication.
- **Flyway**: For database migration management.
- **Swagger/OpenAPI**: For API documentation and testing.
- **Docker**: For containerization and deployment of the application.
## Getting Started

To run the VollMed API, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/arturoburigo/VollMed-API
   cd VollMed-API

2. Build the project using Docker :
   ```bash
   docker build -t vollmed .

3. Start the application using Docker Compose:
   ```bash
   docker-compose up

## Authentication

You can use the pre-configured user to authenticate:
```json
    {
        "login": "user@voll.med",
        "password": "123456"
    }
  ```

This will return a token that should be used in all requests.

# API Documentation
You can access the API documentation at: http://localhost:8080/swagger-ui.html

## Contributing

Feel free to make a pull request or reach out to me on LinkedIn if you have any questions or suggestions: [Arturo Burigo](https://www.linkedin.com/in/arturoburigo/).




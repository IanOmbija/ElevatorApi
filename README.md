
# Elevator API
> A simple API that simulates an Elevator moving through floors in a building and showing the status - PENDING, MOVING etc
  

The Project makes use of: 
 - In-memory H2 Database to create the Database and Tables on the fly.
 - Project Lombok to aid in writing of boilerplate code
 - Hibernate to interface the Database Layer
 - JUnit and Mockito for Test


## Installation

### Prerequisites

```

- Spring Boot v2.0+
- JDK, preferably v1.8+
- Maven Dependency manager
- JUnit 5 - The most popular and widely used testing framework for Java
- Lombok - Convenience library for reducing boilerplate code
- Any IDE that supports Java & Spring Boot (IntelliJ, VSC, NetBeans, etc.)
- Postman, curl or any HTTP client

```



## Installation and Running the Project
```sh
1. Clone the repo from Git to your designated folder.
2. Download and install all the required dependencies(Listed above).
3. Run the application with your preferred IDE or via command: `mvn spring-boot:run`
4. This will instantiate the in-memory H2 Database and 
5. This will start tomcat server on default port `8080`

```

## Sample Endpoints Created & Responses

### Lend Loan to Subscriber
Sample `request` sent to the endpoint

```http
POST  http://<yourlocalhosturl>/api/elevator/call/{elevatorId}
```
The above endpoint allows the user to call the elevator to the respectiv floor

#### Sample Request Body
```json
 {
    "fromFloor":1,
    "toFloor":5

}
```

#### Success Response 200 OK
```json
{
    "status": true,
    "message": "",
    "body": {
        "elevatorId": 1,
        "fromFloor": 1,
        "toFloor": 5,
        "status": "PENDING"
    },
    "timestamp": "2023-02-16T18:29:56.890083"
}
```
### Get the status of the Elevator
Sample `request` sent to the endpoint

```http
GET  http://<yourlocalhosturl>/api/elevator/{elevatorId}
```
The above endpoint allows the user to see the status of the elevator

#### Success Response 200 OK
```json
{
    "status": true,
    "message": "",
    "body": {
        "id": 1,
        "currentFloor": 2,
        "status": "IDLE",
        "direction": "UP"
    },
    "timestamp": "2023-02-16T18:29:56.890083"
}
```
#

## Accessing the Swagger - OpenAPI Documentation

- Once the application is running we will use the base URL to access the documentation.

For example, our base url ```http://localhost:8080/swagger-ui.html#/```


#


## Built With

* [Spring Boot](https://spring.io/projects/spring-boot/) - The web framework used
* [H2 Database](https://www.h2database.com/html/main.html) - The In-memory Database


## Meta

Developed by Ian Ombija



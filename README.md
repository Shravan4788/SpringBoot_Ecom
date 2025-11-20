📦 Spring Boot Backend Project (Built in IntelliJ IDEA)

This is a beginner-friendly Spring Boot backend application created using Spring Initializr and developed in IntelliJ IDEA.
The project focuses on learning backend concepts such as REST APIs, request handling, controller creation, and Postman-based testing.

This project does not include a frontend. All API calls were tested using Postman.

🌟 Features

✔ Built completely with Spring Boot

✔ Clean package structure (Controller, Service, Model)

✔ REST API endpoints

✔ JSON-based request & response handling

✔ Tested using Postman

✔ Easy to extend and integrate with a database

🛠️ Tech Stack
Backend

Java 17 / 21 (depending on your Spring Initializr setup)

Spring Boot

Spring Web

Maven

IntelliJ IDEA (IDE used)

Postman (for API testing)

Optional

MySQL / H2 database (if used)

JPA / Hibernate (if used)

📘 Project Architecture
src/
└── main/
    ├── java/
    │   └── com.example.demo/
    │       ├── controller/      -> Handles HTTP requests
    │       ├── service/         -> Business logic
    │       ├── model/           -> Data model (DTO/Entity)
    │       └── repository/      -> Database operations (if DB used)
    │
    └── resources/
        ├── application.properties
        └── data.sql (optional)

🚀 How to Run the Project (IntelliJ IDEA)
1. Open IntelliJ IDEA

Click File → New → Project from Existing Sources

Select your folder

2. Build Dependencies

IntelliJ automatically downloads Maven dependencies.
If not, run:

mvn clean install

3. Run the App

Open the main class with @SpringBootApplication

Click Run ▶

Or run via terminal:

mvn spring-boot:run


Your backend will start at:

http://localhost:8080

🧪 API Endpoints (Tested Using Postman)

Below are sample endpoints. Modify them based on your project.

📌 GET all items
GET http://localhost:8080/api/items

📌 GET item by ID
GET http://localhost:8080/api/items/{id}

📌 POST create new item
POST http://localhost:8080/api/items
Content-Type: application/json

{
  "name": "Laptop",
  "price": 45000
}

📌 PUT update item
PUT http://localhost:8080/api/items/{id}

📌 DELETE item
DELETE http://localhost:8080/api/items/{id}

📝 Example JSON Response
{
  "id": 1,
  "name": "Laptop",
  "price": 45000,
  "status": "Available"
}

🔍 Postman Testing Workflow

Start Spring Boot server

Open Postman

Hit the API endpoint (GET / POST / PUT / DELETE)

Check JSON response

See status code (200, 201, 400, etc.)

Verify backend logic

You can add collections in Postman for easy testing.

🧱 Future Enhancements

Add MySQL database

Convert project to full CRUD application

Add Service + Repository layers

Add DTO + Validation

Add Swagger API documentation

Add Authentication (Spring Security + JWT)

Connect to a frontend (React / Angular)

📷 Screenshots (Optional Section)

Add Postman screenshots here if you want

Example:

/screenshots/get-request.png
/screenshots/post-request.png

📚 Learning Goals Achieved

Understanding Spring Boot structure

Writing REST APIs

Testing using Postman

Running and debugging in IntelliJ IDEA

Working with JSON

Basic Git & GitHub usage

🤝 Contributing

This is a learning project.
Feel free to fork and experiment!

📄 License

This project is for educational and learning purposes.
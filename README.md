# Augustana Hub Backend (V1)

A Spring Boot + PostgreSQL REST API for registering and browsing student profiles at Augustana Campus.  
This is **Version 1**, focused on core CRUD operations and filtering — no authentication yet.

---

## 🚀 Features (V1)

- Register student profiles
- List all students
- Filter by:
    - Id
    - First Name
    - Last Name
    - First & Last Name
    - Start Year
    - Course
    - Ethnicity
    - Country
    - Gender
- Optional profile fields (gender, ethnicity, country)
- Clean JSON responses
- Proper validation and error handling
- PostgreSQL integration
- CORS enabled for future React frontend

---

## 🧱 Tech Stack

- **Java 21**
- **Spring Boot 3.4.12**
    - Web
    - Data JPA
    - Validation
- **PostgreSQL**
- **Maven**
- **JSON REST API**

---

## 📦 API Endpoints

### 1. Create Student
**POST** `/api/students`

Example request body:
```json
{
  "firstName": "Chisom",
  "lastName": "Chiobi",
  "startYear": 2022,
  "course": "Computer Science",
  "studentEmail": "chiobi@ualberta.ca",
  "country": "Nigeria",
  "ethnicity": "Igbo",
  "gender": "Male"
}
```

Returns: `201 Created`

---

### 2. List & Filter Students
**GET** `/api/students`

Query params:
```
?id=1
?firstName=Chisom
?lastName=Chiobi
?firstName=Chisom&lastName=Chiobi
?startYear=2022
?course=Computer Science
?country=Nigeria
?ethnicity=Igbo
?gender=Male
```

Examples:
```
/api/students?firstName=Chisom&lastName=Chiobi
```
```
/api/students?course=Computer Science
```
```
/api/students?startYear=2022
```
```
/api/students?country=Nigeria
```
```
/api/students?gender=Male
```
```
No param: Gets all students
```

Returns: JSON array of students.

---

### 3. Get Student by ID
**GET** `/api/students/{id}`
```
/api/students/1
```
``` json
[
    { 
        "id": 1,
        "firstName": "Chisom",
        "lastName": "Chiobi",
        "startYear": 2022,
        "course": "Computer Science",
        "studentEmail": "chiobi@ualberta.ca",
        "country": "Nigeria",
        "ethnicity": "Igbo",
        "gender": "Male",
        "createdAt": "2025-12-03T18:21:03.286208",
        "updatedAt": "2025-12-03T18:21:03.286388",
        "fullName": "Chisom Chiobi"
    }
]
```
Returns: JSON array of students (Due to id being unique only one student in array).

---

### 4. Update Student By Id
**PUT** `/api/students/{id}`
```http request
###
PUT http://localhost:8080/api/students/1
Content-Type: application/json

{
  "firstName": "Chisom",
  "lastName": "Chiobi",
  "startYear": 2022,
  "course": "Mathematics",
  "studentEmail": "chiobi@ualberta.ca",
  "country": "Nigeria",
  "ethnicity": "Igbo",
  "gender": "Male"
}
```
```
Response code: 200;
```

---

### 5. Update Student By Student Email
**PUT** `/api/students/by-email/{studentEmail}`
```http request
###
PUT http://localhost:8080/api/students/by-email/chiobi@ualberta.ca
Content-Type: application/json

{
  "firstName": "Chisom",
  "lastName": "Chiobi",
  "startYear": 2022,
  "course": "Computer Science",
  "studentEmail": "chiobi@ualberta.ca",
  "country": "Nigeria",
  "ethnicity": "Igbo",
  "gender": "Male"
}
```
```
Response code: 200;
```

---

### 6. Delete Student By Id
**DELETE** `/api/students/{id}`
```http request
###
DELETE http://localhost:8080/api/students/1
```
```
Student successfully deleted!
```

### 7. Delete Student By Student Email
**DELETE** `/api/students/by-email/{studentEmail}`
```http request
###
DELETE http://localhost:8080/api/students/by-email/chiobi@ualberta.ca
```
```
Student successfully deleted!
```

---

## 🗄️ Database Schema (Simplified)

```
Student {
  id               BIGSERIAL PRIMARY KEY
  first_name       VARCHAR(100) NOT NULL
  last_name        VARCHAR(100) NOT NULL
  start_year       INTEGER NOT NULL
  course           VARCHAR(225) NOT NULL
  student_email    VARCHAR(255) NOT NULL
  country          VARCHAR(100)
  ethnicity        VARCHAR(100)
  gender           VARCHAR(50)
  created_at       TIMESTAMP
  updated_at       TIMESTAMP
}
```

---

## ⚙️ Setup Instructions

### 1. Create PostgreSQL database:
```sql
CREATE DATABASE augustana_hub;
```

### 2. Configure your `application.yml`
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/augustana_hub
    username: your_username
    password: your_password

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### 3. Run the backend
```
mvn spring-boot:run
```

---

## 🌐 CORS (React Ready)
In V1, CORS should allow:
```
http://localhost:3000
```

---

## 📚 Future V2 Features (Roadmap)

- Authentication (Spring Security + JWT)
- Admin dashboard
- User login & profile ownership
- Advanced filtering + search
- File upload service
- Analytics & charts

---

## 📄 License
MIT — free to use and modify.

---

## 👤 Author
### Chisom (Jason) Chiobi
- Full‑stack developer
- Augustana Campus, University of Alberta  



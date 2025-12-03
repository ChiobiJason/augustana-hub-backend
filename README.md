# Augustana Hub Backend (V1)

A Spring Boot + PostgreSQL REST API for registering and browsing student profiles at Augustana Campus.  
This is **Version 1**, focused on core CRUD operations and filtering — no authentication yet.

---

## 🚀 Features (V1)

- Register student profiles
- List all students
- Filter by:
    - Year of Study
    - Ethnicity
    - Country of Birth
- Optional profile fields (gender, profile image)
- Clean JSON responses
- Proper validation and error handling
- PostgreSQL integration
- CORS enabled for future React frontend

---

## 🧱 Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
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
?year=3
?countryOfBirth=Nigeria
?ethnicity=Igbo
```

Example:
```
/api/students?year=3&ethnicity=Igbo
```

Returns: JSON array of students.

---

### 3. Get Student by ID
**GET** `/api/students/{id}`

---

### 4. Update Student (Optional for V1)
**PUT** `/api/students/{id}`

---

### 5. Delete Student (Optional for V1)
**DELETE** `/api/students/{id}`


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
**Chisom (Jason) Chiobi**
Augustana Campus, University of Alberta  
Full‑stack developer in training  


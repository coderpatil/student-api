# 🚀 Student Management API (Spring Boot)

A production-style backend application built using Spring Boot, covering core backend concepts like authentication, authorization, caching, pagination, rate limiting, and JWT-based security.

---

## 🧱 Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL (Docker)
- JWT (io.jsonwebtoken)
- Bucket4j (Rate Limiting)
- Swagger (OpenAPI)

---

## 📌 Features Implemented

### 1. Core APIs

#### 👨‍🎓 Student APIs
- Create student
- Get students (with pagination)
- Delete student

#### 📚 Course APIs
- Create course
- Get courses (with pagination)

#### 📝 Enrollment APIs
- Enroll student in course
- Get enrollments (DTO response with student + course name)

---

### 2. Database Design

- `Student`
- `Course`
- `Enrollment` (Many-to-One relationships)

```text
Student  ← Enrollment →  Course
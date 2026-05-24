# Training Services System

A microservices-based training management system developed using Spring Boot, Docker, Docker Compose, GitHub Actions, and Docker Hub.

---

# Project Overview

This project demonstrates a distributed microservices architecture for managing training services.  
The system contains multiple independent services that communicate through REST APIs.

The implemented services include:

- User Service
- Course Service
- Enrollment Service
- Assessment Service
- Certification Service
- Scheduling Service

Each microservice runs independently and is containerized using Docker.

---

# Technologies Used

- Java 17
- Spring Boot
- Maven
- REST APIs
- Docker
- Docker Compose
- GitHub
- GitHub Actions
- Docker Hub

---

# Microservices

## 1. User Service

Responsible for validating student information.

### Port
```text
8081

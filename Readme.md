# Learning Navigator

Learning Navigator is a RESTful API service designed to manage the exam enrollment process for a Learning Management System (LMS). The application handles CRUD operations for students, subjects, and exams, and includes a hidden Easter Egg feature to generate random facts about numbers.

---

## Features

- **Students Management**: Create, update, delete, and retrieve student details.
- **Subjects Management**: Manage subjects and their relationships with students.
- **Exams Management**: Handle exams, their subjects, and enrolled students.
- **Easter Egg Feature**: A hidden API to fetch random number facts using the Numbers API.
- **Exception Handling**: Global error handling with meaningful HTTP responses.
- **Unit Testing**: Tests using Mockito and MockMvc.

---

## Tech Stack

- **Backend Framework**: Spring Boot
- **Database**: MySQL
- **Build Tool**: Maven
- **Testing**: JUnit, Mockito
- **Additional Libraries**:
    - `spring-boot-starter-data-jpa`
    - `spring-boot-starter-web`
    - `spring-boot-starter-test`
- **API Integration**: Numbers API for Easter Egg feature

---

## Setup and Installation

### Prerequisites

- Java 17+
- MySQL
- Maven

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/Kgaur431/LMS.git
   cd learning-navigator
#   L M S  
 
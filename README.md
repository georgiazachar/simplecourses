# Simple Courses

Μικρή Spring Boot εφαρμογή για διαχείριση σεμιναρίων, φοιτητών και εγγραφών.

## Λειτουργικότητα

- **Οντότητες (Domain Model)**
    - `Course` – σεμινάριο
    - `Student` – φοιτητής
    - `Enrollment` – εγγραφή φοιτητή σε σεμινάριο

- **Ρόλοι χρηστών (Security)**
    - `ADMIN` – έχει πρόσβαση σε όλα τα `/admin/...`
    - `USER` – βλέπει μόνο τη λίστα των courses

Το back-end υλοποιείται με:

- **Spring Boot** (Java 17)
- **Spring MVC** για τους controllers και το routing
- **Spring Data JPA** για πρόσβαση στη βάση δεδομένων
- **Spring Security** για authentication & authorization (ρόλοι ADMIN / USER)
- **MySQL** ως σχεσιακή βάση δεδομένων
- Layered αρχιτεκτονική με πακέτα:
  - `domain` (οντότητες JPA: Course, Student, Enrollment)
  - `repository` (JPA repositories)
  - `service` (business λογική)
  - `controllers` (web layer / MVC controllers)
  - `security` (ρυθμίσεις Spring Security)

### Front-end

Το front-end υλοποιείται με:

- **Thymeleaf** ως template engine (Server-Side Rendering)
- HTML templates μέσα στο Spring Boot:
  - `login.html`
  - `index.html` (λίστα σεμιναρίων)
  - `admin-courses.html`
  - `admin-students.html`
  - `admin-enrollments.html`
- **CSS** (αρχείο `static/css/style.css`) για βασικό layout και μορφοποίηση

## Domain Model

- **Course**: τίτλος, περιγραφή
- **Student**: ονοματεπώνυμο, email
- **Enrollment**: εγγραφή φοιτητή σε course (συσχέτιση Student–Course)

---

## Authentication / Authorization

- Admin user: `admin / admin` (ROLE_ADMIN)
- User: `user / user` (ROLE_USER)

Μόνο ο **ADMIN** έχει πρόσβαση στα endpoints `/admin/

## Build & Deploy (Run)

Build 

```bash 
mvn clean package -DskipTests

Deploy

Μετά το build, εκτελούμε την εντολή:

```bash
mvn spring-boot:run

Η εφαρμογή ανοίγει στο http://localhost:8080


## Απαιτήσεις

- JDK 17+
- Maven 3+
- MySQL server

---

## Ρυθμίσεις Βάσης Δεδομένων

1. Δημιούργησε μια database στο MySQL, π.χ.:

sql
CREATE DATABASE simplecoursesdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

MySQL:
- Δημιουργήθηκε schema: simplecoursesdb
- Οι πίνακες course, student, enrollment δημιουργούνται/ενημερώνονται από το Spring Data JPA (hibernate ddl-auto=update)
- Ο πίνακας enrollment έχει foreign keys προς student(id) και course(id)
- Τα demo δεδομένα εισάγονται κατά την εκκίνηση της εφαρμογής μέσω DataInitializer.


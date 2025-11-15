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

- **Τεχνολογίες**
    - Java 17
    - Spring Boot (Web, Data JPA, Security, Thymeleaf)
    - MySQL
    - Maven

---

## Απαιτήσεις

- JDK 17+
- Maven 3+
- MySQL server

---

## Ρυθμίσεις Βάσης Δεδομένων

1. Δημιούργησε μια database στο MySQL, π.χ.:

```sql
CREATE DATABASE simplecoursesdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

![Workout Management API](WhatsApp Image 2026-02-07 at 22.11.22 (1).jpeg)

##  Workout Management API

This is a Spring Boot-based backend application designed for managing fitness workouts. The project demonstrates the implementation of professional software design patterns and a clean architecture.

---

##  Features
* **Full CRUD functionality:** Create, Read, Update, and Delete workouts.
* **Workout Categorization:** Support for different types of workouts (Cardio, Strength, etc.).
* **Database Integration:** Persistent storage using PostgreSQL.
* **DTO Pattern:** Secure data transfer between layers.

---

##  Design Patterns Implemented

The project strictly follows these design patterns to ensure scalability and clean code:

1.  **Singleton Pattern**: Used in the `DatabaseConnection` class to ensure that only one instance of the database connection exists throughout the application lifecycle.
2.  **Factory Method Pattern**: Implemented via `WorkoutFactory` to dynamically create different types of workouts (e.g., Cardio, Strength) based on user input.
3.  **Builder Pattern**: Utilized (via Lombok's `@Builder`) to construct complex `Workout` objects in a readable and flexible manner within the Factory.
4.  **DTO (Data Transfer Object)**: Used to decouple the internal database entities from the API response, ensuring data encapsulation and security.

---

##  Tech Stack
* **Java 17** (or 25)
* **Spring Boot 3.x**
* **Spring Data JPA** (Hibernate)
* **PostgreSQL**
* **Lombok** (for cleaner code)
* **Maven** (Dependency management)

---

##  Setup and Installation

1. **Clone the repository:**
   ```bash

   git clone <https://github.com/nurbekaktai-sys/OOP-Endterm.git>

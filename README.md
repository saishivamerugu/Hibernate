# Hibernate


This repository contains a collection of Hibernate-based Java projects created for learning and demonstration purposes. Each project explores different aspects of Hibernate ORM, including HQL, native queries, composite keys, and entity relationships. The examples are optimized for beginners and intermediate Java developers aiming to understand how Hibernate works under the hood.

## Repository Structure

- **FirstHibernateProject**  
  Basic setup of a Hibernate project including configuration setup, entity creation, and CRUD operations.

- **SecondHibernateProject**  
  Demonstrates more advanced Hibernate features such as different annotations and session management techniques.

- **HQLPrograms**  
  Examples focused on Hibernate Query Language (HQL), showing how to write and execute HQL queries for retrieving and manipulating data.

- **NativeQueries**  
  Demonstrates how to use native SQL queries within Hibernate for performance or compatibility purposes.

- **HibernateCompositeKey-EmbeddableAnnotation**  
  Shows how to implement composite primary keys using the `@Embeddable` and `@EmbeddedId` annotations.

- **StatesInHibernate**  
  Explains Hibernate object states (Transient, Persistent, and Detached) with clear examples.

- **RelationshipMappings**  
  Future updates will include projects demonstrating:
  - One-to-One Mapping  
  - One-to-Many Mapping  
  - Many-to-Many Mapping  

## Prerequisites

- Java 17 or later  
- Maven or Gradle build tool  
- MySQL or any compatible relational database  
- Hibernate 6.x  

## How to Run

1. Clone the repository:
git clone https://github.com/saishivamerugu/Hibernate.git

2. Open the project folder you wish to explore (e.g., `FirstHibernateProject`).

3. Update the `hibernate.cfg.xml` file with your database credentials.

4. Build and run the application:
mvn clean install
java -cp target/classes com.example.Application

## Key Concepts Covered

- Hibernate Configuration and Setup  
- Entity Mapping and Annotations (`@Entity`, `@Table`, `@Id`, `@Column`)  
- HQL and Native Queries  
- Composite Keys using Embeddables  
- Lifecycle of Hibernate Objects  
- Relationship Mappings (One-to-One, One-to-Many, Many-to-Many)  

## Author

**Sai Shiva Merugu**  
Java Developer & Hibernate Learner  
[GitHub Profile](https://github.com/saishivamerugu)

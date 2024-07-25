Here's a README file for your microservices project:

---

# Microservices Project

This project consists of three microservices: Job, Company, and Review. These services communicate with each other using the `RestTemplate` class in Java and are containerized using Docker. The PostgreSQL database is used for data storage.

## Table of Contents

- [Microservices](#microservices)
  - [Job Service](#job-service)
  - [Company Service](#company-service)
  - [Review Service](#review-service)
- [Communication](#communication)
- [Database](#database)
- [Containerization](#containerization)
- [Setup](#setup)
- [Usage](#usage)

## Microservices

### Job Service

- **Path:** `/jobs`
- **Description:** Manages job postings and related operations.
- **Endpoints:**
  - `GET /jobs`: Retrieve all jobs.
  - `POST /jobs`: Create a new job.
  - `GET /jobs/{id}`: Retrieve a job by its ID.
  - `PUT /jobs/{id}`: Update a job by its ID.
  - `DELETE /jobs/{id}`: Delete a job by its ID.

### Company Service

- **Path:** `/company`
- **Description:** Manages company information and related operations.
- **Endpoints:**
  - `GET /company`: Retrieve all companies.
  - `POST /company`: Create a new company.
  - `GET /company/{id}`: Retrieve a company by its ID.
  - `PUT /company/{id}`: Update a company by its ID.
  - `DELETE /company/{id}`: Delete a company by its ID.

### Review Service

- **Path:** `/reviews`
- **Description:** Manages reviews for companies and related operations.
- **Endpoints:**
  - `GET /reviews`: Retrieve all reviews.
  - `POST /reviews`: Add a new review.
  - `GET /reviews/{reviewId}`: Retrieve a review by its ID.
  - `PUT /reviews/{reviewId}`: Update a review by its ID.
  - `DELETE /reviews/{reviewId}`: Delete a review by its ID.

## Communication

The microservices communicate with each other using the `RestTemplate` class in Java. This allows for inter-service communication via RESTful APIs.

## Database

The project uses PostgreSQL as the database. Each microservice has its own database schema.

## Containerization

The project is containerized using Docker. Each microservice has its own Docker container, and a PostgreSQL container is used for the database.

## Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/yourusername/microservices-project.git
   cd microservices-project
   ```

2. **Build the Docker images:**
   ```sh
   docker-compose build
   ```

3. **Start the containers:**
   ```sh
   docker-compose up
   ```

4. **Database Setup:**
   Ensure PostgreSQL is running and configure the database connection properties in each microservice's `application.properties` file.

## Usage

Once the containers are up and running, you can access the services using the following URLs:

- Job Service: `http://localhost:8081/jobs`
- Company Service: `http://localhost:8082/company`
- Review Service: `http://localhost:8083/reviews`

You can use tools like Postman or curl to interact with the APIs.

---

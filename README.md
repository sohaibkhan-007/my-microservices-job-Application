# My Microservices Job Application

Welcome to the microservices job application repository. This project is designed to demonstrate a job application system using microservices architecture.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)

## Introduction

This project is a job application system built using microservices architecture. It aims to provide a scalable and efficient way to handle job postings, applications, and reviews.

## Features

- **Job Postings:** Create, update, and delete job postings.
- **Job Applications:** Apply for jobs and manage applications.
- **Company Reviews:** Post and read reviews for companies.
- **REST API:** Access and manage data through a RESTful API.

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Cloud**
- **Spring Data JPA**
- **MySQL**
- **Docker**
- **Kubernetes**
- **Kafka**
- **Eureka Server (Service Discovery)**
- **Zuul API Gateway**

## Installation

### Prerequisites

- **Java 11** or higher
- **Maven**
- **Docker**
- **Kubernetes**

### Steps

1. Clone the repository:
    ```sh
    git clone https://github.com/sohaibkhan-007/my-microservices-job-Application.git
    cd my-microservices-job-Application
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Start the services using Docker Compose:
    ```sh
    docker-compose up
    ```

4. Deploy to Kubernetes:
    ```sh
    kubectl apply -f k8s/
    ```

## Usage

Once the application is up and running, you can access the services via the API Gateway. The default base URL for the API Gateway is `http://localhost:8080`.

### Example Endpoints

- **Job Service:** `http://localhost:8080/jobs`
- **Application Service:** `http://localhost:8080/applications`
- **Review Service:** `http://localhost:8080/reviews`

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements or bug fixes.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

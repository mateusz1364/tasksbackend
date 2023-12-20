# Tasks Management Application

## Overview

This is a simple and efficient Tasks Management Application built with Java and Maven. The application utilizes Java 17+, Maven 3.8.2, Docker, and Docker Compose for seamless deployment and management.
An application has been built using the Spring Framework and Tapestry.

## Prerequisites

Before you begin, make sure you have the following tools installed:

- Java 17+
- Maven 3.8.2+
- Docker
- Docker Compose

### Optional: Setting up MariaDB

In the `maria-database` folder, you can choose to set up a MariaDB instance using Docker Compose:

```bash
cd maria-database
docker-compose up -d
```

### Optional: Database Configuration

Update the database credentials in the `docker-compose.yml` file located in the main folder.

Additionally, you can log in to the MariaDB database and create the necessary schema using the `schema.sql` file.


## Build and Run

Follow these steps to build and run the project:

1. Open a terminal and navigate to the main folder.

2. Build the project using Maven:

```bash
mvn clean install
```

3. Build the Docker image:

```bash
docker build -t tasks-management:1.0.0 .
```

4. Start the application with Docker Compose:

```bash
docker-compose up -d
```

## Access the Application

Once the application is running, visit [http://localhost:8080](http://localhost:8080) in your web browser to access the Tasks Management Application.
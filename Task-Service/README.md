# TaskService

## Overview
The TaskService application is a Java-based solution designed to manage Task information. This application provides functionalities to add, update, and delete Task details. The service uses in-memory data structures for storage, making it fast and efficient for managing Task data.

## Features
- **Add Tasks:** Ability to add new Tasks with unique identifiers.
- **Update Tasks:** Update specific Task details such as name, phone number, and address.
- **Delete Tasks:** Remove Tasks from the service using their unique ID.

## How to Run
To run this application, you will need a Java Development Kit (JDK) installed. Follow these steps:
1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Compile the Java files:
   `javac Task.java TaskService.java`
4. Run the application (if applicable).

## Testing
This project includes JUnit tests to ensure the application functions correctly. To run the tests:
1. Navigate to the test directory.
2. Execute the test files:
   `java TaskTest.java`
   `java TaskServiceTest.java`

## Task Class
The Task class represents individual Task entries with the following fields:
- **Task ID** (required): Unique ID for the Task (max 10 characters).
- **Name** (required): Task's first name (max 20 characters).
- **Description** (required): Task's last name (max 50 characters).

## TaskService Class
The TaskService class manages the storage and manipulation of Task objects. It allows:
- Adding new Tasks.
- Deleting Tasks by their ID.
- Updating Task fields using a map for flexible updates.

## Contribution
Contributions to this project are welcome. Please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes.
4. Push to the branch.
5. Create a Pull Request.
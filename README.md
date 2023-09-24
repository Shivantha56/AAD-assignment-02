# AAD-assignment-02
You can find the source code here "Assignment 02 (Dilshan Shivantha)"

IJSE assignment assignment 02 spring web mvc and other technologies

GolabalTechAPI Project Management tool

  - This project has two APIs TechleadController and ProjectController
  - Implemented basic crud operations using spring data jpa (vendor: hibernate)
  - Request handle using multipart form data and json
  - Image encoder included
  - Validating all fields and handling exceptions
  - All configurations done
  - used the build tool as the Gradle
  - #provided documentation for APIs using the Postman

Entity relational diagram
![raltion diagram](https://github.com/Shivantha56/AAD-assignment-02/assets/111634293/bdf0b310-fcfd-4f25-8a5c-65c79ddbcc28)

### If you want to look at project details copy and paste the below query inside your MySQL database client
- **USE assignment02dilshanshivantha**
- **SELECT p.projectId, p.projectName, p.dueDate, t.name AS techLeadName FROM project AS p JOIN tech lead AS t ON p.techLeadId_employeeId = t.employeeId;**

## API Documentation

Welcome to the API documentation for IJSE Assignment 02. This documentation will provide you with all the necessary information about this API.

Table of contents
  1. Introduction
  2. Endpoints
  3. Request Format
  4. Response Format
  
1.**Introduction.**

This is a simple API developed by using Java language and framework as Spring Web MVC. This API provides basic crud operations to manipulate and extract data from the database

2.**Endpoints.**

- http://localhost:8080/Gradle___lk_ijse_gdse___Assignment_02__Dilshan_Shivantha__1_0_SNAPSHOT_war/api/v1/techlead (HTTP method - post , endpoint for saving tech lead)
- http://localhost:8080/Gradle___lk_ijse_gdse___Assignment_02__Dilshan_Shivantha__1_0_SNAPSHOT_war/api/v1/techlead/ (HTTP mehod - get , endpoint for get all techlead details)
- http://localhost:8080/Gradle___lk_ijse_gdse___Assignment_02__Dilshan_Shivantha__1_0_SNAPSHOT_war/api/v1/techlead/EMP-001 (HTTP method - get , endpoint for get selected techlead details)
- http://localhost:8080/Gradle___lk_ijse_gdse___Assignment_02__Dilshan_Shivantha__1_0_SNAPSHOT_war/api/v1/techlead/EMP-001 (HTTP method - patch , endpoint for update techlead details)
- http://localhost:8080/Gradle___lk_ijse_gdse___Assignment_02__Dilshan_Shivantha__1_0_SNAPSHOT_war/api/v1/techlead/EMP-001 (HTTP method - delete, endpoint for delete techlead details)

- http://localhost:8080/Gradle___lk_ijse_gdse___Assignment_02__Dilshan_Shivantha__1_0_SNAPSHOT_war/api/v1/project (HTTP method - post , endpoint for saving project)
- http://localhost:8080/Gradle___lk_ijse_gdse___Assignment_02__Dilshan_Shivantha__1_0_SNAPSHOT_war/api/v1/project (HTTP mehod - get , endpoint for get all project details)
- http://localhost:8080/Gradle___lk_ijse_gdse___Assignment_02__Dilshan_Shivantha__1_0_SNAPSHOT_war/api/v1/project/P00-001 (HTTP method - get , endpoint for get selected project details)
- http://localhost:8080/Gradle___lk_ijse_gdse___Assignment_02__Dilshan_Shivantha__1_0_SNAPSHOT_war/api/v1/project/P00-001 (HTTP method - patch , endpoint for update project details)
- http://localhost:8080/Gradle___lk_ijse_gdse___Assignment_02__Dilshan_Shivantha__1_0_SNAPSHOT_war/api/v1/project/P00-001 (HTTP method - delete, endpoint for delete project details)


4.**Request Format.**

All requests are made using the HTTP 'GET','POST','PUT','DLETE' methods. Depending on the endpoint. The required request parameters and are documented for each endpoint in the API documentation

3.**Response Format.**

Responses from the API are in JSON format by default. Each response will contain relevant data and metadata, making it easy to parse and utilize the information in your application.

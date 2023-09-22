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
  - #provided documentation for APIs using the postman

Entity relational diagram
![raltion diagram](https://github.com/Shivantha56/AAD-assignment-02/assets/111634293/bdf0b310-fcfd-4f25-8a5c-65c79ddbcc28)

If you want to look at project details copy and paste the below query inside your MySQL database client
**SELECT p.projectId, p.projectName, p.dueDate, t.name AS techLeadName FROM project AS p JOIN techlead AS t ON p.techLeadId_employeeId = t.employeeId;



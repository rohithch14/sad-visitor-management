
## Project Setup Instructions

This repository contains the configuration for our application's backend, database, and now the front end, utilizing Spring Boot with Maven for the backend, MySQL for the database, and Angular for the front end. This guide will walk you through setting up the necessary tools including MySQL Workbench, Eclipse IDE, and the Angular CLI.

### Prerequisites

Before you begin, ensure you have the following installed:
- MySQL Workbench
- MySQL Server
- Eclipse IDE
- Node.js and npm
- Angular CLI
- Visual Studio Code
### Installation Steps

#### MySQL Workbench and MySQL Server

1. **Download and Install MySQL Workbench and MySQL Server:**
   - Download MySQL Workbench from [MySQL Workbench Downloads](https://dev.mysql.com/downloads/workbench/).
   - Download MySQL Installer (includes MySQL Server) from [MySQL Installer Downloads](https://dev.mysql.com/downloads/installer/).
   - Follow the installation prompts. During the MySQL Server setup, set the password to `Offender@123` for database access.

2. **Create Database Schema:**
   - Open MySQL Workbench.
   - Connect to your local MySQL server instance.
   - Create a new schema by executing: `CREATE SCHEMA projectdb;`

#### Eclipse IDE Setup

1. **Download and Install Eclipse:**
   - Download the latest version of Eclipse from [Eclipse Downloads](https://www.eclipse.org/downloads/). Older versions are not recommended.

2. **Setup Project:**
   - Launch Eclipse and choose or create a workspace.
   - Go to `File > Import > Maven > Existing Maven Projects`.
   - Navigate to the directory where you cloned or downloaded this repository and select the backend project folder.

3. **Run Application:**
   - Right-click on the project in the Eclipse Project Explorer.
   - Select `Run As > Spring Boot App`. This will start the application and automatically create tables in the `projectdb` database.

#### Initial Data Setup

1. **Insert Demo Data:**
   - Open MySQL Workbench and connect to the `projectdb` schema.
   - Execute the following SQL queries to populate initial data:

   ```sql
   INSERT INTO projectdb.visitor_types (visitor_typeid, visitor_type) VALUES 
   (1, 'Parent'),
   (2, 'Sibling'),
   (3, 'Spouse'),
   (4, 'Child'),
   (5, 'Clients');
   ```
#### Angular Front End Setup in Visual Studio Code

1. **Download and Install Visual Studio Code:**
   - Download Visual Studio Code from [Visual Studio Code Download](https://code.visualstudio.com/download).

2. **Setup Front End Project:**
   - Open Visual Studio Code and navigate to the directory where you cloned or downloaded the repository.
   - Go to the 'raise' folder using command `cd frontend`.
   - Run `npm install` to install the required node modules.
   - Use the command `ng serve` to start the application. It will run at `http://localhost:4200/` which directly leads to the role selection page at `http://localhost:4200/roleselection`.

3. **Role Selection and Functionality:**
   - On the role selection page, enter an employee name for the employee role to manage personal pass requests, or a location for the security head to manage requests at that specific location.
   - Security heads can view all pending requests in their location and have access to approve or reject functionalities.
   - Employees will see approve and reject buttons but will receive an "Unauthorized action" alert if attempted to use. They can only create new visitor pass requests.

### New Visitor Pass Request Constraints

- **Advance Notice:** A new visitor request must be raised at least 1 week in advance.
- **Family Member Requests:** Each employee can raise only 2 visitor requests for family members in a given calendar month.
- **Weekend Requests:** Visit requests for family members can only be raised for weekends.
- **Client Visits:** There is no restriction on the number of visit requests that can be placed for clients.

### Components and Functionality

a. **PassRequestListComponent:**
   - Displays all visitor pass requests in a table with 'View Details' buttons.

b. **PassRequestDetailsComponent:**
   - Shows detailed information about a single pass request. For security heads, this includes the ability to approve or reject requests.

c. **ApproveRejectRequestComponent:**
   - Allows security heads to approve or reject pass requests, with an option to provide a reason for rejection.

d. **NewPassRequestComponent:**
   - Enables employees to create new visitor pass requests with all necessary details, ensuring validation before submission. Only visible and accessible by employees.

---




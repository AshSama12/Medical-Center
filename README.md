# Medical Center Management System

## 📌 Overview
This is a **Spring Boot-based Medical Center Management System** that allows a doctor to manage patients, prescriptions, and drug stock efficiently. The application provides user authentication, patient management, prescription handling, and drug stock tracking.

## 🛠️ Tech Stack
- **Backend**: Spring Boot, Java
- **Frontend**: HTML, CSS, JavaScript
- **Database**: MySQL
- **Build Tool**: Maven

## 📂 Project Structure
```
medical-center/
│── src/main/java/com/example/MedicalCenter/
│   ├── config/
│   ├── controller/
│   ├── dao/
│   ├── model/
│   ├── service/
│   ├── MedicalCenterApplication.java
│
│── src/main/resources/templates/
│   ├── index.html
│   ├── home.html
│   ├── add_patient.html
│   ├── patient.html
│   ├── prescription.html
│   ├── drug.html
│   ├── add_drug.html
│   ├── see_stock.html
│
│── src/main/resources/static/
│   ├── style.css
│   ├── script.js
│
│── pom.xml
│── README.md
```

## 🚀 Features
### ✅ User Authentication
- The system allows only **one doctor** to log in using a **username and password**.

### ✅ Patient Management
- Search patients by **Date of Birth (DOB)**.
- Add new patients with details: **Name, DOB, Address, Telephone Number**.
- Each patient has an individual **prescription list**.
- View patient history (past prescriptions).
- Write a new prescription (**auto-generated date and time**).

### ✅ Drug Management
- Search for medicines in stock.
- Add new drugs with details: **Name, Amount, Expiry Date, Company, Important Notes**.
- Update the stock when adding a drug.
- View the drug stock as a table (Name & Amount).

## ⚙️ Setup & Installation
### 🔹 Prerequisites
- Java 17+ (Ensure JDK is installed)
- MySQL Database
- Maven
- Spring Boot

### 🔹 Clone the Repository
```sh
git clone https://github.com/your-username/medical-center.git
cd medical-center
```

### 🔹 Configure Database
1. Open `src/main/resources/application.properties`
2. Update the MySQL connection details:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/medical_center
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 🔹 Build & Run the Application
```sh
mvn spring-boot:run
```

### 🔹 Access the Application
Once the server starts, open your browser and go to:
```sh
http://localhost:8080
```

## 📜 API Endpoints
| Endpoint            | Method | Description |
|--------------------|--------|-------------|
| `/login`           | POST   | Doctor Login |
| `/patients`        | GET    | List all patients |
| `/patients/add`    | POST   | Add new patient |
| `/patients/search` | GET    | Search patient by DOB |
| `/prescriptions/add` | POST | Add new prescription |
| `/drugs`           | GET    | View all drugs |
| `/drugs/add`       | POST   | Add new drug to stock |
| `/drugs/stock`     | GET    | View drug stock |



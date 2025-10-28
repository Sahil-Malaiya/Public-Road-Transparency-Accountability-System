# 🛣️ Public Road Transparency & Accountability System  

### 🚀 Developed by [Sahil Malaiya](https://github.com/Sahil-Malaiya)

---

## 📖 Project Overview  

In India, thousands of crores are spent every year on road construction and maintenance.  
However, the public rarely knows:  
- Which contractor built the road  
- Which officer approved the project  
- How much money was spent  
- Who is responsible for its maintenance  

As a result, roads often break within months, and there’s little transparency or accountability.  

**Public Road Transparency & Accountability System** aims to change this.  
It’s a web-based solution that makes road project information accessible to citizens and allows them to register complaints about poor or damaged roads.  

This system ensures that government data becomes transparent, and every citizen can track how funds are being utilized for public infrastructure.

---

## 🎯 Key Objectives  

- Bring **transparency** to road construction and maintenance projects  
- Enable citizens to **report complaints** and get acknowledgment  
- Help administrators **track and resolve issues** effectively  
- Promote **accountability and better governance** in public works  

---

## 🧩 System Modules  

### 1️⃣ Public User Module  
- Users can view road project details (contractor, cost, officer, etc.)  
- Can submit a **complaint** if a road is damaged or poorly built  
- On complaint submission, an **email confirmation** is sent automatically  

### 2️⃣ Admin Module  
- Admins can view all registered complaints  
- Update the complaint status (Pending, Resolved, etc.)  
- View analytics of complaints by region, type, or status  

### 3️⃣ Data Analytics Module  
- Visual representation of total complaints, resolved issues, and progress trends  
- Helpful for government monitoring and improving future projects  

---

## ⚙️ Tech Stack  

### **Backend**  
- **Language:** Java 17  
- **Framework:** Spring Boot  
- **Database:** MySQL  
- **ORM:** Spring Data JPA  
- **Email Notifications:** JavaMailSender  
- **Testing:** Postman  

### **Frontend**  
- **Framework:** React.js  
- **Styling:** Tailwind CSS  
- **API Calls:** Axios  
- **Charts:** Chart.js  

### **Other Tools**  
- Git & GitHub  
- IntelliJ IDEA / VS Code  
- Spring Initializr  
- Postman for testing APIs  

---

## 📧 Email Notification Feature  

When a user submits a complaint, the system automatically sends an email acknowledgment.  



This ensures transparency and builds trust between the citizen and the administration.  

---

## 🧱 Database Schema  

### **Complaint Table**

| Column | Type | Description |
|---------|------|-------------|
| id | BIGINT | Primary Key |
| name | VARCHAR | Name of the complainant |
| email | VARCHAR | Email address |
| road_name | VARCHAR | Road name |
| location | VARCHAR | Area or city name |
| message | TEXT | Complaint details |
| status | VARCHAR | PENDING / RESOLVED |
| created_at | TIMESTAMP | Auto-added submission time |

---

## 📡 API Endpoints  

### **Complaint API**
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `POST` | `/api/complaints` | Register a new complaint |
| `GET` | `/api/complaints` | Fetch all complaints |

### **Contractor API**
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `POST` | `/api/contractors` | Add contractor details |
| `GET` | `/api/contractors` | Get all contractors |

### **Officer API**
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `POST` | `/api/officers` | Add officer details |

### **Minister API**
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `POST` | `/api/ministers` | Add minister details |

### **User API**
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/api/users` | Get all registered users |

---

## 🏗️ Setup Instructions  

### 🔹 1. Clone the Repository  
```bash
git clone https://github.com/Sahil-Malaiya/Public-Road-Transparency-System.git
cd Public-Road-Transparency-System
### 🔹 2. Backend Setup (Spring Boot)

Open the project in IntelliJ IDEA or VS Code

Create MySQL database: CREATE DATABASE road_system;

Update src/main/resources/application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/road_system
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=youremail@gmail.com
spring.mail.password=yourapppassword
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
Run the application:
mvn spring-boot:run
Backend will run on http://localhost:8080

🖥️ Frontend Pages (Planned UI Flow)
1. Home Page

Overview of the platform and purpose

“Report a Complaint” button

Small chart showing complaint statistics

2. Complaint Form Page

Fields: Name, Email, Road Name, Location, Message

Validation for required fields

On submission → Data sent to backend → Email confirmation to user

3. Admin Dashboard

List of all complaints

Status update option

Complaint summary and graph analytics

4. About Page

Project purpose and creator information

🔮 Future Enhancements

OTP verification before complaint submission

Google Maps integration to mark exact road location

AI-based complaint categorization

Multi-language support (English, Hindi)

Role-based login system (Admin / User)

🧠 Learnings

During this project, I strengthened my understanding of:

Spring Boot REST API design

Entity relationships and data persistence with JPA

Integration of email services with JavaMailSender

Frontend-backend communication using JSON APIs

Full-stack development workflow from scratch

👨‍💻 Author

Name: Sahil Malaiya
Email: sahilmalaiya7@gmail.com

LinkedIn: linkedin.com/in/sahil-malaiya-0466a4252

GitHub: github.com/Sahil-Malaiya

Conclusion

Public Road Transparency & Accountability System is a step towards open governance and citizen participation.
It brings government data closer to the people and helps identify gaps in infrastructure development.

By combining technology with accountability, this system makes sure that every rupee spent on public works is visible and traceable.

                                                                                   "Transparency isn’t just a word — it’s a responsibility."

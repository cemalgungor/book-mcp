<h1 align="center">book-mcp</h1>
<p align="center">
  <i>A personal project built with Java 17, Spring AI, and the MCP architecture</i><br>
  <i>No commercial intent — purely for self-improvement and experimentation</i>
</p>

---

##  Purpose
This repository is a **personal learning project** focused on the **MCP architecture** (Model-Controller-Provider) using **Java 17** and **Spring AI**.  
The goal is to deepen understanding of AI integration in backend systems with a structured approach.

---

##  Tech Stack
<p align="center">
  <img src="https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_AI-00A859?style=for-the-badge&logo=spring&logoColor=white"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"/>
</p>

---

##  Architecture: MCP (Model-Controller-Provider)
- **M**odel: Domain sınıfları ve veri yapılarını temsil eder  
- **C**ontroller: API endpoint’leri ve iş akışını yönetir  
- **P**rovider: Yapay zeka modellerinin entegrasyonunu sağlar (örneğin: Spring AI ile model çağrıları)

Bu yaklaşım sayesinde kodun modüler, okunabilir ve sürdürülebilir olması hedeflenmiştir.

---

##  Getting Started

### Prerequisites
- Java 17  
- Maven 3.x

### Run Locally
```bash
git clone https://github.com/cemalgungor/book-mcp.git
cd book-mcp
./mvnw spring-boot:run

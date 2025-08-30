<h1 align="center">📚 book-mcp</h1>
<p align="center">
  <i>A personal learning project built with Java 17, Spring Boot, Spring AI and the Model Context Protocol (MCP)</i><br>
  <i>No commercial intent — purely for self-improvement and experimentation</i>
</p>

---

## 🎯 Purpose
This repository is a **personal learning project** created to explore **Spring AI** and the **Model Context Protocol (MCP)** with **Java 17**.  
The aim is to understand how to integrate Large Language Models (LLMs) into a Spring Boot application while experimenting with **MCP as a standard interface**.

---

## 🧩 What is MCP (Model Context Protocol)?
**Model Context Protocol (MCP)** is an emerging open standard that defines how applications communicate with AI models and tools in a consistent way.  

✅ **Why MCP?**  
- Each LLM provider (OpenAI, Anthropic, Gemini, Ollama, etc.) has a different API.  
- MCP provides a **unified protocol** so applications can work with multiple providers without vendor lock-in.  
- Makes it easier to switch models, integrate retrieval or external tools, and build portable AI applications.  

✅ **How it works?**  
- Your Spring AI app acts as an **MCP client**.  
- It communicates with an **MCP server**, which translates the request into the provider’s specific API.  
- The server returns results in a standard JSON format back to the client.  

👉 With MCP, your Spring AI project becomes future-proof, portable, and extensible.

---

## ⚙️ Tech Stack
<p align="center">
  <img src="https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_AI-00A859?style=for-the-badge&logo=spring&logoColor=white"/>
  <img src="https://img.shields.io/badge/MCP-4285F4?style=for-the-badge&logo=json&logoColor=white"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"/>
</p>

---

## 🚀 Getting Started

### Prerequisites
- Java 17  
- Maven 3.x  

### Run Locally
```bash
git clone https://github.com/cemalgungor/book-mcp.git
cd book-mcp
./mvnw spring-boot:run

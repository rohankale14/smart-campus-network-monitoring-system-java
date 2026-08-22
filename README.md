# 🚀 Smart Campus Network Monitoring System

A real-time **Wi-Fi network monitoring system** developed using **Java Spring Boot, Python, HTML, CSS, JavaScript, and Chart.js**.

The system scans nearby Wi-Fi networks, monitors signal strength and latency, detects abnormal network conditions using predefined thresholds, and displays the results through an interactive dashboard.

---

## 📌 Features

* 📡 Real-time Wi-Fi network scanning
* 📶 Signal strength monitoring
* ⏱️ Network latency monitoring
* 🚨 Abnormal network detection
* 📱 Mobile hotspot identification
* 📊 Live charts and statistics
* 🔔 Real-time network alerts
* 🌐 REST API-based backend

---

## 🛠️ Tech Stack

**Backend**

* Java
* Spring Boot
* REST API
* ProcessBuilder

**Frontend**

* HTML
* CSS
* JavaScript
* Chart.js

**Network Monitoring**

* Python 3
* Windows `netsh wlan` commands

---

## ⚙️ How It Works

```text
Wi-Fi Networks
      ↓
   wifi.py
      ↓
Windows netsh wlan
      ↓
Spring Boot + ProcessBuilder
      ↓
Threshold Analysis
      ↓
REST API
      ↓
Web Dashboard
```

The system evaluates network conditions using predefined thresholds:

| Metric          | Normal   | Abnormal |
| --------------- | -------- | -------- |
| Signal Strength | ≥ 50%    | < 50%    |
| Latency         | ≤ 100 ms | > 100 ms |

If either signal strength or latency exceeds the defined threshold, the network is marked as **ABNORMAL** and an alert is displayed.

---

## 📂 Project Structure

```text
SMART-CAMPUS-NETWORK-MONITORING-SYSTEM/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/smartcampus/monitor/
│       │       ├── MonitorController.java
│       │       ├── MonitorService.java
│       │       └── NetworkMonitorApplication.java
│       │
│       └── resources/
│           ├── static/
│           │   └── index.html
│           └── application.properties
│
├── wifi.py
├── pom.xml
└── README.md
```

---

## ▶️ Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/rohankale14/SMART-CAMPUS-NETWORK-MONITORING-SYSTEM.git
cd SMART-CAMPUS-NETWORK-MONITORING-SYSTEM
```

### 2. Check Java and Python

```bash
java -version
python --version
```

### 3. Verify Wi-Fi Scanning

This project uses the Windows `netsh` command:

```bash
netsh wlan show networks mode=bssid
```

### 4. Run the Spring Boot Application

Run:

```text
NetworkMonitorApplication.java
```

or:

```bash
mvn spring-boot:run
```

### 5. Open the Dashboard

```text
http://localhost:8080
```

---

## 🔌 API

### Get Wi-Fi Network Data

```http
GET /api/network/wifi
```

---

## 📊 Dashboard

The dashboard provides:

* Current network status
* Signal strength
* Latency
* Network alerts
* Live graphical statistics
* Detected Wi-Fi networks

Add screenshots to your repository and display them here:

```markdown
![Dashboard](screenshots/dashboard.png)
```

---

## 🔮 Future Enhancements

* 🤖 AI/ML-based network prediction
* 🗄️ Historical network data using MySQL/PostgreSQL/InfluxDB
* 📧 Automated email/Telegram alerts
* 🔐 Spring Security + JWT authentication
* 🐳 Docker and cloud deployment
* 🗺️ Wi-Fi signal heatmap

---

## 🎯 Learning Outcomes

* Spring Boot & REST API development
* Python-Java integration using `ProcessBuilder`
* Wi-Fi/network monitoring
* Real-time data visualization
* Threshold-based anomaly detection
* Frontend-backend integration

---

## 👨‍💻 Author

**Rohan Kale**

🔗 GitHub: https://github.com/rohankale14

---

⭐ If you find this project useful, consider giving it a star!

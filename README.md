# smart-campus-network-monitoring-system-java
# 🚀 SMART CAMPUS NETWORK MONITORING SYSTEM

A Real-Time Smart Campus Network Monitoring System developed using **Java Spring Boot, Python, HTML, CSS, JavaScript, and Chart.js**.

This project monitors nearby WiFi networks, detects abnormal network conditions, analyzes signal strength, measures latency, and displays live graphical statistics through an interactive dashboard.

---

# 📌 Features

✅ Real-Time WiFi Monitoring  
✅ Live Signal Strength Analysis  
✅ Network Latency Detection  
✅ Abnormal Network Detection  
✅ Dynamic Dashboard Visualization  
✅ Real-Time Alert Notifications  
✅ Connected / Disconnected Detection  
✅ Mobile Hotspot Identification  
✅ Live Chart Updates using Chart.js  

---

# 🛠️ Technologies Used

## 💻 Backend
- Java
- Spring Boot
- REST API

## 🎨 Frontend
- HTML
- CSS
- JavaScript
- Chart.js

## 🐍 Python Integration
- Python
- subprocess
- netsh wlan command

---

# 📂 Project Structure

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
├── README.md
└── screenshots/
```

---

# ⚙️ How The System Works

### 1️⃣ WiFi Network Scanning
The Python script scans nearby WiFi networks using:

```python
netsh wlan show networks mode=bssid
```

---

### 2️⃣ Network Analysis
The system analyzes:
- Signal Strength
- Network Latency
- Channel Information
- Abnormal Conditions

---

### 3️⃣ Backend Processing
Spring Boot executes the Python script using:

```java
ProcessBuilder
```

---

### 4️⃣ Real-Time Dashboard
Frontend fetches live network data from:

```text
/api/network/wifi
```

and displays:
- Live Signal Graphs
- Latency Charts
- Alert Notifications
- Network Status

---

# 📊 Dashboard Functionalities

🟢 NORMAL Network Status  
🔴 ABNORMAL Network Detection  
📡 Live Signal Monitoring  
⏱️ Real-Time Latency Tracking  
🚨 Alert Notifications  
📈 Dynamic Graph Updates  

---

# ▶️ How To Run The Project

## Step 1️⃣ Clone Repository

```bash
git clone https://github.com/yourusername/SMART-CAMPUS-NETWORK-MONITORING-SYSTEM.git
```

---

## Step 2️⃣ Open Project

Open the project in:
- IntelliJ IDEA
- Eclipse
- VS Code

---

## Step 3️⃣ Install Python

Verify Python installation:

```bash
python --version
```

---

## Step 4️⃣ Run Spring Boot Application

Run:

```text
NetworkMonitorApplication.java
```

---

## Step 5️⃣ Open Browser

```text
http://localhost:8080
```

---

# 🚀 Future Enhancements

- AI-Based Network Prediction
- Email Alert System
- Database Integration
- User Authentication
- Cloud Monitoring
- Mobile Application Support
- Advanced Analytics Dashboard

---

# 📷 Project Screenshots

Add screenshots inside:

```text
screenshots/
```

Example Screenshots:
- Dashboard UI
- Live Graphs
- Alert Notifications
- Network Status

---

# 🎯 Learning Outcomes

Through this project, I learned:

- Java Spring Boot Integration
- Python & Java Communication
- REST API Development
- Real-Time Data Visualization
- Network Monitoring Concepts
- Frontend Dashboard Design
- ProcessBuilder Integration

---

# 👨‍💻 Author

## Rohan Kale

🔗 GitHub: https://github.com/yourusername  
🔗 LinkedIn: https://linkedin.com/in/yourlinkedin  

---

# ⭐ Conclusion

The Smart Campus Network Monitoring System provides real-time monitoring and analysis of campus WiFi networks. The system helps identify abnormal conditions quickly and improves overall network visibility using live graphical dashboards and alert systems.

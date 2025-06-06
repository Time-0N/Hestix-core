# Hestix-dom

**Hestix-dom** is a self-hosted, modular home management system built for privacy, control, and extensibility.  
Run it on your own server or Raspberry Pi, and take charge of your digital environment with an elegant web interface and powerful backend.

---

## 🔍 Overview

Hestix-dom is designed to be the **nucleus of your self-hosted home infrastructure**.  
It acts as a customizable web-based control panel that integrates:

- 📁 Personal cloud storage  
- 🎵 Audio & video streaming  
- ⚙️ Admin tools to manage APIs and services  
- 🔐 Role-based user authentication (Keycloak compatible)  
- 🧩 Extendable architecture for new features/modules  

> Hestix-dom is privacy-first and infrastructure-light — perfect for Raspberry Pi or other local server setups.

---

## ✨ Features (Current & Planned)

- ✅ Secure login with OAuth2 / Keycloak support  
- ✅ Admin panel for enabling/disabling endpoints  
- ✅ RESTful API backend with modular route loading  
- ✅ Angular frontend for dashboard access  
- ✅ MongoDB integration for file & media metadata  
- 🛠️ GridFS / NAS integration for cloud-like file storage  
- 🔊 Audio & video streaming (basic player and media routes)  
- ⌨️ CLI tools or future app control options  

---

## 🚀 Tech Stack

- **Frontend**: Angular  
- **Backend**: Spring Boot (Java)  
- **Auth**: Keycloak (OAuth2 / OIDC)  
- **Database**: MongoDB (media/files), PostgreSQL (user/auth via Keycloak)  
- **Platform**: Raspberry Pi 5 + NAS (remote DB & storage)  

---

## 📦 Self-Hosting Requirements

- Raspberry Pi 5 (4GB RAM or higher recommended)  
- Docker or Java environment (for backend)  
- NAS with MongoDB & PostgreSQL (or remote DB setup)  
- NGINX or Caddy (optional, for reverse proxy)  

---

## 📚 Documentation

Coming soon in the `/docs` directory.  
Setup, configuration, and module development guides will be added incrementally.

---

## 📌 License

This project is licensed under the **GNU General Public License v3.0**.  
See [`LICENSE`](./LICENSE) for details.

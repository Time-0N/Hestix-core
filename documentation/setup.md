# Hestix-core Setup Guide

## 🌍 Prerequisites

Before starting Hestix-core, make sure you have the following:

- **PostgreSQL database** (local or remote)
- **Keycloak server** for user authentication
- **Docker environment** (if using containers for backend and frontend)
- **Raspberry Pi 5** or a similar local server for hosting the app
- **NAS storage** for storing files and media

---

## 🔧 Dev Configuration

### 1. **Environment Variables**

Create a `.env` file at the root of your project, and define the following environment variables.  
For detailed information on setting up your environment variables, please refer to the [`/docs/environment.md`](./docs/environment.md) file.

---

### 2. **Port Configuration**

The backend application listens on **port 9090** by default. If you want to change this port, you can do so by setting the `SERVER_PORT` in your `.env` file.

To change the port, add the following to your `.env` file:

SERVER_PORT=9090  # Default port, can be changed to any available port

---

### 3. **Build Profile Configuration**

To tell gradle with what build profile it should build the project with. Set `BUILD_PROFILE` in your `.env` file.

Possible values are: `dev`, `prod`
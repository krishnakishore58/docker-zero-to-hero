# 1. simple_dockerfile
This project demonstrates how to serve a static HTML page using Nginx in a Docker container. The setup uses a minimal `nginx:alpine` image for efficiency.

---

#### Usage

#### I. Add Your `index.html`
Place your custom `index.html` in the same directory as the Dockerfile.
#### II. Build the Docker Image
```bash
docker build -t simple-nginx .
```
#### III. Run the Container
```bash
docker run -d -p 8080:80 simple-nginx
```
#### IV. View in Browser
Open http://localhost:8080 to see your static page.

---

# 2. medium_dockerfile
This project demonstrates how to containerize a Node.js application using Docker with a lightweight `node:18-alpine` base image. The setup installs dependencies, copies your application code, sets environment variables, and exposes the application port.

---

### Usage

#### I. Add Your Application Files
Ensure your `app.js` and `package.json` are in the same directory as the `dockerfile`.
#### II. Build the Docker Image
```bash
docker build -t node-app -f dockerfile .
```
#### III. Run the Container
```bash 
docker run -d -p 3000:3000 node-app
```
#### IV. View in Browser
Open http://localhost:3000 to access your Node.js application.

---

# 3. complex_dockerfile
This project demonstrates how to build a robust, production-ready Python application container using a multi-stage Docker build with the lightweight `python:3.11-slim` image. The setup includes dependency isolation, non-root execution, persistent volumes, and a healthcheck.

---

### Usage

#### I. Add Your Application Files
- Place your Python application files (e.g., `test`, `app.py`, etc.) and `requirements.txt` in the same directory as the `dockerfile`.
#### II. Build the Docker Image
```bash
docker build -t complex-python-app -f dockerfile .
```
#### III. Run the Container
```bash 
docker run -d -p 8080:8080 \
  -v $(pwd)/data:/app/data \
  -v $(pwd)/logs:/app/logs \
  --name my-python-app \
  complex-python-app
```
#### IV. Healthcheck
Docker will automatically run the healthcheck defined in the Dockerfile.
You can check the health status with:
```bash
docker inspect --format='{{.State.Health.Status}}' my-python-app
```
---

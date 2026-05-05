# 3-Tier App with Trivy Vulnerability Scanning

## Overview

This project demonstrates a simple 3-tier application (PostgreSQL database, Spring Boot backend, Nginx frontend) with integrated security scanning using [Trivy](https://github.com/aquasecurity/trivy). Trivy is an open-source vulnerability scanner for containers, source code, and dependencies.

---

## What is Trivy?

**Trivy** is a comprehensive security scanner that detects vulnerabilities in:
- Container images (Docker, OCI)
- File systems and source code repositories
- Application dependencies (e.g., Java, Python, Node.js)
- Infrastructure as Code (IaC) files (e.g., Kubernetes, Terraform)

---

## Why Use Trivy?

- **Early detection:** Find vulnerabilities before deploying to production.
- **Wide coverage:** Scans OS packages, language libraries, and IaC.
- **Easy integration:** Works with Docker, CI/CD pipelines, and local development.
- **Actionable results:** Shows severity, affected packages, and fixed versions.

---

## Basic Trivy Commands

- **Scan a Docker image:**
  ```sh
  trivy image my-image:tag
  ```
- **Scan a local filesystem or project directory:**
  ```sh
  trivy fs .
  ```
- **Scan for vulnerabilities and output as a table:**
  ```sh
  trivy image --format table my-image:tag
  ```
- **Scan and output to a file:**
  ```sh
  trivy image --output report.txt my-image:tag
  ```

---

## How Trivy is Used in This Project

- **Docker Compose Integration:**  
  The `docker-compose.yml` file defines services for the app and two Trivy scan jobs (`trivy-backend` and `trivy-frontend`).
- **Automated Scanning:**  
  After building the backend and frontend images, Trivy scans each image for vulnerabilities in OS packages and Java dependencies.
- **Report Generation:**  
  Trivy outputs vulnerability reports to the `report` directory on the host machine for review.

**Example from `docker-compose.yml`:**
```yaml
trivy-backend:
  image: aquasec/trivy:latest
  command: image --exit-code 0 --no-progress --format table --output /report/backend_trivy_report.txt 3_tier_app-backend
  volumes:
    - /var/run/docker.sock:/var/run/docker.sock
    - /Users/muslekri/testing_dir/report:/report
  depends_on:
    - backend
  restart: "no"
```

---

## How Trivy Helps Fix Vulnerabilities

- **Identifies vulnerable packages and libraries** in your images and code.
- **Shows severity levels** (CRITICAL, HIGH, MEDIUM, LOW) so you can prioritize fixes.
- **Lists fixed versions** for dependencies, guiding you to upgrade to safe versions.
- **Provides reference links** for each vulnerability for further details and remediation steps.

**Typical Fix Workflow:**
1. **Review Trivy report** for HIGH/CRITICAL vulnerabilities.
2. **Upgrade dependencies** in `pom.xml` or your Docker base image as suggested by the report.
3. **Rebuild and re-scan** your images to ensure vulnerabilities are resolved.
4. **Automate scanning** in your CI/CD pipeline for continuous security.

---

## References

- [Trivy GitHub](https://github.com/aquasecurity/trivy)
- [Trivy Documentation](https://aquasecurity.github.io/trivy/)
- [Aqua Vulnerability Database (AVD)](https://avd.aquasec.com/)

---
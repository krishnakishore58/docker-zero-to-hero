# Multi-Stage Docker Build: A Practical Comparison

This directory demonstrates the **importance and benefits of multi-stage Docker builds** by building the same Java backend and static frontend application in two different ways:

- [`with_multi_stage_docker_build`](examples/with_multi_stage_docker_build/)
- [`without_multi_stage_docker_build`](examples/without_multi_stage_docker_build/)

---

## Why Multi-Stage Builds?

Multi-stage builds allow you to use multiple `FROM` statements in your Dockerfile. This lets you separate the build environment (which may require many tools and dependencies) from the final runtime image (which only needs the built application and its runtime dependencies). The result is a **smaller, cleaner, and more secure image**.

---

## Example Structure

Each example contains:
- A **backend** Java application (Spring Boot)
- A **frontend** static site served by Nginx
- Dockerfiles and supporting files for both

---

## Image Size Comparison

| Build Type                  | Backend Image Size |
|-----------------------------|-------------------|
| With Multi-Stage Build      | 528 MB            |
| Without Multi-Stage Build   | 1.05 GB           |

- **With multi-stage:** Only the minimal JRE and built application are included in the final image.
- **Without multi-stage:** The image contains the full build toolchain (JDK, Maven, caches, etc.), making it much larger.

---

## Security Benefits

- **Reduced Attack Surface:**  
  Multi-stage builds exclude unnecessary build tools and files from the final image, reducing the number of potential vulnerabilities.
- **Fewer Dependencies:**  
  Only runtime dependencies are present, so there are fewer packages that could be exploited.
- **Cleaner Images:**  
  Sensitive files (like source code, build secrets, or credentials accidentally left in the build context) are less likely to end up in the final image.

---

## How to Try It

1. **Build and Run Each Example:**
   - Navigate to each subdirectory (`with_multi_stage_docker_build` and `without_multi_stage_docker_build`)
   - Build the backend image:
     ```bash
     docker build -t backend-app .
     ```
   - Check the image size:
     ```bash
     docker images backend-app
     ```

2. **Observe the Difference:**
   - The multi-stage build image is significantly smaller and contains only what is needed to run the app.

---

## Conclusion

**Multi-stage Docker builds** are a best practice for modern containerized applications.  
They produce smaller, more secure, and more maintainable images—making your deployments faster and safer.

Explore the `examples/` folders to see the difference
# Docker Networking Fundamentals

Docker networking enables containers to communicate with each other, the host, and external systems. It provides a virtual private network for containers, allowing for secure, scalable, and flexible communication.

---

## Why Use Docker Networks?

- **Without Docker networks:**  
  - Containers must communicate via IP addresses, which can change.
  - Exposing ports with `-p` allows host-to-container communication, but not container-to-container by name.
- **With Docker networks:**  
  - Containers can communicate using service/container names (DNS-based discovery).
  - Simplifies service discovery and improves security and scalability.

| Scenario                          | Without Docker Network      | With Docker Network (Recommended) |
|------------------------------------|----------------------------|-----------------------------------|
| Container-to-container by name     | ❌ Hard/Not possible        | ✅ Easy (DNS by name)              |
| Container-to-container by IP       | 😕 Possible, but hard       | ✅ Easy                            |
| External system to container       | ✅ (via port mapping)       | ✅ (via port mapping)              |
| Isolation & Security               | ❌ Weak                     | ✅ Strong                          |
| Scalability                        | ❌ Hard                     | ✅ Easy                            |

---

## Types of Docker Networks

1. **Bridge**
   - Default network for containers on a single host.
   - Containers can communicate by name without specifying ports.
   - Example:  
     ```bash
     docker network create --driver bridge <network_name>
     ```

2. **Host**
   - Containers use the host’s networking stack directly.
   - Preferred for high-performance applications.
   - Removes network isolation between host and container.

3. **Overlay**
   - Enables communication between containers on different hosts.
   - Suitable for multi-host and distributed applications.

4. **Macvlan**
   - Assigns a MAC address to each container, making it appear as a physical device on the network.
   - Containers can communicate directly with the external network.

5. **None**
   - Disconnects the container from all networks.
   - Useful for applications that do not require network access.

---

## Examples

### Example 1: DNS and Container Discovery

Create a custom network and run containers on it:

```bash
docker network create my_app_net

docker run -d --name my_nginx --network my_app_net nginx:stable-alpine3.23-slim
docker run -it --name my_alpine --network my_app_net postgres:9.3.21-alpine sh
```

Inside the my_alpine container, you can ping my_nginx by name:
``` ping my_nginx ```

### Example2: Establishing Connectivity Between Web Server and Database.
Please follow the ending part of the video for all steps in detail wherein I had illustrated the example#2.

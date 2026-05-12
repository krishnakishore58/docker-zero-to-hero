# Docker Compose Guide

## What is Docker Compose?

Docker Compose is a tool for defining and running multi-container Docker applications using a single YAML file. It simplifies the process of managing complex applications that require multiple interconnected services.

## Why Use Docker Compose?

- **Container Orchestration**: Configure relationships between containers (application, database, proxy, workers, etc.) and manage them as a unified system
- **Simplified Configuration**: Save Docker container run command settings in an easy-to-read YAML file instead of managing multiple complex run commands
- **Reproducible Environments**: Ensure consistent deployments across different environments

**Can't we setup the application from example (07_docker_compose/examples/3_tier_app) without docker-compose?**

We can, but we need create each resource separately and keep a track of it. Difficult right? Hence, we have docker-compose

```bash
docker volume create db_data

docker network create appnet

docker run -d \
  --name db \
  --network appnet \
  -e POSTGRES_DB=demo \
  -e POSTGRES_USER=demo \
  -e POSTGRES_PASSWORD=demo \
  -v db_data:/var/lib/postgresql/data \
  postgres:9.3.21-alpine

docker build -t my-backend ./backend

docker run -d \
  --name backend \
  --network appnet \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/demo \
  -e SPRING_DATASOURCE_USERNAME=demo \
  -e SPRING_DATASOURCE_PASSWORD=demo \
  --link db:db \
  my-backend

docker build -t my-frontend ./frontend

docker run -d \
  --name frontend \
  --network appnet \
  -p 8088:80 \
  --link backend:backend \
  my-frontend
```

## Essential Commands

### Configuration & Validation

```bash
# Validate the compose file
docker-compose config
```

### Starting Services

```bash
# Run compose file (creates containers and applications in detached mode)
docker-compose up -d

# Scale specific services
docker-compose up -d --scale database=4

# Use custom compose file
docker-compose -f mydockercompose.yml up -d
docker-compose -f mydockercompose.json up -d

# Create volumes/networks and start all containers (foreground)
docker-compose up
```

### Managing Services

```bash
# Stop all containers and remove networks
docker-compose down

# Stop containers and remove volumes
docker-compose down --volumes

# Start existing containers
docker-compose start

# Pause/unpause services
docker-compose pause
docker-compose unpause

# Kill running containers
docker-compose kill
```

### Monitoring & Debugging

```bash
# Check running containers
docker-compose ps

# View processes in containers
docker-compose top

# Watch logs in real-time
docker-compose logs -f

# Check port mappings for a service
docker-compose port <service-name> 80

# Execute commands in running containers
docker-compose exec <service-name> ls
```

## Best Practices

- Always validate your compose file with `docker-compose config` before deployment
- Use version control for your `docker-compose.yml` files
- Leverage environment variables for configuration that changes between environments
- Use named volumes for persistent data
- Define custom networks for service isolation
- Use `depends_on` to manage service startup order

## Common Use Cases

- **Development Environment**: Quickly spin up databases, caches, and other dependencies
- **Testing**: Create isolated environments for integration testing
- **Production**: Deploy multi-service applications with proper networking and volumes
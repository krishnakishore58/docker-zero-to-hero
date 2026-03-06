# Docker Architecture
Docker has a `client-server` architecture – wherein Docker Client is the Client and Docker Demon is Server.

When we install docker we get Docker client & Docker Demon. These both would be treated as Docker Engine.

![docker_arch_screenshot](./images/docker-architecture.webp)

- Docker client – on which we run docker commands and through CLI or REST APIS Docker Demon receives them.
- Docker Demon – which has Images and Containers.
- Docker Registry – There would be Docker Registry as well like Docker Hub where in we keep Docker images. When we need them, we pull Docker image from Docker Hub and create containers.

##### What are Docker Containers-
These are running instance of a Docker image

Docker hub url: https://hub.docker.com/
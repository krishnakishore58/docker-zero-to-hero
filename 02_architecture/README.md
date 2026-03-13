# Docker Architecture
Docker has a `client-server` architecture – wherein Docker Client is the Client and Docker Demon is Server.

When we install docker we get Docker client & Docker Demon. These both would be treated as Docker Engine.

![docker_arch_screenshot](./images/docker-architecture.webp)

- Docker client – on which we run docker commands and through CLI or REST APIS Docker Demon receives them.
- Docker Demon – which has Images and Containers.
- Docker Registry – There would be Docker Registry as well like Docker Hub where in we keep Docker images. When we need them, we pull Docker image from Docker Hub and create containers.
- Docker Objects - We deal with docker objects like images, containers, volumes, network types, plugins etc.

Example: `docker run -i -t ubuntu /bin/bash`

##### What are Docker Containers-
These are running instance of a Docker image

Docker hub url: https://hub.docker.com/

##### Container Runtime -
Containerd: It is a container runtime used to manage lifecycle of the container. It is a daemon process that helps in creating/destroying/starting/stoping the container, network attachment, managing low level storage etc. K8s uses containerd as its default container runtime.

Now you might have confused b/w Docker and Containerd - isn't?

Let's take a pause and breath!

To make you understand in a very simple words - **assume containerd as a turgo charger and Docker as an engine OR Containerd as Air Condition and Docker as a house**. Therefore, they are two separate things but works together.
Most importantly Containerd is part of Docker Engine and on the other side it can also be used independent to the Docker in orchestration tools like kubernetes.

###### Key features of Containerd -
- Container Lifecycle Management: It helps in managing start/stop/create/destroy container and in storage allocation/management and network attachment.
- Image Management: It provides functionality to pull/push/manage images from the registry.
- Distributed architecture: It functions as client-server architecture wherein orchestration systems like kubernetes talks to Containerd.
- Pluggable and Extensible: It can be pluggable and added as an extention to container ecosystem.
- Open Source: It is an open source project and has a large community support.

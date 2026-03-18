- Install Docker on ubuntu:  
`$sudo apt install docker.io`

This command might get older version of docker so it’s better to follow to below approach which brings latest version. Also, based on our Linux distribution it chooses the deliverable accordingly.

`$curl -fsSL https://get.docker.com -o get-docker.sh`

`$sh get-docker.sh`

- Verify docker installed:  
`$docker --version`

- Verify docker-compose installed:  
`$docker-compose --version`

- Start/stop docker:  
`$service docker start/stop`
 
- Ensure docker running and other info:  
`$docker info`

- Login to docker registry:  
`$docker login`

- Pulling image from docker hub:  
`$sudo docker pull nginx:stable-alpine3.23-slim`  
Pulls the nginx image of version stable-alpine3.23-slim and if we don’t mention anything it just pulls latest version

- shows up dangling and non-dangling images:  
`$docker images –f “dangling=true”`  
`$docker images –f “dangling=false”`

- Creating docker container:  
`$docker run --publish 81:80 –-detach –-name mywebhost nginx:stable-alpine3.23-slim`

- Create and login to the container:  
`$docker run -it --publish 81:80 –-name mywebhost nginx:stable-alpine3.23-slim /bin/sh`

- Login to the running container:  
`$docker exec -it mywebhost /bin/sh`

- List running processes or containers:  
`$docker ps -a`  
This shows all process –i.e. stopped, running etc.

- View container logs:  
`$docker container logs <container_name>`

- Inspect container:  
`$docker container inspect <container_name>`  
This returns low level information on docker objects

- To know all the source hosts sending out traffic to this container (important):  
`$docker container port webhost`

- To stop/start container:  
`$docker start/stop <container_name>`

- To get CPU and memory details of containers:  
`$docker stats`

- Disk details:  
`$docker system df`

- Remove image:  
`$docker rmi imageid`

- Remove container:  
`$docker rm <container_name>`

- Removes all unused/stopped images:  
`$sudo docker system prune -a -f`

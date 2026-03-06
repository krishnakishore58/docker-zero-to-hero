##### Install Docker on ubuntu-
`$sudo apt install docker.io`
This command might get older version of docker so it’s better to follow to below approach which brings latest version. Also, based on our Linux distribution it chooses the deliverable accordingly.
 
`$curl -fsSL https://get.docker.com -o get-docker.sh`
`$sh get-docker.sh`

- Start/stop docker-
`$sudo service docker start/stop`
 
- Ensure docker running and other info
`$docker info`

- Login to docker registry
`$docker login`

- Pulling image from docker hub-
`$sudo docker pull nginx:stable-alpine3.23-slim`
Pulls the nginx image of version stable-alpine3.23-slim and if we don’t mention anything it just pulls latest version

- Pulling dangling and non-dangling images
`$docker images –f “dangling=true”`
`$docker images –f “dangling=false”`

- Remove image
`$docker rmi imageid`

- Creating docker container-
`$docker run <imageid>`
`$docker run --publish 81:80 –-detach –-name mywebhost nginx:stable-alpine3.23-slim`
Checks for image nginx locally and if it doesn’t present it pulls from docker hub and creates a container
“publish” points local hosts’s port 81 to container port 80
“detach” runs the container in the background
“1.11” explicitly change version of image
Note: when we use –-detach option “docker run” acts as to create and start container otherwise it just used as to create a container

- Create and login to the container-
`$docker run -it --publish 81:80 –-detach –-name mywebhost nginx:stable-alpine3.23-slim /bin/bash`

- Login to the running container-
`$docker exec -it mywebhost /bin/bash`

- List running processes or containers-
`$docker ps -a`
This shows all process –i.e. stopped, running etc.

- View container logs-
`$docker container logs <container_name>`

- Inspect container-
`$docker container inspect <container_name>`
This returns low level information on docker objects

- Removes all unused/stopped images
`$sudo docker system prune -a -f`

- To see all ports connected to container
`$docker container port <container_name>`
Webhost is container name.
This command helps us in understanding from which all ports traffic is routing to this container. 

- To stop/start container-
`$docker start/stop <container_name>`

- Remove container-
`$docker rm <container_name>`

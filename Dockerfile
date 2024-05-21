FROM bellsoft/liberica-openjdk-debian:11.0.18

#RUN apk add curl jq For aiphine apt for debian,Ubuntu

RUN apt update && apt install -y curl jq

#workspace
WORKDIR /home/selenium-docker

# Add required files
ADD target/docker-resources  ./
ADD runner.sh                runner.sh


#Run the Test
ENTRYPOINT sh runner.sh

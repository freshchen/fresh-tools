#!/usr/bin/env bash

jenkins_container_name="myjenkins"

docker pull jenkins/jenkins:latest
docker run -name ${jenkins_container_name} -d -v jenkins_home:/var/jenkins_home -p 8080:8080 -p 50000:50000 jenkins/jenkins:latest
docker exec ${jenkins_container_name} cat /var/jenkins_home/secrets/initialAdminPassword
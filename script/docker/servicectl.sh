#!/usr/bin/env bash


prepare(){
    PORT=$(cat application.* | grep -v "^#" | grep -w 'port' | sed 's/ //g' | cut -d '=' -f2)
    JAR_PATH="../../../target/"
    JAR_NAME=$(ls ${JAR_PATH} | grep '.*.jar$')
    IMAGE_NAME=$(echo ${JAR_NAME} | awk -F '-' '{print $1}')
}


docker_file(){
cat >> Dockerfile << EOF
FROM openjdk:8u212
MAINTAINER freshchen
VOLUME /tmp
ADD ${JAR_NAME} app.jar
RUN bash -c 'touch /app.jar'
EXPOSE ${PORT}
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EOF
}

docker_start(){
    docker_file
    docker build -t ${IMAGE_NAME}:latest -f Dockerfile ${JAR_PATH}
    docker run -d --name ${IMAGE_NAME} -p ${PORT}:${PORT} ${IMAGE_NAME}:latest
    rm -f Dockerfile
}

docker_kill(){
    docker kill ${IMAGE_NAME}
    docker rm ${IMAGE_NAME}
}

print_usage() {
    echo "Usage: $0 [-s|-k]"
    echo "Usage: -s start"
    echo "Usage: -k kill"
}

parse_param() {
    if [[ $# -eq 1 ]] && [[ "${1}" == "-s"  ]];then
        docker_start
    elif [[ $# -eq 1 ]] && [[ "${1}" == "-k"  ]];then
        docker_kill
    else
        print_usage
        exit 1
    fi
}

main(){
    prepare
    parse_param "$@"
}

main "$@"
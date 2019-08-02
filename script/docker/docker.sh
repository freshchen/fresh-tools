#!/usr/bin/env bash

prepare(){
    CURRENT_PATH=$(cd "$(dirname "$0")"; pwd)
    cd ${CURRENT_PATH}
    PORT=$(cat ${APP_NAME}/src/main/resources/application.* | grep -v "^#" | grep -w 'port' | sed 's/ //g' | cut -d '=' -f2)
    JAR_PATH="${APP_NAME}/target/"
    JAR_NAME=$(ls ${JAR_PATH} | grep '.*.jar$')
    IMAGE_NAME="freshchen/${APP_NAME}:latest"

    if [[ ${JAR_NAME} = "" ]] ; then
        echo jar file not exist
        exit 1
    fi
    if [[ ${PORT} == "" ]]; then
        PORT=8080
    fi
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

build(){
    prepare

    docker_file

    docker build -t ${IMAGE_NAME} -f Dockerfile ${JAR_PATH}

    rm -f Dockerfile
}

push(){

    prepare

    docker login || exit 1

    docker push ${IMAGE_NAME}

}

print_usage() {
    local script_name=$(basename $0)
    echo "Usage: ${script_name} [-b|-p] [j]"
    echo "Command1:"
    echo "  -b build docker image"
    echo "  -p push docker image"
    echo "Command2:"
    echo "  j app name jcrypto"
    exit 1
}

parse_param() {
    if [[ ! $# -eq 2 ]]; then
        print_usage
    elif [[ "$1" == "-b" ]] && [[ "$2" == "j" ]]; then
        APP_NAME="jcrypto"
        build
    elif [[ "$1" == "-p" ]] && [[ "$2" == "j" ]]; then
        APP_NAME="jcrypto"
        push
    else
        print_usage
    fi
}

parse_param "$@"
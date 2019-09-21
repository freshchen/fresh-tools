FROM openjdk:8u212
MAINTAINER freshchen
VOLUME /tmp
ENV TZ='Asia/Shanghai'
RUN apt update \
          && ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone \
          && apt install tzdata \
          && apt clean \
          && apt autoclean \
          && rm -rf /var/lib/apt/lists/* /var/tmp/*
ADD java-tools-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 1994
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
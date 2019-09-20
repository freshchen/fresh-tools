FROM openjdk:8u212
MAINTAINER freshchen
VOLUME /tmp
ADD java-tools-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 1994
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
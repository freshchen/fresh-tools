FROM openjdk:11.0.7-jre-slim
MAINTAINER freshchen
VOLUME /tmp
ADD tools-0.0.1-SNAPSHOT.jar app.jar
RUN touch /app.jar
ENV JAVA_OPTS=""
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar
FROM khipu/openjdk17-alpine
MAINTAINER Anhlam<senlong2k@gmail.com>
ARG JAR_FILE=target/*.jar
WORKDIR /app
VOLUME ["/app"]
COPY ${JAR_FILE} /app/application.jar
CMD ["java", "-jar", "application.jar"]

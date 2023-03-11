FROM openjdk:11
MAINTAINER Anhlam<senlong2k@gmail.com>
WORKDIR /app
VOLUME /tmp
#COPY libs/mssql-jdbc_auth-9.4.0.x64.dll ${JAVA_HOME}/lib/mssql-jdbc_auth-9.4.0.x64
#COPY libs/mssql-jdbc_auth-9.4.0.x64.dll /usr/java/packages/lib/
COPY target/petrang-0.0.1-SNAPSHOT.jar /app
EXPOSE 80:80
CMD ["java", "-jar", "petrang-0.0.1-SNAPSHOT.jar"]

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY . .
ENTRYPOINT ["java", "-jar", "/storage-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
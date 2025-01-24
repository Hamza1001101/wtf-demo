FROM eclipse-temurin:23-jdk-alpine as builder

WORKDIR /app


COPY target/*.jar bankgiro.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "bankgiro.jar"]
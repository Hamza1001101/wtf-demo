FROM eclipse-temurin:23-jdk-alpine as builder

WORKDIR /app


COPY . /app

RUN chmod +x ./mvnw

RUN ./mvnw clean package -DskipTests


FROM eclipse-temurin:23-jdk-alpine
WORKDIR /app

COPY --from=builder /app/target/*.jar bankgiro.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "bankgiro.jar"]
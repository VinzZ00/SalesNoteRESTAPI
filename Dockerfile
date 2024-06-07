FROM maven:3-openjdk-17 as build
COPY . .
RUN mvn clean package -DskipTests
# RUN java --version

FROM openjdk:23-ea-21-jdk-slim
COPY --from=build /target/salesBackEndApp-0.0.1-SNAPSHOT.jar backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend.jar"]
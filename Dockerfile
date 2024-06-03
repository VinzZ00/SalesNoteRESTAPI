FROM arm64v8/maven:3-openjdk-18-slim as build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:23-ea-21-jdk-slim
# print java version
RUN java -version
COPY --from=build /target/salesBackEndApp-0.0.1-SNAPSHOT.jar backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend.jar"]
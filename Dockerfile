FROM maven:3.6-openjdk-17-slim  AS build
WORKDIR /app
COPY . .

RUN mvn -f ./pom.xml clean package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar ./app.jar


ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","app.jar"]
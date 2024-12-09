FROM maven:3.9.9-eclipse-temurin-21@sha256:7308e0b86b752ff3bedfc50a8db8d0ce8f03b912ad2c109dbe154a988b74e4d7 AS build
WORKDIR /app

# First copy dependencies and resolve those to speed up container rebuilds on code changes
COPY pom.xml pom.xml
RUN mvn verify --fail-never

# Copy source code and build project
COPY src src
RUN mvn clean package

# Ready made JRE
FROM eclipse-temurin:21.0.5_11-jre-noble@sha256:860f93f736431d707b8819de4a269d3a21eb0bb853953d8730ed855ae912fefc

# set the workdir to /app - then can use realtive path for app destination, also file download then happens here, as WORKDIR sets the working directory for the container run
WORKDIR /app

COPY --from=build /app/target/hw-0.0.1-SNAPSHOT.jar app.jar
COPY stations-fallback.csv stations-fallback.csv
CMD ["java", "-jar", "app.jar"]
# docker build --no-cache -t hw .
# docker run --rm -it -p 8080:8080 hw

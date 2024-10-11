# Use a base image with JDK
FROM openjdk:23-jdk-slim AS build

# Set the working directory
WORKDIR /app

# Copy the Gradle wrapper and configuration files
COPY gradlew gradlew
COPY gradle/wrapper/ gradle/wrapper/

# Copy the build.gradle and settings.gradle files
COPY build.gradle settings.gradle ./

# Copy the entire project to the container
COPY . .

# Grant execute permissions to the Gradle wrapper
RUN chmod +x gradlew

# Build the application
RUN ./gradlew clean build --no-daemon

# Second stage: create the runtime image
FROM openjdk:23-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the application port (default Spring Boot port is 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

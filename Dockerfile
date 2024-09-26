# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21

# Set the working directory inside the container
WORKDIR /app

# Copy the build.gradle and gradle wrapper files
COPY build.gradle.kts .
COPY gradlew .
COPY gradle/ gradle/

# Copy the source code
COPY src/ src/

# Download dependencies and build the application
RUN ./gradlew build --no-daemon

# Copy the built jar file
COPY build/libs/*.jar app.jar

# Expose the port
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

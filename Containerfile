# Use an official OpenJDK runtime as a base image.
FROM openjdk:11-jre-slim

# Add the application's JAR file to the container.
COPY target/Capstone-0.0.1-SNAPSHOT.jar /app/Capstone.jar

# Expose the port the app runs on (change if necessary).
EXPOSE 8080

# Run the JAR file.
ENTRYPOINT ["java", "-jar", "/app/Capstone.jar"]

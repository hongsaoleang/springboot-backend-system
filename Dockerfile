# Stage 1: Build the application using Maven
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
# We use eclipse-temurin because the old openjdk image is deprecated
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /target/*.jar app.jar
EXPOSE 8080

# Limit memory to 128MB to stay within Render's free tier (256MB total)
ENTRYPOINT ["java", "-Xmx128m", "-jar", "app.jar"]
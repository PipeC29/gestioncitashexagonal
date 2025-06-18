FROM maven:3.6.3-openjdk-8
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/gestioncitas-1.0.0.jar"]

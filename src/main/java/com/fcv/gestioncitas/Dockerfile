# Imagen base con Java 8
FROM openjdk:8-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el .jar compilado
COPY target/gestioncitas-1.0.0.jar app.jar

# Expone el puerto de la aplicación
EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]

# Verwenden des offiziellen OpenJDK-Images als Basis
FROM openjdk:latest

# Setzen des Arbeitsverzeichnisses innerhalb des Containers
WORKDIR /app

# Kopieren der Spring Boot JAR-Datei in das Arbeitsverzeichnis im Container
COPY webtech-project-portal-0.0.1-SNAPSHOT.jar /app/webtech-project-portal-0.0.1-SNAPSHOT.jar

# Exponieren des Ports 8080, den die Spring Boot-Anwendung verwendet
EXPOSE 8080

# Starten der Spring Boot-Anwendung beim Start des Containers
CMD ["java", "-jar", "webtech-project-portal-0.0.1-SNAPSHOT.jar"]

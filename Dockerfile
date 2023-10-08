# Utiliza una imagen base que contenga las herramientas de compilación necesarias, como Maven o Gradle.
# En este ejemplo, utilizamos una imagen Maven.
FROM --platform=linux/amd64 ubuntu:20.04 AS builder

RUN apt-get update && apt-get install -y \
    wget \
    && rm -rf /var/lib/apt/lists/*

# Define una variable de entorno para la versión de Maven que deseas instalar
ENV MAVEN_VERSION 3.8.2

# Descarga y descomprime Apache Maven
RUN wget https://dlcdn.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.tar.gz -O /tmp/apache-maven-3.9.5-bin.tar && \
    tar xzf /tmp/apache-maven-3.9.5-bin.tar -C /opt && \
    rm -f /tmp/apache-maven-3.9.5-bin.tar

# Configura las variables de entorno para Maven
ENV MAVEN_HOME /opt/apache-maven-3.9.5
ENV PATH $MAVEN_HOME/bin:$PATH

RUN wget https://download.java.net/java/GA/jdk21/fd2272bbf8e04c3dbaee13770090416c/35/GPL/openjdk-21_linux-x64_bin.tar.gz -O /tmp/openjdk-21_linux-x64_bin.tar && \
    tar xzf /tmp/openjdk-21_linux-x64_bin.tar -C /usr/local && \
    rm -f /tmp/openjdk-21_linux-x64_bin.tar

# Set environment variables (if needed)
ENV JAVA_HOME /usr/local/jdk-21
ENV PATH $PATH:$JAVA_HOME/bin

# Copia el archivo de definición de dependencias (pom.xml) al contenedor
COPY pom.xml .

# Copia el código fuente de la aplicación al contenedor
COPY src src

# Compila la aplicación dentro del contenedor
RUN mvn package

# Segunda etapa: utiliza una imagen más liviana para ejecutar la aplicación compilada
FROM openjdk:21-slim

# Copia el archivo JAR compilado desde la etapa de compilación anterior
COPY --from=builder target/superheroes_test-0.0.1-SNAPSHOT.jar /app.jar

# Expone el puerto en el que tu aplicación se ejecutará
EXPOSE 8080

# Configura las variables de entorno (si es necesario)
ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:testdb
ENV SPRING_DATASOURCE_USERNAME=sa


# Comando para ejecutar la aplicación cuando el contenedor se inicie
CMD ["java", "-jar", "/app.jar"]
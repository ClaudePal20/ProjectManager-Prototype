# Usar una imagen base de OpenJDK 11
FROM openjdk:11

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Instalar JavaFX (asumiendo que estás utilizando una imagen basada en Debian/Ubuntu)
RUN apt-get update && apt-get install -y openjfx

# Instalar Maven
RUN apt-get install -y maven

# Copiar el archivo pom.xml al directorio de trabajo en el contenedor
COPY pom.xml ./

# Copiar el código fuente Java a la aplicación en el contenedor
COPY src/ ./src

# Compilar la aplicación Java con Maven
RUN mvn clean install -DskipTests -X

# Compilar la aplicación Java
RUN javac src/main/java/org/example/bibliotecadecodigopmi/gui/PMBOKLibraryGUI.java

# Ejecutar la aplicación Java
CMD ["java", "org.example.bibliotecadecodigopmi.gui.PMBOKLibraryGUI"]

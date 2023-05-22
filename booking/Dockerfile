# Establece la imagen base de OpenJDK 17
FROM eclipse-temurin:17
# Establece el directorio de trabajo en /app
WORKDIR /app
# Copia los archivos de construcción necesarios (build.gradle, settings.gradle, etc.)
COPY build.gradle settings.gradle gradlew /app/
# Copia el directorio gradle completo (incluyendo el wrapper) para aprovechar la caché de dependencias
COPY gradle /app/gradle
# Copia el directorio de código fuente
COPY src /app/src
# Ejecuta la tarea de construcción en el contenedor
RUN ./gradlew build
# Expone el puerto en el que tu aplicación se ejecutará (ajusta el número de puerto según sea necesario)
EXPOSE 8080
# Comando para ejecutar tu aplicación Spring Boot
CMD ["java", "-jar", "build/libs/booking-0.0.1-SNAPSHOT.jar"]

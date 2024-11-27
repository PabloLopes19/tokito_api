# Etapa 1: Imagem base para construção
FROM gradle:7.6-jdk17 AS build
WORKDIR /app

# Copiar todos os arquivos do projeto para o container
COPY . .

# Garantir permissões de execução para o Gradle Wrapper
RUN chmod +x ./gradlew

# Executar o build da aplicação
RUN ./gradlew bootJar --no-daemon

# Etapa 2: Imagem base para execução
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copiar o JAR gerado na etapa anterior
COPY --from=build /app/build/libs/*.jar app.jar

# Expor a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
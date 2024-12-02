FROM gradle:7.6-jdk17 AS build
WORKDIR /app

# Copiar apenas arquivos necessários para o build
COPY build.gradle.kts settings.gradle.kts gradlew /app/
COPY gradle /app/gradle
RUN chmod +x gradlew

# Rodar um gradle build inicial para cachear dependências
RUN ./gradlew dependencies --no-daemon

# Copiar o restante do código do projeto
COPY . .

# Executar o build da aplicação
RUN ./gradlew bootJar --no-daemon
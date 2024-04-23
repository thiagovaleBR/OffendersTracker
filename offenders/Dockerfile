# Estágio de Construção
FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
RUN ls -la /app/target/

# Estágio de Execução
FROM openjdk:17-alpine
# Instalar pacotes necessários para melhor suporte a terminal interativo
RUN apk update && apk add --no-cache \
    ncurses-terminfo-base \
    ncurses-libs \
    tzdata \
    && rm -rf /var/cache/apk/*

# Copiar o JAR do estágio de build
COPY --from=build /app/target/*.jar /usr/local/lib/run.jar

# Expor a porta que o aplicativo utiliza
EXPOSE 8081

# Configurar o fuso horário
ENV TZ America/Fortaleza

# Especificar o comando de execução, certificando-se de usar um terminal apropriado se necessário
CMD ["java", "-jar", "/usr/local/lib/run.jar"]

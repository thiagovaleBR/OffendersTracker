FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
RUN ls -la /app/target/

FROM openjdk:17-alpine
RUN apk update && apk add --no-cache \
    ncurses-terminfo-base \
    ncurses-libs \
    tzdata \
    && rm -rf /var/cache/apk/*

COPY --from=build /app/target/*.jar /usr/local/lib/run.jar

EXPOSE 8081

ENV TZ America/Fortaleza

CMD ["java", "-jar", "/usr/local/lib/run.jar"]

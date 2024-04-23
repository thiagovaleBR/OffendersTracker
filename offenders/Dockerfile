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

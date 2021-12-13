# BUILDING STAGE
FROM openjdk:8 AS builder

RUN mkdir /src
COPY . /src

WORKDIR /src
RUN ./gradlew clean shadowJar

# RUNNING STAGE
FROM openjdk:8-jre-alpine

RUN adduser -D -g '' app

RUN mkdir -p /app/resources
RUN chown -R app /app
RUN chmod -R 755 /app

USER app

COPY --from=builder /src/build/libs/space.mephi*.jar /app/space.mephi.jar
COPY --from=builder /src/build/resources/ /app/resources/
WORKDIR /app

EXPOSE 8080

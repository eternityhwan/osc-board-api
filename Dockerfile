#FROM openjdk:11.0.11-jre-slim
#ARG JAR_FILE=build/libs/osc-board-api-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:11.0.11-jre-slim
EXPOSE 8088
RUN mkdir /app
COPY ./build/libs/*-SNAPSHOT.jar ./app/application.jar
ENTRYPOINT ["java","-jar","/app/application.jar"]

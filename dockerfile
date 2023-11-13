FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/gestion-station-ski-1.0.jar  station.jar
ENTRYPOINT ["java","-jar","/station.jar"]
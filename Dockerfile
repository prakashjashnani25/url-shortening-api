FROM openjdk:13-jdk-alpine
COPY ./target/*.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","url-shortening-demo-0.0.1-SNAPSHOT.jar"
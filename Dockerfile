FROM openjdk:11-jdk-stretch
ADD target/musixservice-0.0.1-SNAPSHOT.jar  /src/main/musixservice-0.0.1-SNAPSHOT.jar
WORKDIR /src/main
ENTRYPOINT ["java","-jar","musixservice-0.0.1-SNAPSHOT.jar"]


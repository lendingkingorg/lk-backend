FROM openjdk:17
ADD target/lk-backend-0.0.1-SNAPSHOT.jar lk-backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/lk-backend-0.0.1-SNAPSHOT.jar"]

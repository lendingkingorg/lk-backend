FROM openjdk:17
ADD target/ArchusPlatformService-0.0.1-SNAPSHOT.jar ArchusPlatformService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/lk-backend-0.0.1-SNAPSHOT.jar"]
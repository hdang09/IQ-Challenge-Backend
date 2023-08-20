FROM openjdk:17
EXPOSE 8080
ADD target/iq.jar iq.jar
ENTRYPOINT ["java", "-jar", "/iq.jar"]
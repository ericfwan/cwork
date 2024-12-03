FROM openjdk:latest
COPY ./target/cwork-0.1.0.2.jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "cwork-0.1.0.2.jar-with-dependencies.jar"]
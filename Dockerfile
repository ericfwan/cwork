FROM openjdk:latest
COPY ./target/cwork-0.1-alpha-2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "cwork-0.1-alpha-2-jar-with-dependencies.jar"]
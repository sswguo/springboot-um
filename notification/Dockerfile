FROM openjdk:8

COPY ./target/notification-0.0.1-SNAPSHOT.jar  /var/lib/springboot-um/
WORKDIR /var/lib/springboot-um/

EXPOSE 8080
CMD ["java", "-jar", "notification-0.0.1-SNAPSHOT.jar"]


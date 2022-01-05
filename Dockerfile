FROM openjdk:latest
ADD target/spring-boot-docker-mysql.jar spring-boot-docker-mysql.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-boot-docker-mysql.jar"]
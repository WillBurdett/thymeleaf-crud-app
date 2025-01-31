FROM amazoncorretto:17-alpine-jdk
COPY  target/thymeleaf-crud-app.jar thymeleaf-crud-app.jar
ENTRYPOINT ["java","-jar","/thymeleaf-crud-app.jar"]
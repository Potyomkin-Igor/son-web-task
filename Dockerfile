FROM openjdk:11

COPY /target/son-web-task.war /

CMD ["java", "-jar", "/son-web-task.war"]
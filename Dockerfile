FROM openjdk:8
ARG JAR_FILE=target/*jar-with-dependencies.jar
COPY ${JAR_FILE} assesment.jar
ENTRYPOINT ["java","-jar","/assesment.jar"]
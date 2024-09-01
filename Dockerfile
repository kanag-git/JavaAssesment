FROM openjdk:8
ARG JAR_FILE=target/*jar-with-dependencies.jar
COPY ${JAR_FILE} assessment.jar
ENTRYPOINT ["java","-jar","/assessment.jar"]
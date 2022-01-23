FROM openjdk:11
MAINTAINER polcodex.com
COPY target/calendar-0.0.1-SNAPSHOT.jar calendar-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/calendar-0.0.1-SNAPSHOT.jar"]
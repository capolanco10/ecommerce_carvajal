FROM openjdk:11

ADD build/libs /opt/spring-boot

ENV SERVER_HOME /opt/spring-boot

WORKDIR /opt/spring-boot

### Open Ports
EXPOSE 9000

### Start instance
ENTRYPOINT ["java", "-jar", "-Dfile.encoding=UTF-8", "/opt/spring-boot/ecommerce-manager-service-0.0.1-SNAPSHOT.jar"]
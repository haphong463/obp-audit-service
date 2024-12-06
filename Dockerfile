FROM openjdk:17
EXPOSE 9922
ADD target/obp-audit-service.jar obp-audit-service.jar
ENTRYPOINT ["java", "-jar", "/obp-audit-service.jar"]
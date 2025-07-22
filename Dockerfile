FROM eclipse-temurin:21
EXPOSE 2004
ADD target/SBHelloWorld1-0.0.1-SNAPSHOT.jar sbhelloworld1-0.0.1-snapshot.jar
ENTRYPOINT [ "java", "-jar","/sbhelloworld1-0.0.1-snapshot.jar"]
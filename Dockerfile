FROM eclipse-temurin:21
EXPOSE 2004
ADD target/SBHelloWorld1-0.0.1-SNAPSHOT.jar sbhelloworld1-0.0.1-snapshot.jar
ENTRYPOINT [ "java", "-jar","/sbhelloworld1-0.0.1-snapshot.jar"]


# docker build -t my-spring-boot-app .
# docker run -d -p 8080:8080 my-spring-boot-app
# docker tag my-spring-boot-app shahanaaz/my-spring-boot-app:latest
# docker push shahanaaz/my-spring-boot-app:latest
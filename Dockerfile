FROM openjdk:11
COPY ./target/echokube-0.0.1-SNAPSHOT.jar /app.jar
WORKDIR /
# expose needed if not running in a kubernetes pod. 
# EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

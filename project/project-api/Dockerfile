FROM anapsix/alpine-java:8

ADD target/project-api.jar /app.jar


EXPOSE 8080


CMD ["java", "-Xmx500M", "-jar", "app.jar"]

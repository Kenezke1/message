FROM java:8
EXPOSE 8080
ADD /target/message_system-0.0.1-SNAPSHOT.jar message_system-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","message_system-0.0.1-SNAPSHOT.jar"]
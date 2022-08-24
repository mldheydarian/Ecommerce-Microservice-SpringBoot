FROM openjdk:11
COPY ./target/*.jar /home/app/
WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE dev
EXPOSE 9002
ENTRYPOINT ["java","-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}","-jar","order-service-0.0.1.jar"]

#############################
#creat image :sudo docker build . -t  my-userservice-image:0.1
#run image : sudo docker run -d -p 9001:9001 --name my-userservice-continer my-userservice-image:0.1

###################################
#FROM openjdk:8-jdk-alpine
#ARG JAR-File=target/*.jar
#COPY $JAR-File  my-eureka-on-docker.jar
#ENTRYPOINT ["java","-jar","/my-eureka-on-docker.jar"]
#####################################
#FROM openjdk:11
#ARG PROJECT_VERSION=0.1.0
#RUN mkdir -p /home/app
#WORKDIR /home/app
#ENV SPRING_PROFILES_ACTIVE dev
#COPY service-discovery/ .
#ADD service-discovery/target/service-discovery-v${PROJECT_VERSION}.jar service-discovery.jar
#EXPOSE 8761
#ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-jar", "service-discovery.jar"]

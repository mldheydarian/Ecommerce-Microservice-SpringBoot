FROM openjdk:11
COPY ./target/*.jar /home/app/
WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE dev
EXPOSE 9004
ENTRYPOINT ["java","-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}","-jar","payment-service-0.0.1.jar"]

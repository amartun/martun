FROM adoptopenjdk/openjdk11:jdk-11.0.5_10-alpine
ADD . /src
WORKDIR /src
RUN ./gradlew build -DskipTests
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/martun-1.0.0.jar"]
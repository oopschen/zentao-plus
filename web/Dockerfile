FROM openjdk:8-jdk-alpine as builder
ADD ./ /mnt/code
WORKDIR /mnt/code
RUN ./gradlew assemble

FROM openjdk:8-jdk-alpine
COPY --from=builder /mnt/code/build/libs/web.war /mnt/code.war
ENTRYPOINT ["java", "-jar", "/mnt/code.war"]

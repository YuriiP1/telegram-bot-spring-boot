FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=random_modnar_bot
ENV BOT_TOKEN=1702772935:AAGCmyNQuxUspC1g44YwQRv6JeWfQLQX0YQ
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}","-jar","/app.jar"]
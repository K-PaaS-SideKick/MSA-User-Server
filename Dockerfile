# 1단계: Gradle을 사용하여 애플리케이션 빌드
FROM gradle:8.10-jdk17 AS build

# 프로젝트 소스와 Gradle wrapper를 복사
COPY Sidekick /home/gradle/project
WORKDIR /home/gradle/project

# Gradle wrapper를 사용하여 종속성 다운로드 및 빌드
RUN gradle build -x test

# 2단계: 빌드된 애플리케이션을 실행할 런타임 이미지 생성
FROM bellsoft/liberica-openjdk-alpine:17

# 빌드 단계에서 생성된 JAR 파일을 복사
COPY --from=build /home/gradle/project/build/libs/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# 애플리케이션이 사용하는 포트 설정
EXPOSE 65534
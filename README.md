Darts application

- 프로젝트 빌드  
``
./gradlew build 
``
- 테스트 코드만 빌드  
``
./gradlew test
``
- 테스트 코드제외하고 빌드    
``
./gradlew -x test build
``
- 캐시의 영향이 없도록 빌드  
``
./gradlew clean build
``

# 수동 빌드
- gradle wrapper를 사용하여 build  
`` 
./gradlew build
``
- build/libs/jar파일 수동 실행  
``
java -jar darts-0.0.1-SNAPSHOT.jar
``
- build/libs/jar파일 profile = dev로 실행  
``
java -jar darts-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
``
# Docker 배포
- docker 빌드 명령어  
``
docker build --build-arg JAR_FILE=build/libs/darts-0.0.1-SNAPSHOT.jar -t myorg/myapp .
``
- docker 실행 명령어  
``
docker run -p 8080:8080 myorg/myapp
``
# TODO
  - 로그인, 로그아웃 Vue로 UI구성해서 제대로 테스트 하기 
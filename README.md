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

# 1강
    - 수동으로 build하고 실행해보기
  - gradle wrapper를 사용하여 build  
    ``
    ./gradlew build
    ``
  - build/libs/jar파일 수동 실행  
    ``
    java -jar darts-0.0.1-SNAPSHOT.jar
    ``
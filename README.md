# eatgo-springboot

## Install dependencies for web 
    bash -c "cd eatgo-admin-web && npm install"
    bash -c "cd eatgo-customer-web && npm install"
    bash -c "cd eatgo-restaurant-web && npm install"
    
## Build Jar
+ window일 경우
```Java
    gradlew bootJar
```    
+ mac일 경우
```Java
    ./graldew bootJar
```    
## Test All

    SPRING_PROFILES_ACTIVE=test ./gradlew cleanTest test
## run with docker
    #.env파일은 필요에따라 수정가능
    #도커 컨테이너 모두 실행
    docker-compose up
    
    #컨테이너가 실행되고있는지 확인     
    docker ps -a
    #컨테이너 접속
    docker exec -it <컨테이너이름 or ID> bash
    #sql 접속
    mysql -u root -p
    #DB 확인
    show databases;
    #DB 접속
    use db이름;
    

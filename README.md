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


<hr>

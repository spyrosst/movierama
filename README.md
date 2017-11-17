# Movierama Demo Application

Prerequisites Java 8 and Docker Engine

make sure to check your shell with: "docker-machine env default"

movierama\src\main\containers>docker-compose up  (This will load mysql)  

movierama>mvn clean install -DskipTests=true  (This will load test data in addition)

movierama>mvn spring-boot:run -Drun.arguments="--spring.jpa.properties.hibernate.hbm2ddl.auto=none"

http://localhost:9080/movierama/health

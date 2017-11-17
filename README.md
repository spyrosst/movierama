# Movierama Demo Application

Prerequisites Java 8 and Docker Engine

make sure to check your shell with: "docker-machine env default"

movierama\src\main\containers>docker-compose up  (This will load mysql)  

Make sure that the database is up http://192.168.99.100:8085/ (login credentials at docker-compose.xml)

movierama>mvn clean install  (This will load test data in addition)

movierama>mvn spring-boot:run -Drun.arguments="--spring.jpa.properties.hibernate.hbm2ddl.auto=none"

http://localhost:9080/movierama/health
http://localhost:9080/movierama

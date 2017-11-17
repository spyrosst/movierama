# Movierama Demo Application

Prerequisites Java 8, Maven and Docker Engine

make sure to check your shell with: "docker-machine env default"

movierama\src\main\containers>(sudo) docker-compose up (or run)  (This will load mysql)  

Make sure that the database is up http://localhost:8085/ (login credentials at docker-compose.xml)

(if you have problem on windows on accesing the database from localhost change application.properties to point to 192.168.99.100)

movierama>mvn clean install  (This will load test data in addition)

movierama>mvn spring-boot:run -Drun.arguments="--spring.jpa.properties.hibernate.hbm2ddl.auto=none"

http://localhost:9080/movierama/health

http://localhost:9080/movierama

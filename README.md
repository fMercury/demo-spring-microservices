# demo-spring-microservices

mvn clean install

cd eureka-discovery-service
mvn spring-boot:run

cd ../gateway-service
mvn spring-boot:run

cd ../student-service
mvn spring-boot:run

cd ../student-service
mvn spring-boot:run -DPORT=2223

cd ../classroom-service
mvn spring-boot:run

cd ../zipkin-service
mvn spring-boot:run

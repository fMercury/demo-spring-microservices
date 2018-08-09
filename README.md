# demo-spring-microservices

mvn clean install

#run eureka-discovery-service (default port:8761)
cd eureka-discovery-service
mvn spring-boot:run

#run gateway-service (default port:1111)
cd ../gateway-service
mvn spring-boot:run

#run student-service (default port:2222)
cd ../student-service
mvn spring-boot:run

#run student-service (new instance on port 2223)
cd ../student-service
mvn spring-boot:run -DPORT=2223

#run classroom-service (default port:3333)
cd ../classroom-service
mvn spring-boot:run

#run zipkin-service (default port:9411)
cd ../zipkin-service
mvn spring-boot:run

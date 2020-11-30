# Kafka Demo

## Start Kafka

`docker-compose up`

## Create Topics

`bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test`

## Start Producer Application

`cd quarkus-kafka-producer`  
`./mvnw clean quarkus:dev`

## Start Consumer Application

`cd quarkus-kafka-consumer`  
`./mvnw clean quarkus:dev`
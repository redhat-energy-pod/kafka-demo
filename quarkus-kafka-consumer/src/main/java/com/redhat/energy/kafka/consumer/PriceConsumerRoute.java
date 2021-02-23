package com.redhat.energy.kafka.consumer;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;

//@ApplicationScoped
public class PriceConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:prices?brokers=localhost:9092")
            .log("Message received from Kafka : ${body}")
            .log("    on the topic ${headers[kafka.TOPIC]}")
            .log("    on the partition ${headers[kafka.PARTITION]}")
            .log("    with the offset ${headers[kafka.OFFSET]}")
            .log("    with the key ${headers[kafka.KEY]}");
    }
    
}

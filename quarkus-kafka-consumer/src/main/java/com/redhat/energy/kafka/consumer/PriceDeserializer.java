package com.redhat.energy.kafka.consumer;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class PriceDeserializer extends JsonbDeserializer<Price> {

    public PriceDeserializer() {
        super(Price.class);
    }
    
}

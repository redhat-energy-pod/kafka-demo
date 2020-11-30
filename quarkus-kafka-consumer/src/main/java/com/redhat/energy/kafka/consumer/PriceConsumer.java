package com.redhat.energy.kafka.consumer;

import java.util.concurrent.CompletionStage;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import io.smallrye.reactive.messaging.kafka.KafkaRecord;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class PriceConsumer {

    @Incoming("prices")
    public CompletionStage<Void> consume(KafkaRecord<String, Price> record) {
        log.info("Key: {}, Value: {}, Partition: {}", record.getKey(), record.getPayload(), record.getPartition());
        return record.ack();
    }
    
}

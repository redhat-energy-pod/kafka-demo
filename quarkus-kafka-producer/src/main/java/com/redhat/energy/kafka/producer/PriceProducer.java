package com.redhat.energy.kafka.producer;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.kafka.Record;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class PriceProducer {

    private List<String> symbols = Arrays.asList("IBM", "TSLA", "AAPL", "JNJ", "KO", "BA");
    private int duration = 3000;
    private Random random = new Random();

    @Outgoing("prices")                        
    public Multi<Record<String, Price>> generate() {                  
        return Multi.createFrom().ticks().every(Duration.ofMillis(duration))
                .onOverflow().drop()
                .map(tick -> {
                    Price price = generateRandomPrice();
                    log.info("Generating: {}", price);
                    return Record.of(price.getSymbol(), price);
                });
    }

    private Price generateRandomPrice() {
        String symbol = symbols.get(random.nextInt(symbols.size()));
        return new Price(symbol, BigDecimal.valueOf(random.nextInt(100)));
    }
    
}

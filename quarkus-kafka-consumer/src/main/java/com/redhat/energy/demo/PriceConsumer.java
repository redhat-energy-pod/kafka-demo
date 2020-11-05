package com.redhat.energy.demo;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class PriceConsumer {

    @Incoming("generated-price")
    public void generate(Integer integer) {
        log.info("{}", integer);
    }

}

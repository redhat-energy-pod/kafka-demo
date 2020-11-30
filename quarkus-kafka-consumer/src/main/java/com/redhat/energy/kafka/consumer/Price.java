package com.redhat.energy.kafka.consumer;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    
    private String symbol;
    private BigDecimal value;

}

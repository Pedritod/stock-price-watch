package com.example.stockwatch;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class StockPriceUpdate {
    private BigDecimal price;
    private Instant time;
    private String symbol;
}

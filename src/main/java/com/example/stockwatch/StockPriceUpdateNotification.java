package com.example.stockwatch;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceUpdateNotification {
    private Long stockWatchId;
    private String symbol;
    private BigDecimal price;
    private Instant time;
}

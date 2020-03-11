package com.example.stockwatch;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockPriceWatchService {

    private final  StockPriceUpdateNotificationOutboundAdapter stockPriceUpdateNotificationOutboundAdapter;

    public void sendStockPriceUpdateNotification(StockWatch stockWatch, StockPriceUpdate stockPriceUpdate) {
        StockPriceUpdateNotification updateNotification = StockPriceUpdateNotification.builder()
                .price(stockPriceUpdate.getPrice())
                .stockWatchId(Long.MAX_VALUE)
                .time(stockPriceUpdate.getTime())
                .symbol(stockPriceUpdate.getSymbol())
                .build();
        stockPriceUpdateNotificationOutboundAdapter.send(updateNotification);
    }
}

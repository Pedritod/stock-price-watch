package com.example.stockwatch;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import com.example.stockwatch.StockPriceUpdateNotificationOutboundAdapter.StockPriceUpdateNotificationBinder;

@Component
@RequiredArgsConstructor
@EnableBinding(StockPriceUpdateNotificationBinder.class)
public class StockPriceUpdateNotificationOutboundAdapter {

    public interface StockPriceUpdateNotificationBinder {
        String OUTPUT = "stockPriceUpdateNotification";

        @Output(OUTPUT)
        MessageChannel stockpriceUpdateNotification();
    }

    private final StockPriceUpdateNotificationBinder binder;

    public void send(StockPriceUpdateNotification priceUpdateAlarm) {
        Message<?> message = MessageBuilder.withPayload(priceUpdateAlarm).setHeader("alarmId", 1L).build(); // priceUpdateAlarm.getStockWatchId()).build();
        binder.stockpriceUpdateNotification().send(message);
    }
}

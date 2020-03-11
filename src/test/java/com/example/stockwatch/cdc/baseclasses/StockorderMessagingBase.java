package com.example.stockwatch.cdc.baseclasses;

import com.example.stockwatch.StockPriceUpdate;
import com.example.stockwatch.StockPriceWatchController;
import com.example.stockwatch.StockPriceWatchService;
import com.example.stockwatch.StockWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;

import java.math.BigDecimal;
import java.time.Instant;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMessageVerifier
public class StockorderMessagingBase {

    @Autowired
    private StockPriceWatchService stockPriceWatchService;

    public void stockPriceBelowLimit() {
        StockWatch stockWatch = new StockWatch();
        stockWatch.setId(1L);
        StockPriceUpdate stockPriceUpdate = new StockPriceUpdate();
        stockPriceUpdate.setPrice(BigDecimal.valueOf(120.0));
        stockPriceUpdate.setSymbol("AAPL");
        stockPriceUpdate.setTime(Instant.now());
        stockPriceWatchService.sendStockPriceUpdateNotification(stockWatch, stockPriceUpdate);
    }
}

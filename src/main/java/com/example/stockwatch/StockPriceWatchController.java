package com.example.stockwatch;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockPriceWatchController {

    @PostMapping(path = "stockwatch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StockWatchResponse createStockWatch(@RequestBody StockWatch stockWatch) {
        return new StockWatchResponse(1);
    }
}

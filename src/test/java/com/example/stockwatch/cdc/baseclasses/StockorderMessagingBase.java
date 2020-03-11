package com.example.stockwatch.cdc.baseclasses;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMessageVerifier
public class StockorderMessagingBase {

    public void stockPriceBelowLimit() {

    }
}

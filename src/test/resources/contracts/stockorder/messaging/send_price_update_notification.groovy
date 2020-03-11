package contracts.stockorder.messaging
import org.springframework.cloud.contract.spec.Contract

Contract.make {
	label "Stock price is below given limit"
	input {
		triggeredBy("stockPriceBelowLimit()")
	}
	outputMessage {
		sentTo("stockPriceUpdateNotification")
		body(
				symbol: "AAPL",
				price: $(producer(anyNumber()), consumer(127.89)),
				time: $(producer(anyIso8601WithOffset()), consumer("2018-11-30T18:35:24.00Z")),
				stockWatchId: $(producer(regex(number().asLong())), consumer(12550271524396))
		)
		headers {
			header("alarmId", 1L)
		}
	}
}

package contracts.stockorder.messaging;
import org.springframework.cloud.contract.spec.Contract;

Contract.make {
	label "Stock price is below given limit"
	input {
		triggeredBy("stockPriceBelowLimit()")
	}
	outputMessage {
		sentTo("stockPriceUpdateNotification")
		body('''
			{
				"symbol": "AAPL",
				"price": "137.0",
				"timestamp": $(
					consumer("2018-11-30T18:35:24.00Z"), 
					producer(execute(Instant.parse($it))))
				)
			}
		''')
		headers {
			header("alarmId", 1)
		}
	}
}

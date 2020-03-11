package contracts.stockorder.rest
import org.springframework.cloud.contract.spec.Contract;

return [
Contract.make {
    description("Contract for creating a new stock watch")
    name("create_new_stock_watch_succeeds")
    request {
        method POST()
        url "/stockwatch"
        body('''
            {"symbol": "AAPL", "limit": 0.01}    
        ''')
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
        body('''{"stockWatchId": 1}''')
        headers {
            contentType(applicationJson())
        }
    }
},

Contract.make {
    description("Contract for creating a new stock watch with missing symbol")
    name("create_new_stock_watch_fails_because_of_missing_symbol")
    request {
        method POST()
        url "/stockwatch"
        body('''
            {"limit": 139.23}    
        ''')
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status BAD_REQUEST()
        body("Symbol must be given.")
        headers {
            contentType(textPlain())
        }
    }
},

Contract.make {
    description("Contract for creating a new stock watch with limit below 0.01")
    name("create_new_stock_watch_fails_because_of_limit_below_min")
    request {
        method POST()
        url "/stockwatch"
        body('''
            {"symbol": "AAPL", "limit":"0.0"}    
        ''')
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status BAD_REQUEST()
        body("limit must be > 0.")
        headers {
            contentType(textPlain())
        }
    }
}
]




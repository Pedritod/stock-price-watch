package contracts

org.springframework.cloud.contract.spec.Contract.make {
    description("Contract for creating a new stock watch")
    request {
        method POST()
        url "/stockwatch"
        body('''
            {"symbol": "AAPL", "limit": 139.23}    
        ''')
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body('''{"stockWatchId": 1}''')
        headers {
            contentType(applicationJson())
        }
    }
}

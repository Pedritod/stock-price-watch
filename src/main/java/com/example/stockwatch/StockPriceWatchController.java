package com.example.stockwatch;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class StockPriceWatchController {

    @PostMapping(path = "stockwatch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StockWatchResponse createStockWatch(@Valid @RequestBody StockWatch stockWatch) {
        return new StockWatchResponse(1);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return e.getBindingResult().getAllErrors().stream()
                .map(i -> i.getDefaultMessage())
                .collect(Collectors.joining(", "));
    }
}

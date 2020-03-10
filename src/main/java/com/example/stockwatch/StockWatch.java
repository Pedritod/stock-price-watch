package com.example.stockwatch;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class StockWatch {
    @NotEmpty
    private String symbol;
}

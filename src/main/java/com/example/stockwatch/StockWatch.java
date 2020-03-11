package com.example.stockwatch;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class StockWatch {
    private long id;

    @NotEmpty(message = "Symbol must be given.")
    private String symbol;

    @DecimalMin(value = "0.01", message = "limit must be > 0.")
    private BigDecimal limit;
}

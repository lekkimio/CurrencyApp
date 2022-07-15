package com.example.currency.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Currency {

    private String start;
    private String end;
    private String sourceCurr;
    private String additCurrencies;

    public Currency(String sourceCurr, String start, String end, String additCurrencies) {
        this.sourceCurr = sourceCurr;
        this.start = start;
        this.end = end;
        this.additCurrencies = additCurrencies;
    }

    public Currency(String sourceCurr) {
        this.sourceCurr = sourceCurr;
    }
}

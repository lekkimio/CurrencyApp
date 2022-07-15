package com.example.currency.model;

import lombok.Data;

import java.util.List;

@Data
public class CurrencyResponse extends Currency{
    private Boolean success;
    private String timestamp;
    private Boolean timeframe;
    private String start_date;
    private String end_date;
    private String source;
    private List<String> quotes;

    public CurrencyResponse() {

    }
    public CurrencyResponse(Boolean success, String timestamp, String source, List<String> quotes) {
        this.success = success;
        this.timestamp = timestamp;
        this.source = source;
        this.quotes = quotes;
    }

    public CurrencyResponse(Boolean success, Boolean timeframe, String start_date, String end_date, String source, List<String> quotes) {
        this.success = success;
        this.timeframe = timeframe;
        this.start_date = start_date;
        this.end_date = end_date;
        this.source = source;
        this.quotes = quotes;
    }
}

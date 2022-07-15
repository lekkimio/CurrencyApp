package com.example.currency.service;

import com.example.currency.model.Currency;
import com.example.currency.model.CurrencyResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class CurrencyService {

    @Value("${api.key}")
    private String apiKey;

    public Response createLiveResponse(Currency currency) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        if(currency.getSourceCurr() == null)
            currency.setSourceCurr("UAH");

        Request request;
        if (currency.getAdditCurrencies() == null) {
            request = new Request.Builder()
                    .url("https://api.apilayer.com/currency_data/live?" +
                            "source=" + currency.getSourceCurr()
                    )
                    .addHeader("apikey", apiKey)
                    .build();
        }else {
            request = new Request.Builder()
                    .url("https://api.apilayer.com/currency_data/live?" +
                            "source=" + currency.getSourceCurr() + "&" +
                            "currencies=" + currency.getAdditCurrencies())
                    .addHeader("apikey", apiKey)
                     .build();
        }

        return client.newCall(request).execute();
    }

    public Response createTimeframeResponse(Currency currency) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();


        if(currency.getSourceCurr() == null)
            currency.setSourceCurr("UAH");

        Request request;
        if (currency.getAdditCurrencies() == null) {
            request = new Request.Builder()
                    .url("https://api.apilayer.com/currency_data/timeframe?" +
                            "start_date=" + currency.getStart() + "&" +
                            "end_date=" + currency.getEnd() + "&" +
                            "source=" + currency.getSourceCurr() + "&" +
                            "apikey=" + apiKey)
                    /*.addHeader("apikey", apiKey)*/
                    .build();
        }else {
            request = new Request.Builder()
                    .url("https://api.apilayer.com/currency_data/timeframe?" +
                            "start_date=" + currency.getStart() + "&" +
                            "end_date=" + currency.getEnd() + "&" +
                            "source=" + currency.getSourceCurr() + "&" +
                            "currencies=" + currency.getAdditCurrencies()+ "&" +
                            "apikey=" + apiKey)
                    /*.addHeader("apikey", apiKey)*/
                    .build();
        }

        return client.newCall(request).execute();
    }

    public CurrencyResponse convertResponse(Response response) throws IOException {

        JSONObject jsonResponse = new JSONObject(response.body().string());

        CurrencyResponse currencyResponse;


        if (jsonResponse.has("timeframe")) {
            currencyResponse = new CurrencyResponse(
                    jsonResponse.getBoolean("success"),
                    jsonResponse.getBoolean("timeframe"),
                    jsonResponse.getString("start_date"),
                    jsonResponse.getString("end_date"),
                    jsonResponse.getString("source"),
                    Arrays.stream(jsonResponse.getJSONObject("quotes").toString()
                                    .replaceAll("[{\"]", "").split("},"))
                            .map(s -> s.replaceAll("}", "")).collect(Collectors.toList())
            );
        }
        else {
            currencyResponse = new CurrencyResponse(
                    jsonResponse.getBoolean("success"),
                    jsonResponse.getNumber("timestamp").toString(),
                    jsonResponse.getString("source"),
                    Arrays.stream(jsonResponse.getJSONObject("quotes").toString()
                                    .replaceAll("[{\"]", "").split("},"))
                            .map(s -> s.replaceAll("}", "")).collect(Collectors.toList())
            );
        }
        return  currencyResponse;
    }
}

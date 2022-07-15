package com.example.currency.service;

import com.example.currency.model.Currency;
import com.example.currency.model.CurrencyResponse;

import java.io.IOException;
import java.time.LocalDate;

import okhttp3.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

@ContextConfiguration(classes = {CurrencyService.class})
@ExtendWith(SpringExtension.class)
class CurrencyServiceTest {
    @Autowired
    private CurrencyService currencyService;

    /**
     * Method under test: {@link CurrencyService#createLiveResponse(Currency)}
     */
    @Test
    void testCreateLiveResponse() throws IOException {
        // TODO: Complete this test.

        currencyService.createLiveResponse(new Currency("UAH", null, null, null));
    }

    /**
     * Method under test: {@link CurrencyService#createLiveResponse(Currency)}
     */
    @Test
    void testCreateLiveResponse2() throws IOException {
        // TODO: Complete this test.

        currencyService.createLiveResponse(new Currency("UAH", null, null, "USD,EUR,JPY,GBP"));
    }

    /**
     * Method under test: {@link CurrencyService#createLiveResponse(Currency)}
     */
    @Test
    void testCreateLiveResponse3() throws IOException {
        // TODO: Complete this test.

        currencyService.createLiveResponse(new Currency(null));
    }

    /**
     * Method under test: {@link CurrencyService#createTimeframeResponse(Currency)}
     */
    @Test
    void testCreateTimeframeResponse() throws IOException {
        // TODO: Complete this test.
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusDays(10);

        System.out.println(
                currencyService
                        .createTimeframeResponse(
                                new Currency("UAH", start.toString(), end.toString(), "USD,EUR,JPY,GBP")));
    }

    /**
     * Method under test: {@link CurrencyService#createTimeframeResponse(Currency)}
     */
    @Test
    void testCreateTimeframeResponse2() throws IOException {
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusDays(10);

        currencyService.createTimeframeResponse(new Currency(null, start.toString(), end.toString(), "USD,EUR,JPY,GBP"));
    }

    /**
     * Method under test: {@link CurrencyService#createTimeframeResponse(Currency)}
     */
    @Test
    void testCreateTimeframeResponse3() throws IOException {
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusDays(10);

        currencyService.createTimeframeResponse(new Currency("UAH", start.toString(), end.toString(), null));
    }

    /**
     * Method under test: {@link CurrencyService#createTimeframeResponse(Currency)}
     */
    @Test
    void testCreateTimeframeResponse4() throws IOException {
        LocalDate end = LocalDate.now();

        currencyService.createTimeframeResponse(new Currency("UAH", null, end.toString(), "USD,EUR,JPY,GBP"));
    }

    /**
     * Method under test: {@link CurrencyService#createTimeframeResponse(Currency)}
     */
    @Test
    void testCreateTimeframeResponse5() throws IOException {
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusDays(10);

        currencyService.createTimeframeResponse(new Currency("UAH", start.toString(), null, "USD,EUR,JPY,GBP"));
    }

    /**
     * Method under test: {@link CurrencyService#createTimeframeResponse(Currency)}
     */
    @Test
    void testCreateTimeframeResponse6() throws IOException {

        currencyService.createTimeframeResponse(new Currency(null));
    }


}


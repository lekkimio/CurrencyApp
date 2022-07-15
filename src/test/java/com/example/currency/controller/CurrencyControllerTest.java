package com.example.currency.controller;

import com.example.currency.model.Currency;
import com.example.currency.service.CurrencyService;

import java.io.IOException;
import java.time.LocalDate;

import okhttp3.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.*;

@ContextConfiguration(classes = {CurrencyController.class})
@ExtendWith(SpringExtension.class)
class CurrencyControllerTest {


    @Autowired
    private CurrencyController currencyController;

    @MockBean
    private CurrencyService currencyService;


    /**
     * Method under test: {@link CurrencyController#getLive(Model)}
     */
    @Test
    void testGetLive() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/currency/live");
        MockMvcBuilders.standaloneSetup(currencyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("liveCurrency"))
                .andExpect(MockMvcResultMatchers.view().name("live_form.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("live_form.html"));
    }

    /**
     * Method under test: {@link CurrencyController#getLive(Model)}
     */
    @Test
    void testGetLive2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/currency/live", "Uri Vars");
        MockMvcBuilders.standaloneSetup(currencyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("liveCurrency"))
                .andExpect(MockMvcResultMatchers.view().name("live_form.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("live_form.html"));
    }

    /**
     * Method under test: {@link CurrencyController#getTimeFrameForm(Model)}
     */
    @Test
    void testGetTimeFrameForm() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/currency/timeframe");
        MockMvcBuilders.standaloneSetup(currencyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("timeCurrency"))
                .andExpect(MockMvcResultMatchers.view().name("timeframe_form.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("timeframe_form.html"));
    }

    /**
     * Method under test: {@link CurrencyController#getTimeFrameForm(Model)}
     */
    @Test
    void testGetTimeFrameForm2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/currency/timeframe");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(currencyController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("timeCurrency"))
                .andExpect(MockMvcResultMatchers.view().name("timeframe_form.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("timeframe_form.html"));
    }
}


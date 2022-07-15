package com.example.currency.controller;

import com.example.currency.model.Currency;
import com.example.currency.service.CurrencyService;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }


    @GetMapping("/timeframe")
    public ModelAndView getTimeFrameForm(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("timeframe_form.html");

        model.addAttribute("timeCurrency", new Currency());
        return modelAndView;
    }

    @GetMapping("/live")
    public ModelAndView getLive(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("live_form.html");

        model.addAttribute("liveCurrency", new Currency());
        return modelAndView;
    }

    @PostMapping("/process_timeframe")
    public ModelAndView processTimeframe(Currency currency, Model model) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("timeframe.html");

        Response response = currencyService.createTimeframeResponse(currency) ;
        model.addAttribute("currencyTime", currencyService.convertResponse(response));
        return modelAndView;
    }

    @PostMapping("/process_live")
    public ModelAndView processLive(Currency currency, Model model) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("live.html");

        Response response = currencyService.createLiveResponse(currency);
        model.addAttribute("currencyLive", currencyService.convertResponse(response));
        return modelAndView;
    }
}

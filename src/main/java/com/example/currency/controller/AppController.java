package com.example.currency.controller;

import com.example.currency.model.User;
import com.example.currency.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AppController {

    private final UserService userService;

    public AppController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/home")
    public ModelAndView getHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home.html");
        return modelAndView;
    }


    @GetMapping("/signup")
    public ModelAndView getSignUpForm(Model model){
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("user", new User());
        modelAndView.setViewName("signup_form.html");
        return modelAndView;
    }

    @PostMapping("/process_register")
    public ModelAndView processRegistration(User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("currency.html");
        userService.saveUser(user);
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login.html");
        return modelAndView;
    }


    @GetMapping("/logout")
    public ModelAndView getLogoutPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logout.html");
        return modelAndView;
    }

    @GetMapping("/currency")
    public ModelAndView getCurrencyPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("currency.html");
        return modelAndView;
    }


}

package com.example.currency.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.example.currency.model.User;
import com.example.currency.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

@ContextConfiguration(classes = {AppController.class})
@ExtendWith(SpringExtension.class)
class AppControllerTest {
    @Autowired
    private AppController appController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link AppController#getCurrencyPage()}
     */
    @Test
    void testGetCurrencyPage() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/currency");
        MockMvcBuilders.standaloneSetup(appController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("currency.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("currency.html"));
    }

    /**
     * Method under test: {@link AppController#getCurrencyPage()}
     */
    @Test
    void testGetCurrencyPage2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/currency", "Uri Vars");
        MockMvcBuilders.standaloneSetup(appController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("currency.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("currency.html"));
    }

    /**
     * Method under test: {@link AppController#getHomePage()}
     */
    @Test
    void testGetHomePage() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/home");
        MockMvcBuilders.standaloneSetup(appController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("home.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("home.html"));
    }

    /**
     * Method under test: {@link AppController#getHomePage()}
     */
    @Test
    void testGetHomePage2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/home");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(appController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("home.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("home.html"));
    }

    /**
     * Method under test: {@link AppController#getLoginPage()}
     */
    @Test
    void testGetLoginPage() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/login");
        MockMvcBuilders.standaloneSetup(appController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("login.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("login.html"));
    }

    /**
     * Method under test: {@link AppController#getLoginPage()}
     */
    @Test
    void testGetLoginPage2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/login");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(appController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("login.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("login.html"));
    }

    /**
     * Method under test: {@link AppController#getLogoutPage()}
     */
    @Test
    void testGetLogoutPage() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/logout");
        MockMvcBuilders.standaloneSetup(appController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("logout.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("logout.html"));
    }

    /**
     * Method under test: {@link AppController#getLogoutPage()}
     */
    @Test
    void testGetLogoutPage2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/logout");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(appController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("logout.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("logout.html"));
    }

    /**
     * Method under test: {@link AppController#getSignUpForm(Model)}
     */
    @Test
    void testGetSignUpForm() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/signup");
        MockMvcBuilders.standaloneSetup(appController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.view().name("signup_form.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("signup_form.html"));
    }

    /**
     * Method under test: {@link AppController#getSignUpForm(Model)}
     */
    @Test
    void testGetSignUpForm2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/signup");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(appController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.view().name("signup_form.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("signup_form.html"));
    }

    /**
     * Method under test: {@link AppController#processRegistration(User)}
     */
    @Test
    void testProcessRegistration() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        when(userService.saveUser((User) any())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/process_register");
        MockMvcBuilders.standaloneSetup(appController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.view().name("currency.html"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("currency.html"));
    }
}


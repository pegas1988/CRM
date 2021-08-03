package com.hillel.crm.config.controller;

import com.hillel.crm.config.entity.Button;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/loginMain")
public class LoginController {

    private String createButton(Button button, String buttonName) {
        button.setButtonForNavbar(buttonName);
        return button.getButtonForNavbar();
    }

    @GetMapping(value = "/login")
    public String getSomeString2() {
        return "login.jsp";
    }
}
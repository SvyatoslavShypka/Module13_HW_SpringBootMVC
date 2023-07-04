package com.goit.module13_hw_springboot.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.server.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RequestMapping("/")
@Controller
public class TestControler {

    @GetMapping("/test")
    public ModelAndView test() {

        return new ModelAndView("test");
    }

}

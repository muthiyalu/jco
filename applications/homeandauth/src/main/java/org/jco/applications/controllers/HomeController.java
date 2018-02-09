package org.jco.applications.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@Controller
public class HomeController {


    @RequestMapping(value = "/", method = GET)
    public String  landingpage(){

        return "landing" ;

    }

    @RequestMapping(value = "/auth/login", method = GET)
    public String  login(){

        return "login" ;


    }



}

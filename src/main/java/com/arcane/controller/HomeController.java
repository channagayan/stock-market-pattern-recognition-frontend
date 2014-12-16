package com.arcane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by DELL on 11/23/2014.
 */
@Controller
@RequestMapping("/arcane")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printWelcome(){
        return new ModelAndView("arcane");
    }

}
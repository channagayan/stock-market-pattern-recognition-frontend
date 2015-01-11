package com.arcane.controller;

import com.arcane.dao.Impl.PatternDaoImpl;
import com.arcane.dao.Impl.UserDaoImpl;
import com.arcane.dao.PatternDao;
import com.arcane.dao.UserDao;
import com.arcane.model.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 11/23/2014.
 */
@Controller
@RequestMapping("/arcane")
public class HomeController {


    @Autowired
    private PatternDao patternDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printWelcome(ModelMap model){
        ModelAndView mav = new ModelAndView("arcane") ;
       List<Pattern> patternList=patternDao.patternList();
        mav.addObject("patterns", patternList);
        System.out.println(".........................calling db controller..................");
        return mav;
    }
    @RequestMapping(value = "/patternList", method = RequestMethod.GET)
    public void getPatternList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("list controller called..............................");
        response.getWriter().println( "bla bla bla");
    }


}
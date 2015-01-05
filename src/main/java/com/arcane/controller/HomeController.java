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
        //List<String> list = getList();
        mav.addObject("patterns", patternList);
        //mav.addObject("channa", "gayan");
        return mav;
    }

    private List<String> getList() {

        List<String> list = new ArrayList<String>();
        list.add("List A");
        list.add("List B");
        list.add("List C");
        list.add("List D");
        list.add("List 1");
        list.add("List 2");
        list.add("List 3");

        return list;

    }

}
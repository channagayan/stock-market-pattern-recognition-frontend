/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arcane.controller;

import com.arcane.dao.Impl.PatternDaoImpl;
import com.arcane.dao.Impl.UserDaoImpl;
import com.arcane.dao.PatternDao;
import com.arcane.dao.UserDao;
import com.arcane.model.*;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Home Controller
 */
@Controller
@RequestMapping("/arcane")
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private PatternDao patternDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printWelcome(ModelMap model){
        //return dashboard with pattern list
        ModelAndView mav = new ModelAndView("arcane") ;
        List<Pattern> patternList=patternDao.getAllPatternList();
        mav.addObject("patterns", patternList);
        LOG.info("Calling db controller.");
        return mav;
    }
    @RequestMapping(value = "/patternTypeList",method = RequestMethod.GET)
    public ModelAndView printPatternList(ModelMap model,@RequestParam("patternName") String patternName){
        //return available pattern list
        ModelAndView mav = new ModelAndView("pattern") ;
        List<Pattern> patternList=patternDao.getAllPatternList(patternName);
        mav.addObject("patterns", patternList);
        LOG.info("Calling patternList controller.."+patternName);
        return mav;
    }
    @RequestMapping(value = "/patternList", method = RequestMethod.GET)
    public void getPatternList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOG.info("list controller called.");
        response.getWriter().println( "test");
    }

    @RequestMapping(value = "/patternData", method = RequestMethod.GET)
    @ResponseBody
    public List<Double> getPatternData(HttpServletRequest request, HttpServletResponse response,@RequestParam("patternId") String patternId,
                                   @RequestParam("patternName") String patternName) throws IOException {
        //return selected pattern data
        LOG.info("Pattern Min Max data retrieving");
        List<Double> data=new ArrayList<Double>();
        switch (patternName){
            case "tripplebottom":
                TrippleBottom trippleBottom=patternDao.getTrippleBottom(patternId);
                data.add(trippleBottom.getFirstMinPrice());
                data.add(trippleBottom.getFirstMaxPrice());
                data.add(trippleBottom.getSecondMinPrice());
                data.add(trippleBottom.getSecondMaxPrice());
                data.add(trippleBottom.getThirdMinPrice());
                data.add(trippleBottom.getBreakPointPrice());

                break;
            case "doubletop":
                Doubletop doubletop=patternDao.getDoubletop(patternId);
                data.add(doubletop.getFirstMaxPrice());
                data.add(doubletop.getFirstMinPrice());
                data.add(doubletop.getSecondMaxPrice());
                data.add(doubletop.getBreakPointPrice());
                break;
            case "doublebottom":
                DoubleBottom doublebottom=patternDao.getDoubleBottom(patternId);
                data.add(doublebottom.getFirstMinPrice());
                data.add(doublebottom.getFirstMaxPrice());
                data.add(doublebottom.getSecondMinPrice());
                data.add(doublebottom.getBreakPointPrice());
                break;
            case "trippletop":
                TrippleTop trippletop=patternDao.getTrippleTop(patternId);
                data.add(trippletop.getFirstMaxPrice());
                data.add(trippletop.getFirstMinPrice());
                data.add(trippletop.getSecondMaxPrice());
                data.add(trippletop.getSecondMinPrice());
                data.add(trippletop.getThirdMaxPrice());
                data.add(trippletop.getBreakPointPrice());
                break;
            case "headnshoulder":
                HeadnShoulder headnshoulder=patternDao.getHeadnShoulder(patternId);
                data.add(headnshoulder.getFirstMaxPrice());
                data.add(headnshoulder.getFirstMinPrice());
                data.add(headnshoulder.getSecondMaxPrice());
                data.add(headnshoulder.getSecondMinPrice());
                data.add(headnshoulder.getThirdMaxPrice());
                data.add(headnshoulder.getBreakPointPrice());
                break;
            case "headnshoulderbottom":
                HeadnShoulderBottom headnshoulderbottom=patternDao.getHeadnShoulderBottom(patternId);
                data.add(headnshoulderbottom.getFirstMinPrice());
                data.add(headnshoulderbottom.getFirstMaxPrice());
                data.add(headnshoulderbottom.getSecondMinPrice());
                data.add(headnshoulderbottom.getSecondMaxPrice());
                data.add(headnshoulderbottom.getThirdMinPrice());
                data.add(headnshoulderbottom.getBreakPointPrice());
                break;
            default:LOG.info("no pattern found in switch case");


        }



        return data;
    }
    @RequestMapping(value = "/patternData1", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<List<Double[]>> getPatternData1(HttpServletRequest request, HttpServletResponse response,@RequestParam("patternId") String patternId,
                                  @RequestParam("patternName") String patternName) throws IOException {
        //return event stream related to the pattern
        ArrayList<List<Double[]>> list = new ArrayList<List<Double[]>>();
        List<Double[]> pattern = new ArrayList<Double[]>();
        List<Double[]> patternRange=new ArrayList<Double[]>();
        List<Event> eventList=new ArrayList<Event>();

        LOG.info("Pattern data retrieving started.",patternName);


        switch (patternName) {
            case "tripplebottom":
                TrippleBottom trippleBottom = patternDao.getTrippleBottom(patternId);
                pattern.add(new Double[]{Double.parseDouble(trippleBottom.getFirstMin()), trippleBottom.getFirstMinPrice()});
                pattern.add(new Double[]{Double.parseDouble(trippleBottom.getFirstMax()), trippleBottom.getFirstMaxPrice()});
                pattern.add(new Double[]{Double.parseDouble(trippleBottom.getSecondMin()), trippleBottom.getSecondMinPrice()});
                pattern.add(new Double[]{Double.parseDouble(trippleBottom.getSecondMax()), trippleBottom.getSecondMaxPrice()});
                pattern.add(new Double[]{Double.parseDouble(trippleBottom.getThirdMin()), trippleBottom.getThirdMinPrice()});
                pattern.add(new Double[]{Double.parseDouble(trippleBottom.getBreakPoint()), trippleBottom.getBreakPointPrice()});
                list.add(pattern);

                eventList=patternDao.getPatternRealData(trippleBottom.getFirstMin(),trippleBottom.getBreakPoint(),trippleBottom.getStock());
                for(Event event:eventList){
                    patternRange.add(new Double[]{Double.parseDouble(event.getDate()), event.getPrice()});
                }
                list.add(patternRange);
                break;
            case "doubletop":
                Doubletop doubletop=patternDao.getDoubletop(patternId);
                pattern.add(new Double[]{Double.parseDouble(doubletop.getFirstMax()),doubletop.getFirstMaxPrice()});
                pattern.add(new Double[]{Double.parseDouble(doubletop.getFirstMin()),doubletop.getFirstMinPrice()});
                pattern.add(new Double[]{Double.parseDouble(doubletop.getSecondMax()),doubletop.getSecondMaxPrice()});
                pattern.add(new Double[]{Double.parseDouble(doubletop.getBreakPoint()),doubletop.getBreakPointPrice()});
                list.add(pattern);
                eventList=patternDao.getPatternRealData(doubletop.getFirstMax(),doubletop.getBreakPoint(),doubletop.getStock());
                for(Event event:eventList){
                    patternRange.add(new Double[]{Double.parseDouble(event.getDate()), event.getPrice()});
                }
                list.add(patternRange);
                break;
            case "doublebottom":
                DoubleBottom doublebottom=patternDao.getDoubleBottom(patternId);
                pattern.add(new Double[]{Double.parseDouble(doublebottom.getFirstMin()),doublebottom.getFirstMinPrice()});
                pattern.add(new Double[]{Double.parseDouble(doublebottom.getFirstMax()),doublebottom.getFirstMaxPrice()});
                pattern.add(new Double[]{Double.parseDouble(doublebottom.getSecondMin()),doublebottom.getSecondMinPrice()});
                pattern.add(new Double[]{Double.parseDouble(doublebottom.getBreakPoint()),doublebottom.getBreakPointPrice()});
                list.add(pattern);
                eventList=patternDao.getPatternRealData(doublebottom.getFirstMin(),doublebottom.getBreakPoint(),doublebottom.getStock());
                for(Event event:eventList){
                    patternRange.add(new Double[]{Double.parseDouble(event.getDate()), event.getPrice()});
                }
                list.add(patternRange);
                break;
            case "trippletop":
                TrippleTop trippletop=patternDao.getTrippleTop(patternId);
                pattern.add(new Double[]{Double.parseDouble(trippletop.getFirstMax()),trippletop.getFirstMaxPrice()});
                pattern.add(new Double[]{Double.parseDouble(trippletop.getFirstMin()),trippletop.getFirstMinPrice()});
                pattern.add(new Double[]{Double.parseDouble(trippletop.getSecondMax()),trippletop.getSecondMaxPrice()});
                pattern.add(new Double[]{Double.parseDouble(trippletop.getSecondMin()),trippletop.getSecondMinPrice()});
                pattern.add(new Double[]{Double.parseDouble(trippletop.getThirdMax()),trippletop.getThirdMaxPrice()});
                pattern.add(new Double[]{Double.parseDouble(trippletop.getBreakPoint()),trippletop.getBreakPointPrice()});
                list.add(pattern);
                eventList=patternDao.getPatternRealData(trippletop.getFirstMax(),trippletop.getBreakPoint(),trippletop.getStock());
                for(Event event:eventList){
                    patternRange.add(new Double[]{Double.parseDouble(event.getDate()), event.getPrice()});
                }
                list.add(patternRange);
                break;
            case "headnshoulder":
                HeadnShoulder headnshoulder=patternDao.getHeadnShoulder(patternId);
                pattern.add(new Double[]{Double.parseDouble(headnshoulder.getFirstMax()),headnshoulder.getFirstMaxPrice()});
                pattern.add(new Double[]{Double.parseDouble(headnshoulder.getFirstMin()),headnshoulder.getFirstMinPrice()});
                pattern.add(new Double[]{Double.parseDouble(headnshoulder.getSecondMax()),headnshoulder.getSecondMaxPrice()});
                pattern.add(new Double[]{Double.parseDouble(headnshoulder.getSecondMin()),headnshoulder.getSecondMinPrice()});
                pattern.add(new Double[]{Double.parseDouble(headnshoulder.getThirdMax()),headnshoulder.getThirdMaxPrice()});
                pattern.add(new Double[]{Double.parseDouble(headnshoulder.getBreakPoint()),headnshoulder.getBreakPointPrice()});
                list.add(pattern);
                eventList=patternDao.getPatternRealData(headnshoulder.getFirstMax(),headnshoulder.getBreakPoint(),headnshoulder.getStock());
                for(Event event:eventList){
                    patternRange.add(new Double[]{Double.parseDouble(event.getDate()), event.getPrice()});
                }
                list.add(patternRange);
                break;
            case "headnshoulderbottom":
                HeadnShoulderBottom headnshoulderbottom=patternDao.getHeadnShoulderBottom(patternId);
                pattern.add(new Double[]{Double.parseDouble(headnshoulderbottom.getFirstMin()),headnshoulderbottom.getFirstMinPrice()});
                pattern.add(new Double[]{Double.parseDouble(headnshoulderbottom.getFirstMax()),headnshoulderbottom.getFirstMaxPrice()});
                pattern.add(new Double[]{Double.parseDouble(headnshoulderbottom.getSecondMin()),headnshoulderbottom.getSecondMinPrice()});
                pattern.add(new Double[]{Double.parseDouble(headnshoulderbottom.getSecondMax()),headnshoulderbottom.getSecondMaxPrice()});
                pattern.add(new Double[]{Double.parseDouble(headnshoulderbottom.getThirdMin()),headnshoulderbottom.getThirdMinPrice()});
                pattern.add(new Double[]{Double.parseDouble(headnshoulderbottom.getBreakPoint()),headnshoulderbottom.getBreakPointPrice()});
                list.add(pattern);
                eventList=patternDao.getPatternRealData(headnshoulderbottom.getFirstMin(),headnshoulderbottom.getBreakPoint(),headnshoulderbottom.getStock());
                for(Event event:eventList){
                    patternRange.add(new Double[]{Double.parseDouble(event.getDate()), event.getPrice()});
                }
                list.add(patternRange);
                break;
            default:
                LOG.info("no pattern found in switch case");

        }
        return list;
    }
}
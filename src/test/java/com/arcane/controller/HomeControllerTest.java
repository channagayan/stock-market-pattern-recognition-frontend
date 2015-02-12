package com.arcane.controller;

import com.arcane.model.Pattern;
import junit.framework.TestCase;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class HomeControllerTest extends TestCase {
    private MockMvc mockMvc;
    public void setUp() throws Exception {
        super.setUp();

    }

    public void testPrintWelcome() throws Exception {
        Pattern pattern = new Pattern();
        pattern.setId(1);
        pattern.setName("doubletop");
        this.mockMvc.perform(get("/arcane"))
                .andExpect(view().name(containsString("/arcane")))
                .andExpect(model().attribute("patterns", new ArrayList<Pattern>().add(pattern)));
    }

    public void testPrintPatternList() throws Exception {

    }

    public void testGetPatternList() throws Exception {

    }

    public void testGetPatternData() throws Exception {

    }

    public void testGetPatternData1() throws Exception {

    }
}
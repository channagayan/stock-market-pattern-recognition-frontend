package org.springframework.samples.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DELL on 11/13/2014.
 */

@Controller
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        LOG.info("Login page loaded");
        return "login";
    }

    @RequestMapping(value = "/admin/loginfailed", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        LOG.info("username or password do not match error occured");
        model.addAttribute("error", "true");
        return "admin/login";
    }
}

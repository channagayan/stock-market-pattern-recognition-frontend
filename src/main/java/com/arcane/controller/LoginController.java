package com.arcane.controller;

import com.arcane.UserBean;
import com.arcane.dao.UserDao;
import com.arcane.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by DELL on 11/13/2014.
 */

@Controller
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        LOG.info("Login page loaded");
        UserBean ub = new UserBean();
        // ub.getCustomerList();
        /*try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/arcanedb");
            Connection conn = ds.getConnection();

            Statement statement = conn.createStatement();
            String sql = "select username, password from user";
            ResultSet rs = statement.executeQuery(sql);

            int count = 1;
            while (rs.next()) {
                System.out.println(String.format("User #%d: %-15s %s", count++,
                        rs.getString("username"), rs.getString("password")));

            }
        } catch (NamingException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            System.err.println(ex);
        }*/
        List<User> listUsers = userDao.list();
        System.out.println(" uuuuuuuuuuuuu       "+listUsers.size());

        return "login";
    }

    @RequestMapping(value = "/admin/loginfailed", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        LOG.info("username or password do not match error occured");
        model.addAttribute("error", "true");
        return "admin/login";
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {

        model.addAttribute("error", "true");
        return "login";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {

        return "login";

    }

}

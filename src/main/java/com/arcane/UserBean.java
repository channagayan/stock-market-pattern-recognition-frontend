package com.arcane;

import com.arcane.model.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 11/22/2014.
 */
public class UserBean {

   /* @Autowired
    @Qualifier("dbDataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier("jdbcTemplate")
    JdbcTemplate jdbcTemplate;
*/

/*    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    public List<User> getCustomerList() throws SQLException {
       /*if(ds==null){
           System.out.println("ds null");
       }else {
           if (ds.getConnection() != null) {
               System.out.println("not null");
           } else {
               System.out.println("--------   null");
           }
       }*/

        try {
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
        }


        List<User> empList = new ArrayList<User>();
        //JDBC Code - Start
        String query = "select userid, username, password from User";
        /*if(dataSource==null){
            System.out.println("null");
            if(jdbcTemplate == null){
                System.out.println("jdbc null");
            }
        }else {
          //  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            List<Map<String, Object>> empRows = jdbcTemplate.queryForList(query);

            for (Map<String, Object> empRow : empRows) {
                User emp = new User();
                emp.setUserid(Integer.parseInt(String.valueOf(empRow.get("userid"))));
                emp.setUsername(String.valueOf(empRow.get("username")));
                emp.setPassword(String.valueOf(empRow.get("password")));
                empList.add(emp);
            }
            System.out.println(empList.size() + " ======================== ");
            // return empList;
        }*/
    return null;
    }
}

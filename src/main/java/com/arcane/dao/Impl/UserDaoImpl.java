package com.arcane.dao.Impl;

import com.arcane.dao.UserDao;
import com.arcane.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by DELL on 11/23/2014.
 */
public class UserDaoImpl  implements UserDao{

    private DataSource dataSource;

    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
        public List<User> list() {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            String sql = "SELECT * from user";
            List<User> listUser = jdbcTemplate.query(sql, new RowMapper<User>() {

                @Override
                public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
                    User user = new User();
                    user.setUserid(rs.getInt("userid"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    return user;
                }

            });
            return listUser;
     }

}

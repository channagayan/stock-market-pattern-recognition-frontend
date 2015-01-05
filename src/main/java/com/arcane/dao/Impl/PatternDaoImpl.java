package com.arcane.dao.Impl;

import com.arcane.dao.PatternDao;
import com.arcane.model.Pattern;
import com.arcane.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Chann on 1/5/2015.
 */
public class PatternDaoImpl implements PatternDao {

    private DataSource dataSource;

    public PatternDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public List<Pattern> patternList(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * from pattern";
        List<Pattern> listPattern = jdbcTemplate.query(sql, new RowMapper<Pattern>() {

            @Override
            public Pattern mapRow(ResultSet rs, int rowNumber) throws SQLException {
                Pattern pattern = new Pattern();
                pattern.setId(rs.getInt("id"));
                pattern.setName(rs.getString("name"));
                return pattern;
            }

        });
        return listPattern;
    }
}

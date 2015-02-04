package com.arcane.dao.Impl;

import com.arcane.dao.PatternDao;
import com.arcane.model.*;
import com.arcane.model.TrippleBottom;
import com.arcane.model.User;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @Override
    public List<TrippleBottom> getTrippleBottomList(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * from tripplebottom";
        List<TrippleBottom> listPattern = jdbcTemplate.query(sql,new RowMapper<TrippleBottom>() {

            @Override
            public TrippleBottom mapRow(ResultSet rs, int rowNumber) throws SQLException {
                TrippleBottom pattern = new TrippleBottom();
                pattern.setId(rs.getInt("id"));
                pattern.setName(rs.getString("name"));
                pattern.setFirstMin(rs.getString("firstMin"));
                pattern.setSecondMin(rs.getString("secondMin"));
                pattern.setThirdMin(rs.getString("thirdMin"));
                pattern.setBreakPoint(rs.getString("breakPoint"));
                pattern.setFirstMinPrice(rs.getDouble("fistMinPrice"));
                pattern.setSecondMinPrice(rs.getDouble("secondMinPrice"));
                pattern.setThirdMinPrice(rs.getDouble("thirdMinPrice"));
                pattern.setBreakPointPrice(rs.getDouble("breakPointPrice"));
                return pattern;
            }

        });
        return listPattern;
    }
    public List<String> getPatternNames(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * from pattern";
        List<String> patternNameList  = jdbcTemplate.query(sql, new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("name");
            }
        });

        return patternNameList;
    }
    @Override
    public List<Pattern> getAllPatternList(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> patternNameList=getPatternNames();
        String sql="";
        List<Pattern> listPattern= new ArrayList<Pattern>();
        for(String pattern:patternNameList){
            sql = "SELECT * from "+pattern;
            List<Pattern> templistPattern = jdbcTemplate.query(sql, new RowMapper<Pattern>() {

                @Override
                public Pattern mapRow(ResultSet rs, int rowNumber) throws SQLException {
                    Pattern pattern1 = new Pattern();
                    pattern1.setId(rs.getInt("id"));
                    pattern1.setStock(rs.getString("stock"));
                    //pattern1.setName(rs.getString("name"));
                    pattern1.setName(rs.getMetaData().getTableName(1));
                    return pattern1;
                }

            });
            listPattern.addAll(templistPattern);
        }

        return listPattern;
    }

    @Override
    public TrippleBottom getTrippleBottom(String id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * from tripplebottom where id="+id;
        List<TrippleBottom> trippleBottom=jdbcTemplate.query(sql, new RowMapper<TrippleBottom>() {

            @Override
            public TrippleBottom mapRow(ResultSet rs, int rowNumber) throws SQLException {
                TrippleBottom trippleBottom1 = new TrippleBottom();
                trippleBottom1.setFirstMinPrice(rs.getDouble("firstMinPrice"));
                trippleBottom1.setSecondMinPrice(rs.getDouble("secondMinPrice"));
                trippleBottom1.setThirdMinPrice(rs.getDouble("thirdMinPrice"));
                trippleBottom1.setBreakPointPrice(rs.getDouble("breakPointPrice"));
                //trippleBottom1.setStock("stock");
                return trippleBottom1;
            }

        });

        return trippleBottom.get(0);
    }
}

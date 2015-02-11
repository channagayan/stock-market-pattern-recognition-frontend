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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * DAO implementation of Pattern Model
 */
public class PatternDaoImpl implements PatternDao {

    private DataSource dataSource;
    List<Pattern> list = new ArrayList<Pattern>();

    Comparator<Pattern> comparator = new Comparator<Pattern>() {
        public int compare(Pattern c1, Pattern c2) {
            return Integer.parseInt(c2.getTimeStamp()) - Integer.parseInt(c1.getTimeStamp()); // use your logic
        }
    };

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
                pattern.setFirstMax(rs.getString("firstMax"));
                pattern.setFirstMaxPrice(rs.getDouble("firstMaxPrice"));
                pattern.setSecondMax(rs.getString("secondMax"));
                pattern.setSecondMaxPrice(rs.getDouble("secondMaxPrice"));
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
                    pattern1.setTimeStamp(rs.getString("breakPoint"));
                    pattern1.setName(rs.getMetaData().getTableName(1));
                    return pattern1;
                }

            });
            listPattern.addAll(templistPattern);
        }
        Collections.sort(listPattern, comparator);
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
                trippleBottom1.setFirstMaxPrice(rs.getDouble("firstMaxPrice"));
                trippleBottom1.setSecondMaxPrice(rs.getDouble("secondMaxPrice"));
                trippleBottom1.setFirstMin(rs.getString("firstMin"));
                trippleBottom1.setSecondMin(rs.getString("secondMin"));
                trippleBottom1.setThirdMin(rs.getString("thirdMin"));
                trippleBottom1.setBreakPoint(rs.getString("breakPoint"));
                trippleBottom1.setFirstMax(rs.getString("firstMax"));
                trippleBottom1.setSecondMax(rs.getString("secondMax"));
                //trippleBottom1.setStock("stock");
                return trippleBottom1;
            }

        });

        return trippleBottom.get(0);
    }

    @Override
    public Doubletop getDoubletop(String id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * from doubletop where id="+id;
        List<Doubletop> doubletop=jdbcTemplate.query(sql, new RowMapper<Doubletop>() {

            @Override
            public Doubletop mapRow(ResultSet rs, int rowNumber) throws SQLException {
                Doubletop doubletop1 = new Doubletop();

                doubletop1.setBreakPointPrice(rs.getDouble("breakPointPrice"));
                doubletop1.setFirstMaxPrice(rs.getDouble("firstMaxPrice"));
                doubletop1.setFirstMinPrice(rs.getDouble("firstMinPrice"));
                doubletop1.setSecondMaxPrice(rs.getDouble("secondMaxPrice"));
                doubletop1.setBreakPoint(rs.getString("breakPoint"));
                doubletop1.setFirstMax(rs.getString("firstMax"));
                doubletop1.setFirstMin(rs.getString("firstMin"));
                doubletop1.setSecondMax(rs.getString("secondMax"));

                return doubletop1;
            }

        });

        return doubletop.get(0);
    }

    @Override
    public DoubleBottom getDoubleBottom(String id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * from doublebottom where id="+id;
        List<DoubleBottom> doublebottom=jdbcTemplate.query(sql, new RowMapper<DoubleBottom>() {

            @Override
            public DoubleBottom mapRow(ResultSet rs, int rowNumber) throws SQLException {
                DoubleBottom doublebottom1 = new DoubleBottom();

                doublebottom1.setBreakPointPrice(rs.getDouble("breakPointPrice"));
                doublebottom1.setFirstMaxPrice(rs.getDouble("firstMaxPrice"));
                doublebottom1.setFirstMinPrice(rs.getDouble("firstMinPrice"));
                doublebottom1.setSecondMinPrice(rs.getDouble("secondMinPrice"));
                doublebottom1.setBreakPoint(rs.getString("breakPoint"));
                doublebottom1.setFirstMax(rs.getString("firstMax"));
                doublebottom1.setFirstMin(rs.getString("firstMin"));
                doublebottom1.setSecondMin(rs.getString("secondMin"));

                return doublebottom1;
            }

        });

        return doublebottom.get(0);
    }

    @Override
    public TrippleTop getTrippleTop(String id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * from trippletop where id="+id;
        List<TrippleTop> trippletop=jdbcTemplate.query(sql, new RowMapper<TrippleTop>() {

            @Override
            public TrippleTop mapRow(ResultSet rs, int rowNumber) throws SQLException {
                TrippleTop trippletop1 = new TrippleTop();

                trippletop1.setBreakPointPrice(rs.getDouble("breakPointPrice"));
                trippletop1.setFirstMaxPrice(rs.getDouble("firstMaxPrice"));
                trippletop1.setSecondMaxPrice(rs.getDouble("secondMaxPrice"));
                trippletop1.setThirdMaxPrice(rs.getDouble("thirdMaxPrice"));
                trippletop1.setFirstMinPrice(rs.getDouble("firstMinPrice"));
                trippletop1.setSecondMinPrice(rs.getDouble("secondMinPrice"));
                trippletop1.setBreakPoint(rs.getString("breakPoint"));
                trippletop1.setFirstMax(rs.getString("firstMax"));
                trippletop1.setSecondMax(rs.getString("secondMax"));
                trippletop1.setThirdMax(rs.getString("thirdMax"));
                trippletop1.setFirstMin(rs.getString("firstMin"));
                trippletop1.setSecondMin(rs.getString("secondMin"));

                return trippletop1;
            }

        });

        return trippletop.get(0);
    }
        @Override
    public HeadnShoulder getHeadnShoulder(String id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * from headnshoulder where id="+id;
        List<HeadnShoulder> headnshoulder=jdbcTemplate.query(sql, new RowMapper<HeadnShoulder>() {

            @Override
            public HeadnShoulder mapRow(ResultSet rs, int rowNumber) throws SQLException {
                HeadnShoulder headnshoulder1 = new HeadnShoulder();

                headnshoulder1.setBreakPointPrice(rs.getDouble("breakPointPrice"));
                headnshoulder1.setFirstMaxPrice(rs.getDouble("firstMaxPrice"));
                headnshoulder1.setSecondMaxPrice(rs.getDouble("secondMaxPrice"));
                headnshoulder1.setThirdMaxPrice(rs.getDouble("thirdMaxPrice"));
                headnshoulder1.setFirstMinPrice(rs.getDouble("firstMinPrice"));
                headnshoulder1.setSecondMinPrice(rs.getDouble("secondMinPrice"));
                headnshoulder1.setBreakPoint(rs.getString("breakPoint"));
                headnshoulder1.setFirstMax(rs.getString("firstMax"));
                headnshoulder1.setSecondMax(rs.getString("secondMax"));
                headnshoulder1.setThirdMax(rs.getString("thirdMax"));
                headnshoulder1.setFirstMin(rs.getString("firstMin"));
                headnshoulder1.setSecondMin(rs.getString("secondMin"));

                return headnshoulder1;
            }

        });

        return headnshoulder.get(0);
    }
    @Override
    public HeadnShoulderBottom getHeadnShoulderBottom(String id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * from headnshoulderbottom where id="+id;
        List<HeadnShoulderBottom> headnshoulderbottom=jdbcTemplate.query(sql, new RowMapper<HeadnShoulderBottom>() {

            @Override
            public HeadnShoulderBottom mapRow(ResultSet rs, int rowNumber) throws SQLException {
                HeadnShoulderBottom headnshoulderbottom1 = new HeadnShoulderBottom();

                headnshoulderbottom1.setBreakPointPrice(rs.getDouble("breakPointPrice"));
                headnshoulderbottom1.setFirstMinPrice(rs.getDouble("firstMinPrice"));
                headnshoulderbottom1.setSecondMinPrice(rs.getDouble("secondMinPrice"));
                headnshoulderbottom1.setThirdMinPrice(rs.getDouble("thirdMinPrice"));
                headnshoulderbottom1.setFirstMaxPrice(rs.getDouble("firstMaxPrice"));
                headnshoulderbottom1.setSecondMaxPrice(rs.getDouble("secondMaxPrice"));
                headnshoulderbottom1.setBreakPoint(rs.getString("breakPoint"));
                headnshoulderbottom1.setFirstMin(rs.getString("firstMin"));
                headnshoulderbottom1.setSecondMin(rs.getString("secondMin"));
                headnshoulderbottom1.setThirdMin(rs.getString("thirdMin"));
                headnshoulderbottom1.setFirstMax(rs.getString("firstMax"));
                headnshoulderbottom1.setSecondMax(rs.getString("secondMax"));

                return headnshoulderbottom1;
            }

        });

        return headnshoulderbottom.get(0);
    }
    @Override
    public List<Pattern> getAllPatternList(String type){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql="";
        String pattern=type;

            sql = "SELECT * from "+pattern;
            List<Pattern> templistPattern = jdbcTemplate.query(sql, new RowMapper<Pattern>() {

                @Override
                public Pattern mapRow(ResultSet rs, int rowNumber) throws SQLException {
                    Pattern pattern1 = new Pattern();
                    pattern1.setId(rs.getInt("id"));
                    pattern1.setStock(rs.getString("stock"));
                    pattern1.setTimeStamp(rs.getString("breakPoint"));
                    pattern1.setName(rs.getMetaData().getTableName(1));
                    return pattern1;
                }

            });


        Collections.sort(templistPattern, comparator);
        return templistPattern;
    }
    @Override
    public List<Event> getPatternRealData(String start,String end,String stock){
        List<Event> events=new ArrayList<Event>();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql="";

        sql = "SELECT * from livestream where CONVERT(date, SIGNED INTEGER) BETWEEN "+start+" AND "+end+" ORDER BY CONVERT(date, SIGNED INTEGER)";
        List<Event> tempEventList = jdbcTemplate.query(sql, new RowMapper<Event>() {

            @Override
            public Event mapRow(ResultSet rs, int rowNumber) throws SQLException {
                Event event = new Event();
                event.setId(rs.getString("id"));
                event.setStock(rs.getString("stock"));
                event.setDate(rs.getString("date"));
                event.setPrice(rs.getDouble("price"));
                return event;
            }

        });

        return tempEventList;
    }

}

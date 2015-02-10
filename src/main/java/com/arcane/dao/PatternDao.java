package com.arcane.dao;

import com.arcane.model.*;

import java.util.List;

/**
 * Created by Chann on 1/5/2015.
 */
public interface PatternDao {
    public List<Pattern> patternList();
    public List<TrippleBottom> getTrippleBottomList();
    public List<Pattern> getAllPatternList();
    public TrippleBottom getTrippleBottom(String id);
    public Doubletop getDoubletop(String id);
    public DoubleBottom getDoubleBottom(String id);
    public TrippleTop getTrippleTop(String id);
    public HeadnShoulder getHeadnShoulder(String id);
    public HeadnShoulderBottom getHeadnShoulderBottom(String id);
    public List<Pattern> getAllPatternList(String type);
    public List<Event> getPatternRealData(String start,String end,String stock);
}

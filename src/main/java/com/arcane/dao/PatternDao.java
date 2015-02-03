package com.arcane.dao;

import com.arcane.model.Pattern;
import com.arcane.model.TrippleBottom;

import java.util.List;

/**
 * Created by Chann on 1/5/2015.
 */
public interface PatternDao {
    public List<Pattern> patternList();
    public List<TrippleBottom> getTrippleBottomList();
    public List<Pattern> getAllPatternList();
}

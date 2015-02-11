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
package com.arcane.dao;

import com.arcane.model.*;

import java.util.List;

/**
 * Pattern DAO Interface
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

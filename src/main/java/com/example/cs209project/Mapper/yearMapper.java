package com.example.cs209project.Mapper;

import com.example.cs209project.pojo.timeChange;
import com.example.cs209project.pojo.sort_num;
import java.util.List;
import java.util.Map;

public interface yearMapper {
    int insert(timeChange record);

    List<timeChange> selectAll();
    List<sort_num> selectTime(Map<String,String> map);
}
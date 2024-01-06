package com.example.cs209project.Mapper;

import com.example.cs209project.pojo.Issues;
import java.util.List;
import java.util.Map;

public interface IssuesMapper {
    int deleteByPrimaryKey(Integer num);

    int insert(Issues record);

    Issues selectByPrimaryKey(Integer num);

    List<Issues> selectAll();

    int updateByPrimaryKey(Issues record);

    List<Issues> selectByTopicTimeBoth(Map<String,String> map);
    List<Issues> selectByTopicTimeUpdate(Map<String,String> map);
    List<Issues> selectByTopicState(Map<String,String> map);
    List<Issues> selectBySort(String word);

}
package com.example.cs209project.Mapper;

import com.example.cs209project.pojo.Test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Test record);

    Test selectByPrimaryKey(Integer id);

    List<Test> selectAll();

    int updateByPrimaryKey(Test record);
}
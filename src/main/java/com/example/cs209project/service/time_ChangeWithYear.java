package com.example.cs209project.service;

import com.example.cs209project.Mapper.yearMapper;
import com.example.cs209project.pojo.sort_num;
import com.example.cs209project.pojo.YearNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class time_ChangeWithYear {

    @Autowired
    private yearMapper yearMapper;

    public List<YearNumber> yearArray(){
        List<YearNumber> lists=new LinkedList<>();
        Map<String,String> map=new HashMap<>();
        map.put("time1","0");
        map.put("time2","2016");
        List<sort_num> list=yearMapper.selectTime(map);
        YearNumber yearNumber=new YearNumber();
        yearNumber.setYear("2015 and before");
        yearNumber.setNumAWT(list.get(0).getNum());
        if(list.get(1).getSort().equals("JavaFx")){
            yearNumber.setNumJavaFx(list.get(1).getNum());
            yearNumber.setNumSwing(list.get(2).getNum());
            yearNumber.setNumSWT(list.get(3).getNum());
        }else {
            yearNumber.setNumJavaFx(0);
            yearNumber.setNumSwing(list.get(1).getNum());
            yearNumber.setNumSWT(list.get(2).getNum());
        }
        lists.add(yearNumber);
        for (int i = 2016; i <=2022 ; i++) {
            map.put("time1",String.valueOf(i));
            map.put("time2",String.valueOf(i+1));
            List<sort_num> list1=yearMapper.selectTime(map);
            YearNumber yearNumber1=new YearNumber();
            yearNumber1.setYear(String.valueOf(i));
            yearNumber1.setNumAWT(list1.get(0).getNum());
            if(list1.get(1).getSort().equals("JavaFx")){
                yearNumber1.setNumJavaFx(list1.get(1).getNum());
                yearNumber1.setNumSwing(list1.get(2).getNum());
                yearNumber1.setNumSWT(list1.get(3).getNum());
            }else {
                yearNumber1.setNumJavaFx(0);
                yearNumber1.setNumSwing(list1.get(1).getNum());
                yearNumber1.setNumSWT(list1.get(2).getNum());
            }
            lists.add(yearNumber1);
        }
        return lists;
    }
}

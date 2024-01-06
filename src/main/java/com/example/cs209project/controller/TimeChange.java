package com.example.cs209project.controller;

import com.example.cs209project.pojo.YearNumber;
import com.example.cs209project.service.time_ChangeWithYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TimeChange {

    @Autowired
    time_ChangeWithYear time_changeWithYear;

    @RequestMapping("/timeChange")
    @ResponseBody
    public List<YearNumber> timeChange(){
        return time_changeWithYear.yearArray();
    }
}

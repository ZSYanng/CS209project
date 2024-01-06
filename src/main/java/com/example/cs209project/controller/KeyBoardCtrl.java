package com.example.cs209project.controller;

import com.example.cs209project.pojo.KeyBoard;
import com.example.cs209project.service.keyBoard_generate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin
public class KeyBoardCtrl {

    @Autowired
    keyBoard_generate serve;

    @RequestMapping("/keyBoard")
    @ResponseBody
    public List<KeyBoard> timeChange(){
        List<com.example.cs209project.pojo.KeyBoard> list=new LinkedList<>();
        list.add(serve.AWTOpen());
        list.add(serve.Swingopen());
        list.add(serve.JavaFxopen());
        list.add(serve.SWTopen());
        list.add(serve.AWTclosed());
        list.add(serve.Swingclosed());
        list.add(serve.JavaFxclosed());
        list.add(serve.SWTclosed());
        return list;
    }
}

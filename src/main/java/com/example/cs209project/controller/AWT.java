package com.example.cs209project.controller;

import com.example.cs209project.pojo.Issues;
import com.example.cs209project.service.Issue_HighFrequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@CrossOrigin
public class AWT {
    @Autowired
    Issue_HighFrequency issue_highFrequency;


    @ResponseBody
    @RequestMapping("/AWTIssue/concrete")
    public List<Issues> AWTIssues(){//
        //Todo: 从前端获取需要传入的数据word
        List<Issues> list=new ArrayList<>();
        Map<Integer,Issues> map=issue_highFrequency.AWT_Issues("AWT");
        for (int i = 0; i < map.size(); i++) {
            Issues t=map.get(i);
            String content=t.getContent();
            if(content!=null){
                content=modify(content);
            }
            t.setContent(content);
            list.add(t); 
        }
        return list;
    }
    @ResponseBody
    @RequestMapping("/SwingIssue/concrete")
    public List<Issues> SwingIssues(){//
        //Todo: 从前端获取需要传入的数据word
        List<Issues> list=new ArrayList<>();
        Map<Integer,Issues> map=issue_highFrequency.AWT_Issues("Swing");
        for (int i = 0; i < map.size(); i++) {
            Issues t=map.get(i);
            String content=t.getContent();
            if(content!=null){
                content=modify(content);
            }
            t.setContent(content);
            list.add(t);
        }
        return list;
    }
    @ResponseBody
    @RequestMapping("/JavaFxIssue/concrete")
    public List<Issues> JavaFxIssues(){//
        //Todo: 从前端获取需要传入的数据word
        List<Issues> list=new ArrayList<>();
        Map<Integer,Issues> map=issue_highFrequency.AWT_Issues("JavaFx");
        for (int i = 0; i < map.size(); i++) {
            Issues t=map.get(i);
            String content=t.getContent();
            if(content!=null){
                content=modify(content);
            }
            t.setContent(content);
            list.add(t);
        }
        return list;
    }
    @ResponseBody
    @RequestMapping("/SWTIssue/concrete")
    public List<Issues> SWTIssues(){//
        //Todo: 从前端获取需要传入的数据word
        List<Issues> list=new ArrayList<>();
        Map<Integer,Issues> map=issue_highFrequency.AWT_Issues("SWT");
        for (int i = 0; i < map.size(); i++) {
            Issues t=map.get(i);
            String content=t.getContent();
            if(content!=null){
                content=modify(content);
            }
            t.setContent(content);
            list.add(t);
        }
        return list;
    }

    @ResponseBody
    @PostMapping (value="/limitTime")
    public List<Issues> IssuesLimitedByTimeCreated(@RequestParam("topic") String topic,@RequestParam("sort")String sort,@RequestParam("created_at") String created_atB,@RequestParam("updated_at") String created_atA){//
        //Todo: 从前端获取需要传入的数据word
        List<Issues> list=new ArrayList<>();
        Map<Integer,Issues> map=issue_highFrequency.AWT_Issues_TimelimitCreat(topic,created_atB,created_atA,sort);
        for (int i = 0; i < map.size(); i++) {
            Issues t=map.get(i);
            String content=t.getContent();
            String word="\\\\\\n";
            Pattern pattern=Pattern.compile(word);
            Matcher matcher=pattern.matcher(content);
            while (matcher.find()){
                content=matcher.replaceAll(" ");
            }
            String word2="\\\\n";
            content=content.replaceAll(word2," ");
            String word3="\\n";
            content=content.replaceAll(word3," ");
            String word4="\\\\\\\"";
            content=content.replaceAll(word4,"");
            String word5="```";
            content=content.replaceAll(word5,"");
            t.setContent(content);
            list.add(t);
        }
        return list;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        StringBuffer stringBuffer=new StringBuffer();
        List<Issues> map=issue_highFrequency.test();
        for (int i = 0; i < map.size(); i++) {
            stringBuffer.append(map.get(i).getTopic()).append("\n");
        }
//        @RequestParam(value = "OpenCV", defaultValue = "Error") String word
        return stringBuffer.toString();
    }

    public static String modify(String content){
        String word="\\\\\\n";
        Pattern pattern=Pattern.compile(word);
        Matcher matcher=pattern.matcher(content);
        while (matcher.find()){
            content=matcher.replaceAll(" ");
        }
        String word2="\\\\n";
        content=content.replaceAll(word2," ");
        String word3="\\n";
        content=content.replaceAll(word3," ");
        String word4="\\\\\\\"";
        content=content.replaceAll(word4,"");
        String word5="```";
        content=content.replaceAll(word5,"");
        return content;
    }

}

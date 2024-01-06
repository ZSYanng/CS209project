package com.example.cs209project.service;

import com.example.cs209project.Mapper.IssuesMapper;
import com.example.cs209project.Utils.SpringBeanUtil;
import com.example.cs209project.pojo.Issues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class Issue_HighFrequency {
    private static Issue_HighFrequency Util;  // 静态初使化当前类

    @Autowired
    private IssuesMapper issuesMapper;
//     zkxtAuthorituRemoteApi = SpringBeanUtil.getBean(textAuthorituRemoteApi .class);


//    @PostConstruct
//    public void init(){
//        Util=this;
//        Util.issuesMapper=this.issuesMapper;
//    }
    public List<Issues> test(){
        return issuesMapper.selectAll();
    }
    public Map<Integer, Issues> AWT_Issues(String word){
//        init();
        List<Issues> issuesList=issuesMapper.selectBySort(word);
        Map<Integer, Issues> map=new HashMap<>();
        for (int i = 0; i < issuesList.size(); i++) {
//            String str=issuesList.get(i).getTopic()+"\n"+issuesList.get(i).getContent();
            map.put(i,issuesList.get(i));
        }
        return map;
    }
    public Map<Integer, Issues> AWT_Issues_TimelimitCreat(String word,String time1,String time2,String sort){
        Map<String,String> input=new HashMap<>();
        input.put("word",word);
        input.put("time1",time1);
        input.put("time2",time2);
        input.put("sort",sort);
        List<Issues> issuesList=issuesMapper.selectByTopicTimeBoth(input);
        Map<Integer, Issues> map=new HashMap<>();
        for (int i = 0; i < issuesList.size(); i++) {
            map.put(i,issuesList.get(i));
        }
        return map;
    }
    public Map<String, String> AWT_Issues_TimelimitUpdate(String word,String time){
        Map<String,String> input=new HashMap<>();
        input.put("word",word);
        input.put("time",time);
        List<Issues> issuesList=issuesMapper.selectByTopicTimeUpdate(input);
        Map<String, String> map=new HashMap<>();
        for (int i = 0; i < issuesList.size(); i++) {
            map.put(issuesList.get(i).getTopic(),issuesList.get(i).getContent());
        }
        return map;
    }
    public Map<Integer, Issues> AWT_Issues_TimelimitBoth(String word,String timeC,String timeU){
        Map<String,String> input=new HashMap<>();
        input.put("word",word);
        input.put("time1",timeC);
        input.put("time2",timeU);
        List<Issues> issuesList=issuesMapper.selectByTopicTimeBoth(input);
        Map<Integer, Issues> map=new HashMap<>();
        for (int i = 0; i < issuesList.size(); i++) {
            map.put(i,issuesList.get(i));
        }
        return map;
    }
    public Map<String, String> AWT_Issues_State(String word,String state){
        Map<String,String> input=new HashMap<>();
        input.put("word",word);
        input.put("state",state);
        List<Issues> issuesList=issuesMapper.selectByTopicState(input);
        Map<String, String> map=new HashMap<>();
        for (int i = 0; i < issuesList.size(); i++) {
            map.put(issuesList.get(i).getTopic(),issuesList.get(i).getContent());
        }
        return map;
    }

}

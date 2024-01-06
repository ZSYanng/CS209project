package com.example.cs209project.script;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class key_WordFrequency {
    String path;
    public key_WordFrequency(String path){
        this.path=path;

    }
    public static void main(String[] args) throws IOException {
        key_WordFrequency textProcessor=new key_WordFrequency("AWT_title_closed.txt");
        String[] words=new String[]{"title","is","a","and","of","cannot","the","for","do","from","to","with","when","not","on","an","after","are","in","awt","java","AWT","Do"};
        textProcessor.getCommonWords(40,words);
    }
    public static int rightNum(int right,char[] chars){
        while(right<chars.length&&
                (chars[right]=='.'||
                        (chars[right]<='z'&&'a'<=chars[right])||(chars[right]<='9'&&'0'<=chars[right])||(chars[right]<='Z'&&'A'<=chars[right])
                        ||(right< chars.length-1&&chars[right]=='\''&&(chars[right+1]<='z'&&'a'<=chars[right+1]||chars[right+1]<='9'&&'0'<=chars[right+1]))
                        ||(right< chars.length-1&&chars[right]=='-'&&(chars[right+1]<='z'&&'a'<=chars[right+1]||chars[right+1]<='9'&&'0'<=chars[right+1]))
                        ||(right< chars.length-1&&chars[right]=='\''&&(chars[right+1]<='Z'&&'A'<=chars[right+1]||chars[right+1]<='9'&&'0'<=chars[right+1]))
                        ||(right< chars.length-1&&chars[right]=='-'&&(chars[right+1]<='Z'&&'A'<=chars[right+1]||chars[right+1]<='9'&&'0'<=chars[right+1])))){
            right++;
        }
        return right;
    }
    public TreeMap<String, Integer> getCommonWords(int n, String[] stopwords) throws IOException {
        FileInputStream fis=new FileInputStream(this.path);
        InputStreamReader isr=new InputStreamReader(fis);
        BufferedReader bfr=new BufferedReader(isr);
        HashMap<String,Integer> map=new HashMap<>();
        String str;
        while((str=bfr.readLine())!=null){
//            str=str.toLowerCase(Locale.ROOT);
            char[] chars=str.toCharArray();
            int left=0;int right=0;
            while(right<chars.length){
                while(left<chars.length&&((chars[left]<'a'||chars[left]>'z')&&(chars[left]<'0'||chars[left]>'9')&&(chars[left]<'A'||chars[left]>'Z'))){
                    left++;
                }
                right=left;
                right=rightNum(right,chars);
                if(left!=right){
                    String current=str.substring(left,right);
                    Integer count;
                    if ((count=map.get(current)) == null) {
                        map.put(current, 1);
                    } else {
                        map.put(current, 1 + count);
                    }
                    left=right;
                }
            }
        }
        Map<String, Integer> map1=map.entrySet().stream().filter((e)->{
            for (int i = 0; i < stopwords.length; i++)
                if (e.getKey().equals(stopwords[i])) return false;
            return true;
        }).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        TreeMap<String,Integer> treeMap = new TreeMap<>();
        List<Map.Entry<String,Integer>> entries=new ArrayList<Map.Entry<String, Integer>>(map1.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (!Objects.equals(o1.getValue(), o2.getValue()))
                    return Integer.compare(o2.getValue(), o1.getValue());
                else
                    return o1.getKey().compareTo(o2.getKey());
            }
        });
//        System.out.println(entries);
        for (int i = 0; i < Math.min(n,entries.size()); i++) {
            treeMap.put(entries.get(i).getKey(),entries.get(i).getValue());
            System.out.println(entries.get(i).getKey()+" "+entries.get(i).getValue());
        }
        return treeMap;
    }
}

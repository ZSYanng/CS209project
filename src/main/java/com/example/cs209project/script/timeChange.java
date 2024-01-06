package com.example.cs209project.script;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class timeChange {


    public static void main(String[] args) throws IOException {

//        String[]web={"AWT","Swing","JavaFx","SWT"};
//        for(String webTool:web){
//        File file=new File("Swing_timeChange.txt");
//        if(!file.exists())//判断文件是否存在，若不存在则新建
//        {
//            file.createNewFile();
//        }
        FileOutputStream fileOutputStream=new FileOutputStream("SWT_timeChange_open.txt");//实例化FileOutputStream
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream,"utf-8");//将字符流转换为字节流
        BufferedWriter bufferedWriter= new BufferedWriter(outputStreamWriter);//创建字符缓冲输出流对象
        JSONArray out=new JSONArray();
        for(int j=4;j<5;j++){
            String url ="https://api.github.com/search/issues?q=AWT+language:java+state:open&per_page=100&page="+j;
            URL Url =new URL(url);
            HttpURLConnection conn=(HttpURLConnection)Url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type","application/vnd.github.v3+json");
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output=responseBuffer.readLine();
            JSONArray temp=JSONObject.fromObject(output).getJSONArray("items");
            for(int i=0;i<100;i++){
                JSONObject tt= JSONObject.fromObject(temp.get(i)) ;
                JSONObject t=new JSONObject();
                t.put("id",tt.get("id"));
                t.put("created_at",tt.get("created_at"));
                t.put("updated_at",tt.get("updated_at"));
//                JSONArray labels=JSONArray.fromObject(tt.get("labels"));
//                if(labels.size()==0){
//                    t.put("labels","[]");
//                }else {
//                    JSONArray x=new JSONArray();
//                    for(int k=0;k<labels.size();k++){
//                        x.add(JSONObject.fromObject(labels.get(k)).get("name"));
//                    }
//                    t.put("labels",x);
//                }
                t.put("state",tt.get("state"));
                String title= (String) tt.get("title");
                title=title.replaceAll(",","，");
                t.put("title",title);
//                t.put("html_url",tt.get("html_url"));
//                t.put("body",(JSONNull.getInstance().equals(tt.get("body")))?"null":(String)tt.get("body"));

                out.add(tt);
                bufferedWriter.write(t.toString()+"\n");
                bufferedWriter.flush();
            }
        }
        bufferedWriter.close();
    }
//    }
}

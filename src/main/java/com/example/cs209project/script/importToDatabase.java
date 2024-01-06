package com.example.cs209project.script;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class importToDatabase {
    private static final int  BATCH_SIZE = 500;
    private static Connection con = null;
    private static PreparedStatement  stmt = null;
    private static boolean verbose = false;

    private static void openDB(String host, String dbname,
                               String user, String pwd) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch(Exception e) {
            System.err.println("Cannot find the Postgres driver. Check CLASSPATH.");
            System.exit(1);
        }
        String url = "jdbc:postgresql://" + host + "/" + dbname;
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", pwd);
        try {
            con = DriverManager.getConnection(url, props);
            if (verbose) {
                System.out.println("Successfully connected to the database "
                        + dbname + " as " + user);
            }
            con.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Database connection failed");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        try {
            stmt = con.prepareStatement("insert into issue_helper(\"owner_id\",created_at,updated_at,state,\"topic\",html_url,content,sort)"
                    + " values(?,?,?,?,?,?,?,?)");
        } catch (SQLException e) {
            System.err.println("Insert statement failed");
            System.err.println(e.getMessage());
            closeDB();
            System.exit(1);
        }
    }

    private static void closeDB() {
        if (con != null) {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                con.close();
                con = null;
            } catch (Exception e) {
                // Forget about it
            }
        }
    }

    private static void loadData(int ownerId,String creatTime,String updateTime,String state,String topic,String url,String content,String sort)
            throws SQLException {
        //Weeklist用String表示，因为找不到set+数组
        if (con != null) {
            //TODO:stmt.setxxx
            stmt.setInt(1,ownerId);
            stmt.setString(2,creatTime);
            stmt.setString(3,updateTime);
            stmt.setString(4,state);
            stmt.setString(5,topic);
            stmt.setString(6,url);
            stmt.setString(7,content);
            stmt.setString(8,sort);
            stmt.addBatch();
        }
    }

    public static void main(String[] args) {

        Properties defprop = new Properties();
        defprop.put("host", "localhost");
        defprop.put("user", "postgres");
        defprop.put("password", "135780");
        defprop.put("database", "CS209Pro");
        Properties prop = new Properties(defprop);
        try (BufferedReader infile
                     = new BufferedReader(new FileReader("C:\\Users\\HP\\IdeaProjects\\Project1-maven1\\src\\main\\resources\\SWT_issue_closed.txt"))) {//TODO:改文件名
            String   line;
            String[] parts;
            int      cnt = 0;
            // Empty target table
            openDB(prop.getProperty("host"), prop.getProperty("database"),
                    prop.getProperty("user"), prop.getProperty("password"));
            Statement stmt0;
            if (con != null) {
                stmt0 = con.createStatement();
                stmt0.execute("truncate table issue_helper");
                stmt0.close();
            }
            closeDB();
            openDB(prop.getProperty("host"), prop.getProperty("database"),
                    prop.getProperty("user"), prop.getProperty("password"));
            //核心代码
            int ownerID;
            String creatTime;
            String updateTime;
            String state;
            String topic;
            String url;
            String content=null;
            while ((line = infile.readLine()) != null) {
                parts = line.split(",");
                System.out.println(cnt);
                if (parts.length > 1) {
                    //TODO: 分析json文件
                    ownerID=Integer.parseInt(parts[0].substring(6));
                    creatTime=parts[1].substring(14,parts[1].length()-1);
                    updateTime=parts[2].substring(14,parts[2].length()-1);
                    state=parts[3].substring(9,parts[3].length()-1);
                    topic=parts[4].substring(9,parts[4].length()-1);
                    url=parts[5].substring(12,parts[5].length()-1);
                    if(!parts[6].equals("\"body\":null}")&&!parts[6].equals("\"body\":\"\"}")){
                        System.out.println(parts[6]);
                        if(parts.length>7){
                            content=parts[6].substring(8);
                        }else{
                            content=parts[6].substring(8,parts[6].length()-1);
                        }
                        for (int i = 7; i <parts.length-1 ; i++) {
                            content=content.concat(parts[i]);
                        }
                        content=content.concat(parts[parts.length-1].substring(0,parts[parts.length-1].length()-1));
                    }

                    loadData(ownerID,creatTime,updateTime,state,topic,url,content,"SWT");
                    cnt++;
                    if (cnt % BATCH_SIZE == 0) {
                        stmt.executeBatch();
                        stmt.clearBatch();
                    }
                }
                content=null;
            }
            if (cnt % BATCH_SIZE != 0) {
                stmt.executeBatch();
            }
            con.commit();
            stmt.close();
            closeDB();
            System.out.println(cnt + " records successfully loaded");
        } catch (SQLException se) {
            System.err.println("SQL error: " + se.getMessage());
            try {
                con.rollback();
                stmt.close();
            } catch (Exception e2) {
            }
            closeDB();
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Fatal error: " + e.getMessage());
            try {
                con.rollback();
                stmt.close();
            } catch (Exception e2) {
            }
            closeDB();
            System.exit(1);
        }
        closeDB();
    }
}


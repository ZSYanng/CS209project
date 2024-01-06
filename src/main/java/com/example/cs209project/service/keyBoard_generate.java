package com.example.cs209project.service;

import com.example.cs209project.pojo.KeyBoard;
import org.springframework.stereotype.Service;

@Service
public class keyBoard_generate {
    private KeyBoard keyBoard;
    public KeyBoard AWTOpen(){
        keyBoard =new KeyBoard("Android + OpenCV","CanvasFrame","slash","2.5.22294","NullPointerException","auto-generated");
        return keyBoard;
    }
    public KeyBoard AWTclosed(){
        keyBoard =new KeyBoard("Error Report","Add","NPE","Plugin", "file" , "lambda");
        return keyBoard;
    }
    public KeyBoard Swingclosed(){
        keyBoard =new KeyBoard("Bump",
                "3.4.16",
                "ExecutionException",
                "Update",
                "TileNotFoundException",
                "IOException");
        return keyBoard;
    }
    public KeyBoard Swingopen(){
        keyBoard =new KeyBoard("images",
                "Bump",
                "Windows",
                "ImgBot",
                "Randomizer",
                "NPE");
        return keyBoard;
    }
    public KeyBoard JavaFxopen(){
        keyBoard =new KeyBoard("Bump",
                "javafx-controls",
                "module",
                "javafx-fxml",
                "Optimize",
                "javafx-maven-plugin");
        return keyBoard;
    }
    public KeyBoard JavaFxclosed(){
        keyBoard =new KeyBoard("Bump",
                "controls",
                "fxml",
                "graphics",
                "version",
                "base");
        return keyBoard;
    }
    public KeyBoard SWTclosed(){
        keyBoard =new KeyBoard("Bump",
                "Eclipse",
                "disposed",
                "Bugzilla",
                "add",
                "version");
        return keyBoard;
    }
    public KeyBoard SWTopen(){
        keyBoard =new KeyBoard("Eclipse",
                "NPE",
                "file",
                "support",
                "loop",
                "opening");
        return keyBoard;
    }


}

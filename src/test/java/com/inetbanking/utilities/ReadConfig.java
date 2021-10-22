package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;  // Object for property class

    public ReadConfig() {
        File src = new File("src/test/resources/Configuration/config.properties"); // Create object for file
        try {
            FileInputStream fis = new FileInputStream(src);  //Import file and read data we use file inputstream
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }
    //Create method for every variable
public String ApplicationURL()
{
    String url = pro.getProperty("baseurl");
    return url;
}
    public String Username()
    {
        String username = pro.getProperty("username");
        return username;
    }
    public String Password()
    {
        String password = pro.getProperty("password");
        return password;
    }
    public String Chromepath()
    {
        String chromepath = pro.getProperty("chromepath");
        return chromepath;
    }
    public String Firefox()
    {
        String firefoxpath = pro.getProperty("firefoxpath");
        return firefoxpath;
    }
}

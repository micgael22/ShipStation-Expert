package io.tests.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    public ReadConfig() {
        File src = new File("src/main/resources/Config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        }
        catch (Exception e){
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getAppUrl() {
        String url = pro.getProperty("url");
        return url;
    }

    public String getUserName() {
        String userName = pro.getProperty("userName");
        return userName;
    }

    public String getUserID() {
        String userID = pro.getProperty("userID");
        return userID;
    }

    public String getPassword() {
        String password = pro.getProperty("password");
        return password;
    }

    public String getChromeDr() {
        String chromeDr = pro.getProperty("chromeDr");
        return chromeDr;
    }

    public String getIEDriver() {
        String ieDriver = pro.getProperty("ieDriver");
        return ieDriver;
    }

    public String getFireFoxDr() {
        String fireFoxDr = pro.getProperty("fireFoxDr");
        return fireFoxDr;
    }

    //Read config.properties??
    // add a new Variable == add responding method

}

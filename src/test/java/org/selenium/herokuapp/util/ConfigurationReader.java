package org.selenium.herokuapp.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {
        try(InputStream inputStream=new FileInputStream("src/test/resources/config.properties"))
        {
            properties.load(inputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key)
    {
        return properties.getProperty(key);
    }

    public static String getBaseURL(){
        return get("BASE_URL");
    }

    public static String getBrowser(){
        return get("BROWSER");
    }

    public static String getUsername(){
        return get("USERNAME");
    }

    public static String getPassword(){
        return  get("PASSWORD");
    }
    public static String getInvalidUsername(){
        return get("INVALID_USERNAME");
    }

    public static String getInvalidPassword(){
        return  get("INVALID_PASSWORD");
    }
    public static int getTimeout()
    {
        String timeout = get("TIMEOUT");
        return Integer.parseInt(timeout);
    }
}

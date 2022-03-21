package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    public Properties prop;
    public String browserName;
    public String url;

    public String filepath="src/main/resources/confs/config.properties";


    public ConfigFileReader() {
        try {
            prop = new Properties();
            FileInputStream inputStream = new FileInputStream(filepath);
            prop.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String browserName(){
        browserName=prop.getProperty("browser");
        return browserName;
    }
    public String getUrl(){
        url=prop.getProperty("url");
        return url;
    }
}


package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    static public String getProperty(String fileName, String item){
        Properties prop = new Properties();
        try {
            FileInputStream input = new FileInputStream(fileName);
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

      return prop.getProperty(item);
    }
}

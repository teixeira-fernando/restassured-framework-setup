package utils;

import io.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import static io.restassured.RestAssured.given;

public class Utils {

    public String propFileName = "config.properties";
    public String host;

    public JSONObject getJSONData(String filePath)
    {
        return new JSONObject(new Scanner(Utils.class.getClassLoader().getResourceAsStream(filePath)).useDelimiter("\\Z").next());
    }

    public Utils(){
        host = getHost();
    }

    public String getHost() {
        try {
            Properties properties = new Properties();
            InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(propFileName);
            properties.load(inputStream);
            return properties.getProperty("host");
        } catch (IOException ex) {
            System.out.println("Error to read the properties file");
        }
        return null;
    }
}

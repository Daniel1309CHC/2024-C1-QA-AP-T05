package co.com.sofka.utils.jsonparser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonCommon {
    public static JSONObject jsonToObject(String jsonString){
        JSONObject jsonObject = new JSONObject();
        try{
            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  jsonObject;
    }




}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JSON Reader with json simple
 * @author Amadeus
 */
public class JReader {
    
    public List<Site> reader(){
        List<Site> listOfSites = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try{
            // creating a parser for the json example
            Object obj = parser.parse(new FileReader("example.json"));
            
            // creating a json object
            JSONObject jobj = (JSONObject) obj;
            //System.out.println(jobj);
            
            // putting the example jsons in a array
            JSONArray readings = (JSONArray) jobj.get("site_readings");
            // for each object in readings
            for(Object object :readings){
                // read out the readings 
                JSONObject reading = (JSONObject) object;
                
                String siteID = (String) reading.get("site_id");
                //System.out.println("siteID is: " + siteID);
                String readingType = (String) reading.get("reading_type");
                String readingID = (String) reading.get("reading_id");
                String readingValue = (String) reading.get("reading_value");
                String readingDate = (String) reading.get("reading_date");
                
                Site site = new Site(siteID, readingType, readingID, readingValue, readingDate);
                listOfSites.add(site);
                //System.out.println(site.toString());
            }
            return listOfSites;
        }catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch(ParseException pe){
            pe.printStackTrace();
        }catch(IOException ie){
            ie.printStackTrace();
        }
        return listOfSites;
    }
}

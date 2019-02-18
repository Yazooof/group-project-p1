package com.group_project_1.json_file_read_write;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.group_project_1.collection.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: The reader for the json file
 *Sources that helped me with gson: https://www.javainterviewpoint.com/read-write-json-using-gson/
 *
 * @author Amadeus
 */
public class JSONReader {
	
    private Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
    private File file;

    public List<Site> reader() {
        Gson gson = new Gson();
        try {
            // reader for json file
            BufferedReader reader = new BufferedReader(new FileReader("example.json"));
            //creating an object of json file
	    // deserializes json to readings	
            Readings sample = gson.fromJson(reader, Readings.class);
            reader.close();
	    // returns the deserialized results in a list collection
            return sample.getSiteReadings();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return new ArrayList<Site>();
       
    }

    // used for displaying the object in the JSON file.
    public void display() {
	    
        if (reader() != null) {
            for (Site t : reader()) {
                System.out.println(t.toString());
            }
        }

    }
    
    public ArrayList<Site> readFromInputFile(File file) {
        ArrayList<Site> listOfSites = null;
        BufferedReader inputFileSiteReadingsreader = null;

        try {
            inputFileSiteReadingsreader = new BufferedReader(new FileReader(file));
            listOfSites = gsonBuilder.fromJson(inputFileSiteReadingsreader, listOfSites.getClass());

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return listOfSites;
    }
}


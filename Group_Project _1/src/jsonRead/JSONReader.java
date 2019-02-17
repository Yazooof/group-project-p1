package jsonRead;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import inputOutputFromFile.*;
import jsonRead.*;
import collection.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Description: The reader for the json file
 *
 *
 * @author Amadeus
 */
public class JSONReader {

    /**
     *
     * @param takes in a json file
     * @return returns a List of sites
     */
    private Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
    private File file;
    
    
    
    public Readings readJsonFromExistingFile() {

        Readings listFromExistingFile = null;
        BufferedReader allreadingsJsonFileReader = null;
        try {
            allreadingsJsonFileReader = new BufferedReader(new FileReader("allReadings.json"));
            listFromExistingFile = gsonBuilder.fromJson(allreadingsJsonFileReader, Readings.class);

            allreadingsJsonFileReader.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSONReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listFromExistingFile;

    }

    public Readings readFromInputFile(File file) {
        Readings listOfSites = null;
        BufferedReader inputFileSiteReadingsreader = null;

        try {
            inputFileSiteReadingsreader = new BufferedReader(new FileReader(file));
            listOfSites = gsonBuilder.fromJson(inputFileSiteReadingsreader, Readings.class);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listOfSites;
    }
    
   
   
    public File getInputJsonFile() {
        return file;
    }
    
    public void setInPutJsonFile(File file) {
        this.file = file;
    }
    
    
    public Readings jsonFileWriter() {

        Readings listOfSites = null;
        List<Site> allReadings = new ArrayList<>();
        Readings listFromExistingFile = null;
        
        //if(Site.getCollectionOfSites() != null)
           // allReadings.addAll(Site.getCollectionOfSites());
        
        try {
            listFromExistingFile = readJsonFromExistingFile();
            listOfSites = readFromInputFile(getInputJsonFile());
            //recreate our existing json file -- delte everything in it
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("allReadings.json")));
            //add all site readings from our exitings json file to a list
            if (listFromExistingFile != null) {
                for (Site t : listFromExistingFile.getSiteReadings()) {
                    allReadings.add(t);
                }
            }
            //add all site readings from input json file to list
            if (listOfSites.getSiteReadings() != null) {
                for (Site t : listOfSites.getSiteReadings()) {
                    allReadings.add(t);
                }
            }
            listOfSites.setSiteReadings(allReadings);
            String json = gsonBuilder.toJson(listOfSites);
            writer.println(json);
            writer.close();

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        return listOfSites;
    }

}

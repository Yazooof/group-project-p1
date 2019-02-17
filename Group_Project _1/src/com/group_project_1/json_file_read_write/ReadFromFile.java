package com.group_project_1.json_file_read_write;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.group_project_1.collection.Readings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFromFile {

    Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();

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
}

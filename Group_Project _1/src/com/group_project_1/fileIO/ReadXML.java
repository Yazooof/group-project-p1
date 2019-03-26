package com.project.fileIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import com.project.Study.*;

/**
 *
 * @author Amadeus and Hassan
 */
public class ReadXML {

    public Study xmlRead(String path) {
        Study newStudy = new Study();
        try {
            //get document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // parses the XML file
            Document doc = builder.parse(new File(path));

            // normalizes the XML structure
            // creates the structure of the xml file and makes it so it's in
            // tangent and aligned
            doc.getDocumentElement().normalize();

            List<Reading> arrayReadings = new ArrayList<>();

            NodeList readings = doc.getElementsByTagName("Reading");

            // retrieves the readings
            for (int i = 0; i < readings.getLength(); i++) {
                // each reading data
                Node reading = readings.item(i);
                // outputs the reading name

                if (reading.getNodeType() == Node.ELEMENT_NODE) {
                    // casts element to reading and gets the attributes of the reading
                    Element eElement = (Element) reading;
                    // saves the categorical data/attributes


                    if (eElement.getElementsByTagName("Site").item(0) != null) {
                        String xmlSite = eElement.getElementsByTagName("Site").item(0).getTextContent();
                        String xmlType = eElement.getAttribute("type");
                        String xmlID = eElement.getAttribute("id");
                        String xmlValue = eElement.getElementsByTagName("Value").item(0).getTextContent();
                        Reading reading1 = new Reading(xmlSite, xmlType, xmlID, xmlValue);
                        arrayReadings.add(reading1);
                    }

                }
            }

            // retrieves the study from the document xml
            //NodeList studies = doc.getElementsByTagName("Study");
            Node study = doc.getElementsByTagName("Study").item(0);

            String readingStudy = study.getTextContent();
            Element eElement = (Element) study;

            ArrayList<Site> siteList = new ArrayList<>();

            for ( Reading reading : arrayReadings ) {
                if(reading.getSite_id() == null) {
                    System.out.println("Reading id missing");
                }else {


                    Site newSite = new Site(reading.getSite_id());
                    newSite.addReading(reading);

                    siteList.add(newSite);

                }

            }

            newStudy = new Study(eElement.getAttribute("id"), readingStudy ,
                            siteList);
            return newStudy;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newStudy;
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amadeus and Hassan
 */
public class XMLReader {

    public Study xmlRead() {
        Study newStudy = new Study();
        try {
            //get document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // parses the XML file
            Document doc = builder.parse(new File("example.xml"));

            // normalizes the XML structure
            // creates the structure of the xml file and makes it so it's in 
            // tangent and aligned
            doc.getDocumentElement().normalize();

            System.out.println("readingSet: " + doc.getDocumentElement().getNodeName());

            List<Site> arrayReadings = new ArrayList<>();

            NodeList readings = doc.getElementsByTagName("Reading");

            // retrieves the readings
            for (int i = 0; i < readings.getLength(); i++) {
                // each reading data
                Node reading = readings.item(i);
                // outputs the reading name
                System.out.println("\n current reading " + reading.getNodeName());
                if (reading.getNodeType() == Node.ELEMENT_NODE) {
                    // casts element to reading and gets the attributes of the reading
                    Element eElement = (Element) reading;
                    // saves the categorical data/attributes

                    //System.out.println(xmlSite);
                    if (eElement.getElementsByTagName("Site").item(0) != null) {
                        String xmlSite = eElement.getElementsByTagName("Site").item(0).getTextContent();
                        System.out.println(xmlSite);
                        String xmlType = eElement.getAttribute("type");
                        System.out.println(xmlType);
                        String xmlID = eElement.getAttribute("id");
                        System.out.println(xmlID);
                        String xmlValue = eElement.getAttribute("Value");
                        System.out.println(xmlValue);
                        Site site = new Site(xmlSite, xmlType, xmlID, xmlValue);
                        arrayReadings.add(site);
                    }

                    //System.out.println("type: " + eElement.getAttribute("type"));
                    //System.outprintln("reading id " + eElement.getAttribute("id"));
                }
            }

            // retrieves the study from the document xml
            //NodeList studies = doc.getElementsByTagName("Study");
            Node study = doc.getElementsByTagName("Study").item(0);
            //System.out.println(study.getTextContent());
            String readingStudy = study.getTextContent();
            Element eElement = (Element) study;
            newStudy = new Study(eElement.getAttribute("id"), readingStudy ,
                            arrayReadings);
            return newStudy;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newStudy;
    }

}

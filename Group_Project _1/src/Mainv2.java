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
import java.util.List;

/**
 *
 * @author Amadeus
 */
public class Mainv2 {
    public static void main(String[] args){
        /*try{
            
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
            
            // retrieves the study from the document xml
            NodeList study = doc.getElementsByTagName("Study");
            for(int j = 0; j < study.getLength(); j++){
                Node nNode = study.item(j);
                System.out.println("\nCurrent Element: " + nNode.getNodeName());
                if(nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;
                    System.out.println("study id " + eElement.getAttribute("id"));
                }
            }
            
            
            NodeList readings = doc.getElementsByTagName("Reading");
            
            // retrieves the readings
            for(int i = 0; i < readings.getLength(); i++){
                // each reading data
                Node reading = readings.item(i);
                // outputs the reading name
                System.out.println("\n current reading " + reading.getNodeName());
                if(reading.getNodeType() == Node.ELEMENT_NODE){
                    // casts element to reading and gets the attributes of the reading
                    Element eElement = (Element) reading;
                    // saves the categorical data/attributes
                    System.out.println("type: " + eElement.getAttribute("type"));
                    System.out.println("reading id " + eElement.getAttribute("id"));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }*/
        
        XMLReader reader = new XMLReader();
        Study study = reader.xmlRead();
        List<Site> sites = study.getReadings();
        //System.out.println("study name is: " + study.getStudyName());
        System.out.println(study.toString());
    }
    
}

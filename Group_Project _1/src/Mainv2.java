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

/**
 *
 * @author Amadeus
 */
public class Mainv2 {
    public static void main(String[] args){
        try{
            
            //get document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // parses the XML file
            Document doc = builder.parse(new File("example.xml"));
            
            // normalizes the XML structure
            doc.getDocumentElement().normalize();
            
            System.out.println("root: " + doc.getDocumentElement().getNodeName());
            
            NodeList study = doc.getElementsByTagName("Study");
            for(int j = 0; j < study.getLength(); j++){
                Node nNode = study.item(j);
                System.out.println("\nCurrent Element: " + nNode.getNodeName());
                if(nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;
                    System.out.println("study id " + eElement.getAttribute("id"));
                }
            }
            NodeList nList = doc.getElementsByTagName("Reading");
            
            for(int i = 0; i < nList.getLength(); i++){
                Node nNode = nList.item(i);
                System.out.println("\nCurrent Element: " + nNode.getNodeName());
                if(nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;
                    
                    System.out.println("type: " + eElement.getAttribute("type"));
                    System.out.println("reading id " + eElement.getAttribute("id"));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}

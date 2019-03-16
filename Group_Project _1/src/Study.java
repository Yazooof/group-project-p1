
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * this class is a study of readings
 * @author Amadeus
 */
public class Study {
    // study id
    private String studyID;
    
    // study name
    private String studyName;
    
    // readings are stored in a arraylist
    private List<Site> readings = new ArrayList<>();
    
    // default constructor
    public Study(){}
    
    // creating a study without readings
    public Study(String studyID){
        this.studyID = this.studyID;
    }
    
    // creating a study with reading
    public Study(String studyID, List<Site> readings){
        this.studyID = studyID;
        this.readings = readings;
    }
    
    // retrieving study
    public String getStudyID(){
        return studyID;
    }
    
    
    // if a study does not have readings then set it 
    public void setReadings(List<Site> readings){
        this.readings = readings;
    }
    
    // retrieving the readings
    public List<Site> getReadings(){
        return readings;
    }
    
    
    
    
    
    
    
}

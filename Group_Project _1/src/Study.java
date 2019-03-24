
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * this class is a study of readings
 *
 * @author Amadeus
 */
public class Study {

    // study id
    private String studyID;

    // study name
    private String studyName;

    // readings are stored in a arraylist
    private List<Site> readings = new ArrayList<>();

    public Study() {
    }

    // creating a study without readings
    public Study(String studyID, String studyName) {
        this.studyID = studyID;
        this.studyName = studyName;
    }

    // creating a study with reading
    public Study(String studyID, String studyName, List<Site> readings) {
        this.studyID = studyID;
        this.studyName = studyName;
        this.readings = readings;
    }

    // retrieve study name
    public String getStudyName() {
        return studyName;
    }

    // retrieving study
    public String getStudyID() {
        return studyID;
    }

    // if a study does not have readings then set it 
    public void setReadings(List<Site> readings) {
        this.readings = readings;
    }

    // retrieving the readings
    public List<Site> getReadings() {
        return readings;
    }

    @Override
    // creating string
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Study Name is: " + getStudyName() + "\n");
        sb.append("\n");
        //System.out.println(sb);
        for (int i = 0; i < getReadings().size(); i++) {
            sb.append(getReadings().get(i) + "\n");
        }
        return sb.toString();
    }

}

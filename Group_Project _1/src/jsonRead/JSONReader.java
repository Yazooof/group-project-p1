package jsonRead;



import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

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
    public Readings reader(File file) {
        Gson gson = new Gson();
        Readings listOfSites = null;
        try {
            // reader for json file
            BufferedReader reader = new BufferedReader(new FileReader(file));
            //creating an object of json file
            listOfSites = gson.fromJson(reader, Readings.class);
            // delete later used to just show the output of the sample json
            if (listOfSites != null) {
                for (Site t : listOfSites.getSiteReadings()) {
                    System.out.println(t.toString());
                }
            }
            reader.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        
        return listOfSites;
    }
    

}

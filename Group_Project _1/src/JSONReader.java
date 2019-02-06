
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: The reader for the json file
 *
 *
 * @author Amadeus
 */
public class JSONReader {

    public List<Site> reader() {
        Gson gson = new Gson();
        try {
            // reader for json file
            BufferedReader reader = new BufferedReader(new FileReader("example.json"));
            //creating an object of json file
            Readings sample = gson.fromJson(reader, Readings.class);
            // delete later used to just show the output of the sample json
            /*if (sample != null) {
                for (Site t : sample.getSiteReadings()) {
                    System.out.println(t.toString());
                }
            }*/
            reader.close();
            return sample.getSiteReadings();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void display() {
        if (reader() != null) {
            for (Site t : reader()) {
                System.out.println(t.toString());
            }
        }

    }
}

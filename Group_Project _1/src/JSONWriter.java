
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;



/**
 *
 * @author Amadeus
 */
public class JSONWriter {

    public void writeToJSON() {
        // reading from the reader
        JSONReader Jreader = new JSONReader();
        
        Readings reading = new Readings();
        // setting the layout of the json file
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Site site = writerInterface();
        // as you can see it's using the reader class 
        List<Site> siteReadings = Jreader.reader();
        // adding onto the arraylist of site objects
        siteReadings.add(site);
        // setting the site object
        reading.setSiteReadings(siteReadings);
        String json = gson.toJson(reading);
        try {
            FileWriter writer = new FileWriter("example.json");
            writer.write(json);
            writer.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public Site writerInterface() {
        Site site = new Site();
        Scanner stdin = new Scanner(System.in);
        String input = "";
        System.out.println("enter in site_id: ");
        input = stdin.nextLine();
        site.setSiteID(input);
        System.out.println("enter in reading_type: ");
        input = stdin.nextLine();
        site.setReadingType(input);
        System.out.println("enter in reading_id: ");
        input = stdin.nextLine();
        site.setReadingID(input);
        System.out.println("enter in reading_value: ");
        input = stdin.nextLine();
        site.setReadingValue(input);
        System.out.println("enter in reading_date: ");
        input = stdin.nextLine();
        site.setReadingDate(input);
        return site;
    }
}

package jsonRead;


import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Description: readings for all sites 
 * @author Amadeus
 */
public class Readings {
    // serializedname because site_readings is not the same as siteReadings
    // list for storing the sites. 
    @SerializedName("site_readings")
    private List<Site> siteReadings;

    public void setSiteReadings(List<Site> siteReadings) {
        this.siteReadings = siteReadings;
    }

    public List<Site> getSiteReadings() {
        return siteReadings;
    }
    
    
}

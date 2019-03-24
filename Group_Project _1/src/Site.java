
import com.google.gson.annotations.SerializedName;

/**
 * Description: the class for each site.
 *
 * @author Amadeus
 */
public class Site {

    // the names are changed in the field variables, therefore using serializedname to specify each variable
    @SerializedName("site_id")
    private String siteID;
    @SerializedName("reading_type")
    private String readingType;
    @SerializedName("reading_id")
    private String readingID;
    @SerializedName("reading_value")
    private String readingValue;
    @SerializedName("reading_date")
    private String readingDate;

    // optional
    private String unit;

    public Site() {
    }

    public Site(String siteID, String readingType, String readingID, String readingValue) {
        this.siteID = siteID;
        this.readingType = readingType;
        this.readingID = readingID;
        this.readingValue = readingValue;

    }

    public Site(String siteID, String readingType, String readingID, String readingValue, String readingDate) {
        this.siteID = siteID;
        this.readingType = readingType;
        this.readingID = readingID;
        this.readingValue = readingValue;
        this.readingDate = readingDate;
    }

    public Site(String siteID, String readingType, String readingID, String readingValue, String readingDate, String unit) {
        this.siteID = siteID;
        this.readingType = readingType;
        this.readingID = readingID;
        this.readingValue = readingValue;
        this.readingDate = readingDate;
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public String getSiteID() {
        return siteID;
    }

    public String getReadingType() {
        return readingType;
    }

    public String getReadingID() {
        return readingID;
    }

    public String getReadingValue() {
        return readingValue;
    }

    public String getReadingDate() {
        return readingDate;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public void setReadingType(String readingType) {
        this.readingType = readingType;
    }

    public void setReadingID(String readingID) {
        this.readingID = readingID;
    }

    public void setReadingValue(String readingValue) {
        this.readingValue = readingValue;
    }

    public void setReadingDate(String readingDate) {
        this.readingDate = readingDate;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("reading_type: " + getReadingType() + "\n");
        sb.append("site_id: " + getSiteID() + "\n");
        sb.append("reading_id: " + getReadingID() + "\n");
        sb.append("reading_value: " + getReadingValue() + "\n");
        sb.append("reading_date: " + getReadingDate() + "\n");
        return sb.toString();
    }
}

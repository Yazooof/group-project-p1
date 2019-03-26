package unitTests;


import static org.junit.Assert.*;

import org.junit.*;

import com.project.Study.*;

public class ReadingsTest {



    @Test
    public void testDate() {
        Reading read = new Reading();
        read.setReading_date("1234");
        assertEquals("1234", read.getReading_date());
    }
    @Test
    public void testID() {
        Reading read = new Reading();
        read.setReading_id("1234");
        assertEquals("1234", read.getReading_id());
    }
    @Test
    public void testType() {
        Reading read = new Reading();
        read.setReading_type("1234");
        assertEquals("1234", read.getReading_type());
    }
    @Test
    public void testValue() {
        Reading read = new Reading();
        read.setReading_value("1234");
        assertEquals("1234", read.getReading_value());
    }
    @Test
    public void testSiteID() {
        Reading read = new Reading();
        read.setSite_id("1");
        assertEquals("1", read.getSite_id());
    }

}

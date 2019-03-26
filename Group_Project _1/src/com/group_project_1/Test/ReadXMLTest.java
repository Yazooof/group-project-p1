package com.project.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import com.project.Study.*;
import com.project.fileIO.*;

/**
	test class for ReadXML, it needs the example.xml inorder to pass
	Author: Amadeus
*/

public class ReadXMLTest {

    @Test
    public void test() {
        ReadXML reader = new ReadXML();
        Study study = reader.xmlRead("example.xml");
        ArrayList<Site> sites = study.getSites();
        // testing the study to see if it contains study name and study attributes
        assertEquals("University of Science Environmental Study", study.getStudyName());
        assertEquals("485", study.getStudyID());
        assertEquals("15566", sites.get(0).getId());
        ArrayList<Reading> readings = sites.get(0).getReadings();
        // testing readings to see if it contains the readings attributes
        assertEquals("Temperature", readings.get(0).getReading_type());
        assertEquals("15dde", readings.get(0).getReading_id());
        assertEquals("102.6", readings.get(0).getReading_value());
    }

}

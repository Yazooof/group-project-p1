package com.project.Study;



/**
 * @author Andy
 *
 * Represents a single site's reading
 *
 */
public class Reading {

    private String reading_type;
    private String reading_id;
    private String reading_value;
    private String reading_date;
	private String site_id;



    /**
     * Empty constructor
     */
    public Reading() {
    	this.site_id = null;
        this.reading_type = null;
        this.reading_id = null;
        this.reading_value = null;
        this.reading_date = null;

    }

    /**
     * Simple constructor with all fields considered
     */
    public Reading(String site_id, String reading_type,  String reading_id, double reading_value, long reading_date) {
    	this.site_id = site_id;
        this.reading_type = reading_type;
        this.reading_id = reading_id;
        this.reading_value = String.valueOf(reading_value);
        this.reading_date = String.valueOf(reading_date);
    }

    public Reading(String site_id, String reading_type,  String reading_id, String reading_value) {
        this.site_id = site_id;
        this.reading_type = reading_type;
        this.reading_id = reading_id;
        this.reading_value = reading_value;

    }

    /**
     * Display reading data on screen
     */
    public String toString() {
        String ret = "";
        ret += String.format("site ID = %s\n", site_id);
        ret += String.format("type = %s\n", reading_type);
        ret += String.format("reading ID = %s\n", reading_id);
        ret += String.format("value = %s\n", reading_value);
        ret += String.format("date = %s\n", reading_date);
        ret += String.format("\n");
        return ret;
    }

    /**
     * Begin trivial getters and setters
     */
    /**
     * @return the reading_type
     */
    public String getReading_type() {
        return reading_type;
    }

    /**
     * @param reading_type the reading_type to set
     */
    public void setReading_type(String reading_type) {
        this.reading_type = reading_type;
    }

    /**
     * @return the reading_id
     */
    public String getReading_id() {
        return reading_id;
    }

    /**
     * @param reading_id the reading_id to set
     */
    public void setReading_id(String reading_id) {
        this.reading_id = reading_id;
    }

    /**
     * @return the reading_value
     */
    public String getReading_value() {
        return reading_value;
    }

    /**
     * @param reading_value the reading_value to set
     */
    public void setReading_value(String reading_value) {
        this.reading_value = reading_value;
    }

    /**
     * @return the reading_date
     */
    public String getReading_date() {
        return reading_date;
    }

    /**
     * @param reading_date the reading_date to set
     */
    public void setReading_date(String reading_date) {
        this.reading_date = reading_date;
    }

	public String getSite_id() {
		return site_id;
	}

	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}



}

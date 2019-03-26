package com.project.Study;



import java.util.*;

/**
 * @author Andy
 *
 * Simple class that models a data collection site
 */
public class Site {
	private String id;
	private boolean collecting;
	private ArrayList<Reading> readings;

	/**
	 * Basic constructor, by default it has no readings, and no collection has started
	 */
	public Site(String id) {
		this.id = id;
		this.collecting = true; // auto starts collecting when new site is added
		this.readings = new ArrayList<>();
	}

	/**
	 * Basic setters and getters
	 */

	public Site() {
    }

    /**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the collecting
	 */
	public boolean isCollecting() {
		return collecting;
	}
	/**
	 * @param collecting the collecting to set
	 */
	public void setCollecting(boolean collecting) {
		this.collecting = collecting;
	}
	/**
	 * @return the readings
	 */
	public ArrayList<Reading> getReadings() {
		return readings;
	}

	/**
	 * @param reading the reading to add
	 */
	public void addReading(Reading reading) {
		this.readings.add(reading);
	}



}

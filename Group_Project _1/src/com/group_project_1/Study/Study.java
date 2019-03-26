package com.project.Study;

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * this class is a study of readings
 * @author Amadeus
 */
public class Study {

    private String studyID;
    private String studyName;
    private ArrayList<Site> siteList = new ArrayList<>();

    public void addSite(Site site) {
    	siteList.add(site);
    }

    public Study() {

    }

    // creating a study without readings
    public Study(String studyID){
        this.studyID = this.studyID;
    }

    public Study(String studyID, String studyName, ArrayList<Site> siteList) {
        this.studyID = studyID;
        this.studyName = studyName;
        this.siteList = siteList;
    }

    // creating a study with reading
    public Study(String studyID, ArrayList<Site> readings){
        this.studyID = studyID;
        this.siteList = readings;
    }

    public Study (String studyID, String studyName) {
    	this.studyID = studyID;
    	this.studyName = studyName;
    }

    // retrieving study
    public String getStudyID(){
        return studyID;
    }


    // if a study does not have readings then set it
    public void setReadings(ArrayList<Site> readings){
        this.siteList = readings;
    }

    // retrieving the readings
    public ArrayList<Site> getSites(){
        return siteList;
    }

    public String getStudyName() {
    	return studyName;
    }


}
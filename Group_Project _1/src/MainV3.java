/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
/**
 * main class for jreader sample
 * @author Amadeus
 */
public class MainV3 {
    public static void main(String[] args){
        JReader jr = new JReader();
        List<Site> list = jr.reader();
        for(Site reading : list){
            System.out.println(reading.toString());
        }
        
    }
}

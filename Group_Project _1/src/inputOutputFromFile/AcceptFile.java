package inputOutputFromFile;

import java.io.File;
import javax.swing.JFileChooser;
import collection.*;
import jsonRead.*;
import inputOutputFromFile.*;

/**
 * Decription: Class that sets up the file chooser for the Gui to accept a file 
 * @author hassanmumin
 *
 */

public class AcceptFile {
	
	
	private JFileChooser fileChooser = new JFileChooser();
	
	/**
	 * returns a List of sites 
	 * @return
	 */
	public Readings chooseFile() {
		Readings listOfSites = null;
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			
			File addedFile = fileChooser.getSelectedFile();
			
			JSONReader Jreader = new JSONReader();
	        listOfSites = (Readings) Jreader.reader();
	        
		} else {
			System.out.println("No File picked/cancel button clicked");
		}
		
		return listOfSites;
	}
	
	

}

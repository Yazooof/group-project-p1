package inputOutputFromFile;

import java.io.File;

import javax.swing.JFileChooser;

import jsonRead.JSONReader;
import jsonRead.Readings;


/**
 * Decription: Class that sets us the file chooser for the Gui to accept a file 
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
	        listOfSites = Jreader.reader(addedFile);
	        
		} else {
			System.out.println("No File picked/cancel button clicked");
		}
		
		return listOfSites;
	}
	
	

}

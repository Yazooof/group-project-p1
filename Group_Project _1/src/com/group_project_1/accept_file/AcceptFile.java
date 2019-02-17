package com.group_project_1.accept_file;

import java.io.File;
import javax.swing.JFileChooser;



/**
 * Decription: Class that sets up the file chooser for the Gui to accept a file
 *
 * @author hassanmumin
 *
 */
public class AcceptFile {

    private JFileChooser fileChooser = new JFileChooser();

    /**
     * returns a List of sites
     *
     * @return
     */
    public File chooseFile() {
        File addedFile  = null;
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

        	addedFile = fileChooser.getSelectedFile();

           

        } else {
            System.out.println("No File picked/cancel button clicked");
        }

        return addedFile;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.fileIO;

import java.io.File;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class AcceptFileTest {
    AcceptFile instance;
    
    @Before
    public void setUp() {
        instance = new AcceptFile();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of chooseFile method, of class AcceptFile.
     */
    @Test
    public void testChooseFile() {
        System.out.println("chooseFile");
        File expResult = new File("/Users/rose/Dropbox/index2.html");
        File result = instance.chooseFile();
        assertEquals(expResult, result);
    }
    
}

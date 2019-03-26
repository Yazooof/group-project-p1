/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTests;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;

import com.project.fileIO.*;

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

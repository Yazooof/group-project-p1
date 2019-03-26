package unitTests;

import static org.junit.Assert.*;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;

import org.json.*;
import org.junit.*;
import org.junit.rules.*;

import com.project.Study.*;

/**
 *
 * @author hassanmumin
 *
 */

public class ReadWriteJSONTest {

    private FileWriter fileWriter;
    private Reading read1;
	private Reading read2;
	private Reading read3;
	private JSONObject jsonObj1;
	private JSONObject jsonObj2;
	private JSONObject jsonObj3;
	private JSONArray jsonArray;

	@Rule
    public TemporaryFolder folder = new TemporaryFolder();

	@Before
	public void setUp() throws Exception {

		jsonArray = new JSONArray();

		 read1 = new Reading("15566", "tempeture", "1a545", "56.0");
		 read2 = new Reading("3436", "particulate", "23Bn45", "354");
		 read3 = new Reading("5542", "bar_press", "000023m", "12");

		 jsonObj1 = new JSONObject(read1);
		 jsonObj2 = new JSONObject(read2);
		 jsonObj3 = new JSONObject(read3);

		 jsonArray.put(jsonObj1);
		 jsonArray.put(jsonObj2);
		 jsonArray.put(jsonObj3);
	}

	@Test
	public void testAddReadingAsJsonObjectToJsonArray1() {


		assertEquals(3, jsonArray.length());
		assertEquals(jsonObj2, jsonArray.get(1));
		assertFalse(jsonArray.isEmpty());
		assertEquals(JSONObject.class, jsonArray.get(2).getClass());
	}


	@Test
	public void testwritejsonObjectToFile1() throws Exception {


		JSONObject all = new JSONObject();
		all.put("site_readings", jsonArray);

        File outputFile = folder.newFile("testfile.txt");
        fileWriter = new FileWriter(outputFile, true);
        all.write(fileWriter);
        fileWriter.close();

        String fileContents = new String(Files.readAllBytes(outputFile.toPath()), StandardCharsets.UTF_8);


        assertFalse(outputFile.length() == 0);
        assertEquals(all.toString(), fileContents);

	}

	@Test
	public void testJsonFileBadlyFormatted2() throws Exception {
		JSONObject all = new JSONObject();
		all.put("site_readings", jsonArray);

		File outputFile = folder.newFile("testfile.txt");
        fileWriter = new FileWriter(outputFile, true);
        all.write(fileWriter);
        fileWriter.close();


        FileReader reader = new FileReader(outputFile);
        JSONTokener tokener = new JSONTokener(reader);
        JSONObject jsonFromFile = new JSONObject(tokener);

        assertFalse(jsonFromFile.isNull("site_readings"));

	}



}

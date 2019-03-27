
package unitTests;

import static org.junit.Assert.*;

import org.junit.*;

import com.project.Study.*;

public class StudyTest {

	@Test
	public void testID() {
	    Study study = new Study();

        assertTrue(study.getStudyID() == null);
    }

    @Test
    public void test1() {
    	Study study = new Study();

        study.getStudyName();
        assertTrue( study.getStudyName()==null);
    }

    @Test
    public void test2() {
    	Study study = new Study();

        assertFalse(study.getSites()==null);

    }








	}



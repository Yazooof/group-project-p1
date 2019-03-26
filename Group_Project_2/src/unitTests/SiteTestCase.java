package unitTests;


import static org.junit.Assert.*;

import org.junit.*;

import com.project.Study.*;

public class SiteTestCase {

    @Test
    public void test() {
        Site site = new Site();

        site.setId("5");
        assertEquals("5", site.getId());
    }

    @Test
    public void test1() {
        Site site = new Site();

        site.setCollecting(true);
        assertEquals(true, site.isCollecting());
    }

    @Test
    public void test2() {
        Site site = new Site();

        assertEquals(null, site.getId());

    }

    @Test
    public void test3() {
        Site site = new Site("15");

        assertEquals("15", site.getId());

    }







}

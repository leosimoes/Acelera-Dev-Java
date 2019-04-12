package challenge;

import java.io.IOException;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {

    public static Main m;

    @BeforeClass
    public static void initialize() throws IOException {
        MainTest.m = new Main();
    }

    @Test
    public void q1() throws Exception {
        assertNotEquals(0, m.q1());
    }

    @Test
    public void q2() throws Exception {
        assertNotEquals(0, m.q2());
    }

    @Test
    public void q3() throws Exception {
        List<String> result = m.q3();
        assertNotNull(result);
        assertEquals(20, result.size());
    }

    @Test
    public void q4() throws Exception {
        List<String> result = m.q4();
        assertNotNull(result);
        assertEquals(10, result.size());
    }

    @Test
    public void q5() throws Exception {
        List<String> result = m.q5();
        assertNotNull(result);
        assertEquals(10, result.size());
    }

    @Test
    public void q6() throws Exception {
        Map<Integer, Integer> result = m.q6();
        assertNotNull(result);
        assertNotEquals(0, result.size());
    }

}

package code.array.good;

import code.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 27/09/16.
 */
public class WindowStringTest extends BaseTest{
    WindowString windowString = new WindowString();
    @Test
    public void minWindow() throws Exception {
        String actualResult = windowString.minWindow("ADOBECODEBANC", "ABC");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals("BANC", actualResult);
    }

    @Test
    public void minWindow2() throws Exception {
        String actualResult = windowString.minWindow("w", "o");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals("", actualResult);
    }

}
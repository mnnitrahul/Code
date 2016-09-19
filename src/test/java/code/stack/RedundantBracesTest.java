package code.stack;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 18/09/16.
 */
public class RedundantBracesTest {
    @Rule
    public TestName name = new TestName();
    RedundantBraces redundantBraces = new RedundantBraces();

    @Test
    public void braces1() {
        int actualResult = redundantBraces.braces("");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);
    }

    @Test
    public void braces2() {
        int actualResult = redundantBraces.braces("(a)");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(1, actualResult);
    }

    @Test
    public void braces3() {
        int actualResult = redundantBraces.braces("((a + b))");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(1, actualResult);
    }

    @Test
    public void braces4() {
        int actualResult = redundantBraces.braces("(a + (a + b))");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);
    }


}
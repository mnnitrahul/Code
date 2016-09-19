package code.array.simple;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 16/09/16.
 */
public class SqrtTest {
    @Rule
    public TestName name = new TestName();
    Sqrt sqrt = new Sqrt();

    @Test
    public void test1() {
        int actualResult = sqrt.sqrt(9);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(3, actualResult);
    }

    @Test
    public void test2() {
        int actualResult = sqrt.sqrt(10);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(3, actualResult);
    }

}
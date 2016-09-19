package code.array.good;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 14/09/16.
 */
public class FirstMissingIntTest {
    @Rule
    public TestName name = new TestName();
    FirstMissingInt firstMissingInt = new FirstMissingInt();

    @Test
    public void test1() {

        int actualResult = firstMissingInt.firstMissingPositive(new ArrayList<>(Arrays.asList(1,2,0)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(3, actualResult);
    }



    @Test
    public void test2() {
        int actualResult = firstMissingInt.firstMissingPositive(new ArrayList<>(Arrays.asList(3,4,-1,1)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(2, actualResult);
    }

    @Test
    public void test3() {
        int actualResult = firstMissingInt.firstMissingPositive(new ArrayList<>(Arrays.asList(-8, -7, -6)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(1, actualResult);
    }

    @Test
    public void test4() {
        int actualResult = firstMissingInt.firstMissingPositive(new ArrayList<>(Arrays.asList(3, 1, 2)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(4, actualResult);
    }

    @Test
    public void test5() {
        int actualResult = firstMissingInt.firstMissingPositive(new ArrayList<>(Arrays.asList(1,0,3, -1, 2)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(4, actualResult);
    }

    @Test
    public void test6() {
        int actualResult = firstMissingInt.firstMissingPositive(new ArrayList<>(Arrays.asList(0)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(1, actualResult);
    }

    @Test
    public void test7() {
        int actualResult = firstMissingInt.firstMissingPositive(new ArrayList<>(Arrays.asList(-1)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(1, actualResult);
    }

    @Test
    public void test8() {
        int actualResult = firstMissingInt.firstMissingPositive(new ArrayList<>(Arrays.asList(2)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(1, actualResult);
    }

    @Test
    public void test9() {
        int actualResult = firstMissingInt.firstMissingPositive(new ArrayList<>(Arrays.asList(1)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(2, actualResult);
    }
}
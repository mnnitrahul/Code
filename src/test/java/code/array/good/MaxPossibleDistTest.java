package code.array.good;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 16/09/16.
 */
public class MaxPossibleDistTest {
    @Rule
    public TestName name = new TestName();
    private MaxPossibleDist maxPossibleDist = new MaxPossibleDist();

    @Test
    public void test1() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 5, 4, 2));
        int actualResult = maxPossibleDist.maximumGap(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(2, actualResult);
    }

    @Test
    public void test2() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3));
        int actualResult = maxPossibleDist.maximumGap(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);
    }

    @Test
    public void test3() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 2, 1));
        int actualResult = maxPossibleDist.maximumGap(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);
    }

    @Test
    public void test4() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(5, 1, 7, 4, 2));
        int actualResult = maxPossibleDist.maximumGap(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(3, actualResult);
    }

    @Test
    public void test5() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(5, 1, 7, 4, 2));
        int actualResult = maxPossibleDist.maximumGap(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(3, actualResult);
    }

}
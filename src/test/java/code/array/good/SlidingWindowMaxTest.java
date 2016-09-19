package code.array.good;

import code.BaseTest;
import code.array.common.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 19/09/16.
 */
public class SlidingWindowMaxTest extends BaseTest{

    SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
    @Test
    public void slidingMaximum1() throws Exception {
        List<Integer> actualResult = slidingWindowMax.slidingMaximum(new ArrayList<>(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7)), 3);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        List<Integer> result = new ArrayList<>(Arrays.asList(3, 3, 5, 5, 6, 7));
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

    @Test
    public void slidingMaximum2() throws Exception {
        List<Integer> actualResult = slidingWindowMax.slidingMaximum(new ArrayList<>(Arrays.asList(1, -1)), 3);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        List<Integer> result = new ArrayList<>(Arrays.asList(1));
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

    @Test
    public void slidingMaximum3() throws Exception {
        List<Integer> actualResult = slidingWindowMax.slidingMaximum(new ArrayList<>(Arrays.asList(5, 1, -1)), 3);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        List<Integer> result = new ArrayList<>(Arrays.asList(5));
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

}
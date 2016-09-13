package code.array.simple;

import code.array.good.MergeInterval;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 13/09/16.
 */
public class MaxNonNegativeSubArrayTest {

    @Rule
    public TestName name = new TestName();
    private MaxNonNegativeSubArray maxNonNegativeSubArray = new MaxNonNegativeSubArray();

    @Test
    public void testMaxNonNegativeSubArray1() {
        ArrayList<Integer> input =  new ArrayList(Arrays.asList(1, 2, 5, -7, 2, 3));
        List<Integer> result = new ArrayList(Arrays.asList(1, 2, 5));
        List<Integer> actualResult = maxNonNegativeSubArray.maxset(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

    @Test
    public void testMaxNonNegativeSubArray2() {
        ArrayList<Integer> input =  new ArrayList(Arrays.asList( 0, 0, -1, 0));
        List<Integer> result = new ArrayList(Arrays.asList(0, 0));
        List<Integer> actualResult = maxNonNegativeSubArray.maxset(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

    @Test
    public void testMaxNonNegativeSubArray3() {
        ArrayList<Integer> input =  new ArrayList(Arrays.asList( 1967513926, 1540383426, -1303455736, -521595368));
        List<Integer> result = new ArrayList(Arrays.asList(1967513926, 1540383426));
        List<Integer> actualResult = maxNonNegativeSubArray.maxset(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

    @Test
    public void testMaxNonNegativeSubArray4() {
        ArrayList<Integer> input =  new ArrayList(Arrays.asList( 756898537, -1973594324, -2038664370, -184803526, 1424268980));
        List<Integer> result = new ArrayList(Arrays.asList(1424268980));
        List<Integer> actualResult = maxNonNegativeSubArray.maxset(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

}
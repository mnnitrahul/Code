package code.array.simple;

import code.BaseTest;
import code.array.good.CombinationSum;
import code.array.good.CombinationSumNoRepeat;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by rahul.ka on 26/09/16.
 */
public class CombinationSumNoRepeatTest extends BaseTest{
    @Test
    public void combinationSum() throws Exception {
        CombinationSumNoRepeat combinationSum = new CombinationSumNoRepeat();
        ArrayList<ArrayList<Integer>> actualResult = combinationSum.combinationSum(new ArrayList<Integer>(Arrays.asList(2,2, 3,7,7)), 7);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(2, 2, 3)));
        result.add(new ArrayList<>(Arrays.asList(7)));
        assertArrayEquals(result.toArray(), actualResult.toArray());

    }

    @Test
    public void combinationSum2() throws Exception {
        CombinationSumNoRepeat combinationSum = new CombinationSumNoRepeat();
        ArrayList<ArrayList<Integer>> actualResult = combinationSum.combinationSum(new ArrayList<Integer>(Arrays.asList( 8, 10, 6, 11, 1, 16, 8)), 28);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1, 6, 10, 11)));
        result.add(new ArrayList<>(Arrays.asList(1, 8, 8, 11)));
        result.add(new ArrayList<>(Arrays.asList(1, 11, 16)));
        assertArrayEquals(result.toArray(), actualResult.toArray());

    }

}
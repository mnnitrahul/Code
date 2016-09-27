package code.array.simple;

import code.BaseTest;
import code.array.good.CombinationSum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
/**
 * Created by rahul.ka on 26/09/16.
 */
public class CombinationSumTest extends BaseTest{
    @Test
    public void combinationSum() throws Exception {
        CombinationSum combinationSum = new CombinationSum();
        ArrayList<ArrayList<Integer>> actualResult = combinationSum.combinationSum(new ArrayList<Integer>(Arrays.asList(2,3,7,7)), 7);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(2, 2, 3)));
        result.add(new ArrayList<>(Arrays.asList(7)));
        assertArrayEquals(result.toArray(), actualResult.toArray());

    }

}
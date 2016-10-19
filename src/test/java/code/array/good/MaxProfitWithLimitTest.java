package code.array.good;

import code.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 16/10/16.
 */
public class MaxProfitWithLimitTest extends BaseTest{
    MaxProfitWithLimit maxProfitWithLimit = new MaxProfitWithLimit();
    @Test
    public void maxProfit() throws Exception {
        int actualResult = maxProfitWithLimit.maxProfit(new ArrayList<>(Arrays.asList(1, 2, 1, 2)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(2, actualResult);

    }

    @Test
    public void maxProfit2() throws Exception {
        int actualResult = maxProfitWithLimit.maxProfit(new ArrayList<>(Arrays.asList()));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);

    }

    @Test
    public void maxProfit3() throws Exception {
        int actualResult = maxProfitWithLimit.maxProfit(new ArrayList<>(Arrays.asList(1)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);

    }
    @Test
    public void maxProfit4() throws Exception {
        int actualResult = maxProfitWithLimit.maxProfit(new ArrayList<>(Arrays.asList(1, 3)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(2, actualResult);

    }

}
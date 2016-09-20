package code.array.algo;

import code.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 20/09/16.
 */
public class RainWaterTrappedTest extends BaseTest{
    RainWaterTrapped rainWaterTrapped = new RainWaterTrapped();
    @Test
    public void trap1() throws Exception {
        int actualResult = rainWaterTrapped.trap(new ArrayList<>(Arrays.asList(0, 0)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);
    }

    @Test
    public void trap2() throws Exception {
        int actualResult = rainWaterTrapped.trap(new ArrayList<>(Arrays.asList(0)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);
    }

    @Test
    public void trap3() throws Exception {
        int actualResult = rainWaterTrapped.trap(new ArrayList<>(Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(6, actualResult);
    }

}
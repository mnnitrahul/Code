package code.array.good;

import code.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 20/09/16.
 */
public class RectangleInHistrogramTest extends BaseTest {
    RectangleInHistrogram rectangleInHistrogram = new RectangleInHistrogram();
    @Test
    public void largestRectangleArea1() throws Exception {
        int actualResult = rectangleInHistrogram.largestRectangleArea(new ArrayList<>(Arrays.asList(2,1,5,6,2,3)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(10, actualResult);
    }

    @Test
    public void largestRectangleArea2() throws Exception {
        int actualResult = rectangleInHistrogram.largestRectangleArea(new ArrayList<>(Arrays.asList(0, 0)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);
    }

    @Test
    public void largestRectangleArea3() throws Exception {
        int actualResult = rectangleInHistrogram.largestRectangleArea(new ArrayList<>(Arrays.asList(2, 2, 2)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(6, actualResult);
    }

}
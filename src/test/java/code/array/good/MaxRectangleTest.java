package code.array.good;

import code.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 17/10/16.
 */
public class MaxRectangleTest extends BaseTest{
    MaxRectangle maxRectangle = new MaxRectangle();
    @Test
    public void maximalRectangle() throws Exception {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> row1= new ArrayList<>(Arrays.asList(1, 1, 1));
        ArrayList<Integer> row2= new ArrayList<>(Arrays.asList(0, 1, 1));
        ArrayList<Integer> row3= new ArrayList<>(Arrays.asList(1, 0, 0));
        input.add(row1);
        input.add(row2);
        input.add(row3);
        int actualResult = maxRectangle.maximalRectangle(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(4, actualResult);
    }

}
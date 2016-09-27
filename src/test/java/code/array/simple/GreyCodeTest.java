package code.array.simple;

import code.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 26/09/16.
 */
public class GreyCodeTest extends BaseTest{
    @Test
    public void grayCode() throws Exception {
        GreyCode greyCode = new GreyCode();
        ArrayList<Integer> actualResult = greyCode.grayCode(1);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 1));
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

    @Test
    public void grayCode2() throws Exception {
        GreyCode greyCode = new GreyCode();
        ArrayList<Integer> actualResult = greyCode.grayCode(2);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 1, 3, 2));
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

}
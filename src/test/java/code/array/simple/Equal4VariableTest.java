package code.array.simple;

import code.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 27/09/16.
 */
public class Equal4VariableTest extends BaseTest{
    Equal4Variable equal4Variable = new Equal4Variable();
    @Test
    public void equal() throws Exception {
        ArrayList<Integer> actualResult = equal4Variable.equal(new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 2, 3, 5));
        assertArrayEquals(result.toArray(), actualResult.toArray());

    }

    @Test
    public void equal2() throws Exception {
        ArrayList<Integer> actualResult = equal4Variable.equal(new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 11)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 2, 3, 5));
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

    @Test
    public void equal3() throws Exception {
        ArrayList<Integer> actualResult = equal4Variable.equal(new ArrayList<>(Arrays.asList(3, 14, 7, 1, 2, 25, 11)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        ArrayList<Integer> result = new ArrayList<>();
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

    @Test
    public void equal4() throws Exception {
        ArrayList<Integer> actualResult = equal4Variable.equal(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

}
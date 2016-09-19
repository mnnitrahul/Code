package code.array.medium;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 15/09/16.
 */
public class PascalTriangleTest {
    @Rule
    public TestName name = new TestName();
    PascalTriangle pascalTriangle = new PascalTriangle();

    @Test
    public void test1() {
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>(Arrays.asList(1));
        expected.add(row);
        row = new ArrayList<>(Arrays.asList(1, 1));
        expected.add(row);
        row = new ArrayList<>(Arrays.asList(1, 2, 1));
        expected.add(row);
        row = new ArrayList<>(Arrays.asList(1, 3, 3, 1));
        expected.add(row);
        row = new ArrayList<>(Arrays.asList(1,4,6,4,1));
        expected.add(row);
        ArrayList<ArrayList<Integer>> result = pascalTriangle.generate(5);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void test2() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,3,3,1));
        ArrayList<Integer> result = pascalTriangle.getRow(3);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void test3() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,1));
        ArrayList<Integer> result = pascalTriangle.getRow(1);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void test4() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> result = pascalTriangle.getRow(0);
        System.out.println("Result (" + name.getMethodName() + ") : " + result);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

}
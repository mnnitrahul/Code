package code.binary.matrix;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 16/09/16.
 */
public class MatrixSearchTest {
    @Rule
    public TestName name = new TestName();
    MatrixSearch matrixSearch = new MatrixSearch();

    @Test
    public void test1() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1,   3,  5,  7)));
        input.add(new ArrayList<>(Arrays.asList(10, 11, 16, 20)));
        input.add(new ArrayList<>(Arrays.asList(23, 30, 34, 50)));
        int actualResult = matrixSearch.searchMatrix(input, 3);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(1, actualResult);
    }

    @Test
    public void test2() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1,   3,  5,  7)));
        input.add(new ArrayList<>(Arrays.asList(10, 11, 16, 20)));
        input.add(new ArrayList<>(Arrays.asList(23, 30, 34, 50)));
        int actualResult = matrixSearch.searchMatrix(input, 10);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(1, actualResult);
    }

    @Test
    public void test3() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1,   3,  5,  7)));
        int actualResult = matrixSearch.searchMatrix(input, 5);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(1, actualResult);
    }

    @Test
    public void test4() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1)));
        input.add(new ArrayList<>(Arrays.asList(10)));
        input.add(new ArrayList<>(Arrays.asList(23)));
        int actualResult = matrixSearch.searchMatrix(input, 10);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(1, actualResult);
    }

    @Test
    public void test5() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1)));
        input.add(new ArrayList<>(Arrays.asList(10)));
        input.add(new ArrayList<>(Arrays.asList(23)));
        int actualResult = matrixSearch.searchMatrix(input, 3);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);
    }

    @Test
    public void test6() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(3)));
        input.add(new ArrayList<>(Arrays.asList(29)));
        input.add(new ArrayList<>(Arrays.asList(36)));
        input.add(new ArrayList<>(Arrays.asList(63)));
        input.add(new ArrayList<>(Arrays.asList(67)));
        input.add(new ArrayList<>(Arrays.asList(72)));
        input.add(new ArrayList<>(Arrays.asList(74)));
        input.add(new ArrayList<>(Arrays.asList(78)));
        input.add(new ArrayList<>(Arrays.asList(85)));
        int actualResult = matrixSearch.searchMatrix(input, 41);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);
    }

    @Test
    public void test7() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(2,   3,  5,  7)));
        int actualResult = matrixSearch.searchMatrix(input, 1);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(0, actualResult);
    }

    @Test
    public void test8() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1)));
        input.add(new ArrayList<>(Arrays.asList(11)));
        input.add(new ArrayList<>(Arrays.asList(49)));
        input.add(new ArrayList<>(Arrays.asList(74)));
        input.add(new ArrayList<>(Arrays.asList(77)));
        input.add(new ArrayList<>(Arrays.asList(78)));
        input.add(new ArrayList<>(Arrays.asList(93)));
        input.add(new ArrayList<>(Arrays.asList(94)));
        int actualResult = matrixSearch.searchMatrix(input, 49);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(1, actualResult);
    }



}
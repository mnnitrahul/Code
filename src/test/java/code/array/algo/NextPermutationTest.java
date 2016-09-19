package code.array.algo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 15/09/16.
 */
public class NextPermutationTest {

    @Rule
    public TestName name = new TestName();
    NextPermutation nextPermutation = new NextPermutation();

    @Test
    public void test1() throws Exception {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        nextPermutation.nextPermutation(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + input);
        ArrayList<Integer> actualResult = new ArrayList<>(Arrays.asList(1, 3, 2));
        assertArrayEquals(input.toArray(), actualResult.toArray());
    }

    @Test
    public void test2() throws Exception {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        nextPermutation.nextPermutation(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + input);
        ArrayList<Integer> actualResult = new ArrayList<>(Arrays.asList(1, 3, 2));
        assertArrayEquals(input.toArray(), actualResult.toArray());
    }

    @Test
    public void test3() throws Exception {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 2, 1));
        nextPermutation.nextPermutation(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + input);
        ArrayList<Integer> actualResult = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertArrayEquals(input.toArray(), actualResult.toArray());
    }

    @Test
    public void test4() throws Exception {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 1, 5));
        nextPermutation.nextPermutation(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + input);
        ArrayList<Integer> actualResult = new ArrayList<>(Arrays.asList(1, 5, 1));
        assertArrayEquals(input.toArray(), actualResult.toArray());
    }

    @Test
    public void test5() throws Exception {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1));
        nextPermutation.nextPermutation(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + input);
        ArrayList<Integer> actualResult = new ArrayList<>(Arrays.asList(1));
        assertArrayEquals(input.toArray(), actualResult.toArray());
    }

    @Test
    public void test6() throws Exception {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(2, 3, 1));
        nextPermutation.nextPermutation(input);
        System.out.println("Result (" + name.getMethodName() + ") : " + input);
        ArrayList<Integer> actualResult = new ArrayList<>(Arrays.asList(3, 1, 2));
        assertArrayEquals(input.toArray(), actualResult.toArray());
    }

}
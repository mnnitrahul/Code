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
public class FindPermutationTest {

    @Rule
    public TestName name = new TestName();
    FindPermutation findPermutation = new FindPermutation();

    @Test
    public void findPerm1() throws Exception {
        ArrayList<Integer> actualResult = findPermutation.findPerm("DIDD", 5);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(new ArrayList<Integer>(Arrays.asList(5, 1, 4, 3, 2)), actualResult);
    }

    @Test
    public void findPerm2() throws Exception {
        ArrayList<Integer> actualResult = findPermutation.findPerm("D", 2);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(new ArrayList<Integer>(Arrays.asList(2, 1)), actualResult);
    }

    @Test
    public void findPerm3() throws Exception {
        ArrayList<Integer> actualResult = findPermutation.findPerm("", 1);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(new ArrayList<Integer>(Arrays.asList(1)), actualResult);
    }

}
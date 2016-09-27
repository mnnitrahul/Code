package code.array.simple;

import code.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 26/09/16.
 */
public class PermutationTest extends BaseTest{
    @Test
    public void getPermutation() throws Exception {
        Permutation permutation = new Permutation();
        String actualResult = permutation.getPermutation(3, 4);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals("231", actualResult);
    }

}
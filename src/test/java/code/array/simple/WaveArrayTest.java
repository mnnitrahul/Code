package code.array.simple;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 15/09/16.
 */
public class WaveArrayTest {
    @Rule
    public TestName name = new TestName();
    WaveArray waveArray = new WaveArray();

    @Test
    public void test1() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> actualResult = waveArray.wave(input);
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(2, 1, 4, 3));
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

}
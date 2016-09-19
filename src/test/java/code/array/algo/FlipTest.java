package code.array.algo;

import code.array.common.Interval;
import code.array.good.MergeInterval;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 14/09/16.
 */
public class FlipTest {

    @Rule
    public TestName name = new TestName();
    private Flip flip = new Flip();

    @Test
    public void testFlip1() {
        ArrayList<Interval> result = new ArrayList(Arrays.asList(1, 1));
        List<Integer> actualResult = flip.flip("010");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

    @Test
    public void testFlip2() {
        ArrayList<Interval> result = new ArrayList();
        List<Integer> actualResult = flip.flip("111");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

    @Test
    public void testFlip3() {
        ArrayList<Interval> result = new ArrayList(Arrays.asList(1, 3));
        List<Integer> actualResult = flip.flip("000");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

    @Test
    public void testFlip4() {
        ArrayList<Interval> result = new ArrayList(Arrays.asList(1, 1));
        List<Integer> actualResult = flip.flip("0");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

    @Test
    public void testFlip5() {
        ArrayList<Interval> result = new ArrayList(Arrays.asList(1, 1));
        List<Integer> actualResult = flip.flip("011");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

    @Test
    public void testFlip6() {
        ArrayList<Interval> result = new ArrayList(Arrays.asList(3, 9));
        List<Integer> actualResult = flip.flip("1101010001");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }
}
package code.array.good;

import code.array.common.Interval;
import code.array.good.MergeInterval;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 12/09/16.
 */
public class MergeIntervalTest {

    @Rule
    public TestName name = new TestName();
    private MergeInterval mergeIntervalTest = new MergeInterval();
    private ArrayList<Interval> intervals = new ArrayList();
    private Interval interval;

    @Test
    public void testMinStepsInGrid() {
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(6,9));
        interval = new Interval(2,5);
        ArrayList<Interval> result = new ArrayList<>();
        result.add(new Interval(1,5));
        result.add(new Interval(6,9));
        List<Interval> actualResult = mergeIntervalTest.insert(intervals, interval);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }
    @Test
    public void testMinStepsInGrid2() {
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
        interval = new Interval(4,9);
        ArrayList<Interval> result = new ArrayList<>();
        result.add(new Interval(1,2));
        result.add(new Interval(3,10));
        result.add(new Interval(12,16));
        List<Interval> actualResult = mergeIntervalTest.insert(intervals, interval);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(result.toArray(),actualResult.toArray());
    }

    @Test
    public void testMinStepsInGrid3() {
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,6));
        interval = new Interval(10,8);
        ArrayList<Interval> result = new ArrayList<>();
        result.add(new Interval(1,2));
        result.add(new Interval(3,6));
        result.add(new Interval(8,10));
        List<Interval> actualResult = mergeIntervalTest.insert(intervals, interval);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(result.toArray(),actualResult.toArray());
    }

    @Test
    public void testMinStepsInGrid4() {
        interval = new Interval(1,1);
        ArrayList<Interval> result = new ArrayList<>();
        result.add(new Interval(1,1));
        List<Interval> actualResult = mergeIntervalTest.insert(intervals, interval);
        System.out.println("actual result " + actualResult);
        assertArrayEquals(result.toArray(),actualResult.toArray());
    }



}
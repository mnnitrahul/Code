package code.array.good;

import code.array.common.Interval;
import code.array.medium.MergeOverlappingInterval;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 13/09/16.
 */
public class MergeOverlappingIntervalTest {

    @Rule
    public TestName name = new TestName();
    private MergeOverlappingInterval mergeOverMergeInterval = new MergeOverlappingInterval();
    private ArrayList<Interval> intervals = new ArrayList();

    @Test
    public void testMerge() {
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        ArrayList<Interval> result = new ArrayList<>();
        result.add(new Interval(1,6));
        result.add(new Interval(8,10));
        result.add(new Interval(15,18));
        List<Interval> actualResult = mergeOverMergeInterval.merge(intervals);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(result.toArray(), actualResult.toArray());
    }

}
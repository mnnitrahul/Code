package code.array.medium;


import code.array.common.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 *https://www.interviewbit.com/problems/merge-overlapping-intervals/
 * Assumption : All range are in integers
 * Comparator in Collections.sort function and implement comparable in Interval class
 *
 */

/**
 * Created by rahul.ka on 12/09/16.
 */

public class MergeOverlappingInterval {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) return -1;
                if (o1.start > o2.start) return 1;
                return 0;
            }
        });
        ArrayList<Interval> result = new ArrayList<>();
        Interval lastInterval = null;
        for (Interval interval : intervals) {
            if (lastInterval == null) {
                lastInterval = interval;
                continue;
            }
            if (lastInterval.end  < interval.start) {
                result.add(lastInterval);
                lastInterval = interval;
                continue;
            }
            lastInterval.end = Math.max(lastInterval.end, interval.end);
        }
        result.add(lastInterval);
        return result;
    }

}

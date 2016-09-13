package code.array.good;


import code.array.common.Interval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/merge-intervals/
 * Assumption : All range are in integers and sorted
 * Multiple If condition and use same Iterator in multiple loop
 */

/**
 * Created by rahul.ka on 12/09/16.
 */

public class MergeInterval {


    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Interval toBeInserted = new Interval(Math.min(newInterval.start, newInterval.end), Math.max(newInterval.start, newInterval.end));
        ArrayList<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }
        Iterator<Interval> iter = intervals.iterator();
        Interval i = null;
        while (iter.hasNext()) {
             i = iter.next();
             if (i.end >= toBeInserted.start) {
                break;
             }
             result.add(i);
        }
        if(toBeInserted.start > i.end) { // Insert in last
            result.add(toBeInserted);
            return result;
        }
        if (toBeInserted.end < i.start) {  // Insert first
            result.add(toBeInserted);
            result.add(i);
            iter.forEachRemaining(interval -> result.add(interval));
            return result;
        }
        int start = Math.min(toBeInserted.start, i.start);
        if (i.end < toBeInserted.end) {
            while (iter.hasNext()) {
                i = iter.next();
                if (i.end> toBeInserted.end) {
                    break;
                }

            }
        }
        if (toBeInserted.end < i.start) { //inserted before i
            result.add(new Interval(start, toBeInserted.end));
            result.add(i);
            iter.forEachRemaining(interval ->  result.add(interval));
            return result;
        }
        int end = Math.max(i.end, toBeInserted.end);
        result.add(new Interval(start, end));
        iter.forEachRemaining(interval -> result.add(interval));
        return result;
    }

}

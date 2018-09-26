package code.array.good;

import java.util.*;
/**
 * https://www.interviewbit.com/problems/max-distance/
 */

/**
 * Created by rahul.ka on 16/09/16.
 */
public class MaxPossibleDist {

    public int maximumGap(final List<Integer> a) {
        List<Map.Entry<Integer, Integer>> increasingFromLast = new ArrayList<>();
        Integer biggest = a.get(a.size()-1);
        increasingFromLast.add(new AbstractMap.SimpleEntry(biggest, a.size()-1));
        for (int i = a.size()-2;i >=0;--i) {
            if (a.get(i) > biggest) {
                biggest = a.get(i);
                increasingFromLast.add(new AbstractMap.SimpleEntry(biggest, i));
            }
        }
        Collections.reverse(increasingFromLast);

        List<Map.Entry<Integer, Integer>> decreasingFromStart = new ArrayList<>();
        Integer smaller = a.get(0);
        decreasingFromStart.add(new AbstractMap.SimpleEntry(smaller, 0));
        for (int i = 1;i < a.size();++i) {
            if(a.get(i) < smaller) {
                smaller = a.get(i);
                decreasingFromStart.add(new AbstractMap.SimpleEntry(smaller, i));
            }
        }
        int start = 0;
        int dist = 0;
        int end = 0;

        while (start < decreasingFromStart.size() &&
                end < increasingFromLast.size()) {
            Map.Entry<Integer, Integer> startEntry = decreasingFromStart.get(start);
            Map.Entry<Integer, Integer> endEntry = increasingFromLast.get(end);
            if (startEntry.getValue() > endEntry.getValue()) {
                end++;
                continue;
            }
            if (startEntry.getKey() > endEntry.getKey()) {
                start++;
                continue;
            }
            if ((endEntry.getValue()-startEntry.getValue()) > dist) {
                dist = endEntry.getValue() - startEntry.getValue();
            }
            end++;
        }
        return dist;

    }
}

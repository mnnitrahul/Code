package code.array.good;

import java.util.*;

/**
 * From <http://tech-queries.blogspot.in/2011/03/maximum-area-rectangle-in-histogram.html>
   https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
 */

/**
 * Created by rahul.ka on 20/09/16.
 */
public class RectangleInHistrogram {
    private List<Integer> findArea(ArrayList<Integer> a) {
        Stack<Map.Entry<Integer, Integer>> s = new Stack<>();
        s.push(new AbstractMap.SimpleEntry<Integer, Integer>(-1, -1));
        List<Integer> area = new ArrayList<>();
        int index = 0;
        for (int i : a) {
            while (s.peek().getValue() >= i) {
                s.pop();
            }
            area.add(index-s.peek().getKey());
         //   System.out.println("index: " + index + " value: " + i + " stack index: " + s.peek().getKey() + " stack value: " + s.peek().getValue() + " maxRect: " + (index-s.peek().getKey()));
            s.push(new AbstractMap.SimpleEntry(index, i));
            index++;
        //    System.out.println("stack: " + s);
        }
        return area;
    }
    public int largestRectangleArea(ArrayList<Integer> a) {


        int maxRect = 0;
        List<Integer> left = findArea(a);
        Collections.reverse(a);
        List<Integer> right = findArea(a);
        Collections.reverse(a);
        Collections.reverse(right);
        Iterator<Integer> leftItr = left.iterator();
        Iterator<Integer> rightItr = right.iterator();
        Iterator<Integer> aItr = a.iterator();
        while (leftItr.hasNext()){
            int leftValue = leftItr.next();
            int rightValue = rightItr.next();
            int value = aItr.next();
            if ((rightValue+leftValue-1)* value > maxRect) {
                maxRect = (rightValue+leftValue-1)* value;
            }
        }
        return maxRect;
    }
}

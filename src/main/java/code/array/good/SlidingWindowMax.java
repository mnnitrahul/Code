package code.array.good;

/**
 * https://www.interviewbit.com/problems/sliding-window-max/
 */

import java.util.*;

import static java.awt.SystemColor.window;

/**
 * Created by rahul.ka on 19/09/16.
 */
public class SlidingWindowMax {

    private void addElement(Deque<Map.Entry<Integer, Integer>> window, List<Integer> a, int index) {
        int num = a.get(index);
        while (window.size() > 0 && window.peek().getValue() <= num) {
            window.removeFirst();
        }
        window.addFirst(new AbstractMap.SimpleEntry<Integer, Integer>(index, num));
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        Deque<Map.Entry<Integer, Integer>> window = new ArrayDeque<>();
        while(index < b && index < a.size()) {
            addElement(window,a, index);
            index++;
        }
//        System.out.println("starting window is " + window);
        result.add(window.getLast().getValue());
        while (index < a.size()) {
            if (window.getLast().getKey() <= (index-b)) {
                window.removeLast();
            }
            addElement(window,a, index);
//            System.out.println("window is " + window);
            result.add(window.getLast().getValue());
            index++;
        }
        return result;
    }
}

package code.array.simple;

/**
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by rahul.ka on 12/09/16.
 */
public class MinStepsInGrid {
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int lastX = 0;
        int lastY = 0;
        Iterator<Integer> xItr = X.iterator();
        Iterator<Integer> yItr= X.iterator();
        int count = 0;
        while ((xItr.hasNext() && yItr.hasNext())) {
            int newX = xItr.next();
            int newY = yItr.next();
            count += Math.abs(Math.max(newX, newY)- Math.min(lastX, lastY));
            lastX = newX;
            lastY = newY;
        }
        return count;


    }
}

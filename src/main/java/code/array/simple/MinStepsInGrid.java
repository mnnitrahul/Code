package code.array.simple;

/**
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 * Uses Iterator to iterate 2 ArrayList simultaneously
 */

import java.util.ArrayList;
import java.util.Iterator;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

/**
 * Created by rahul.ka on 12/09/16.
 */
public class MinStepsInGrid {
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        if (X == null || Y == null) {
            return 0;
        }
        Iterator<Integer> xItr = X.iterator();
        Iterator<Integer> yItr= Y.iterator();
        if (!xItr.hasNext() || !yItr.hasNext()) {
            return 0;
        }
        int lastX = xItr.next();
        int lastY = yItr.next();
        int count = 0;
        while ((xItr.hasNext() && yItr.hasNext())) {
            int newX = xItr.next();
            int newY = yItr.next();
            count += Math.max(Math.abs(newX-lastX), Math.abs(newY-lastY));
            lastX = newX;
            lastY = newY;
        }
        return count;
    }
}

package code.array.algo;

import java.util.List;

/**
 * Created by rahul.ka on 20/09/16.
 */
public class RainWaterTrapped {

    public int trap(final List<Integer> a) {
        int start = 0;
        int end = a.size()-1;
        int sum = 0;
        int leftMax = a.get(start);
        int rightMax = a.get(a.size()-1);
        while(start < end) {
            if (a.get(start) <= a.get(end)) {
                if (a.get(start) >= leftMax) leftMax = a.get(start);
                else sum += leftMax-a.get(start);
                start++;
            } else {
                if (a.get(end) >= rightMax) rightMax = a.get(end);
                else  sum += rightMax-a.get(end);
                end--;
            }
        }
        return sum;

    }
}

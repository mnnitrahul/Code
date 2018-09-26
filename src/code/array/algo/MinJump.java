package code.array.algo;

import java.util.ArrayList;
import java.util.jar.Pack200;

/**
 * Created by rahul.ka on 16/10/16.
 * https://www.interviewbit.com/problems/min-jumps-array/
 */
public class MinJump {
    public int jump(ArrayList<Integer> a) {
        int maxDistPossible = a.get(0);
        int maxFromNow = a.get(0);
        int count = 1;
        if (a.size() == 1) {
            return 0;
        }
        for (int i = 1; i <= maxDistPossible; ++i) {
            if (i == a.size()-1) return count;
            maxDistPossible = Math.max(maxDistPossible, i+a.get(i));
            if (i == maxFromNow) {
                maxFromNow = maxDistPossible;
                count++;
            }
        }
        return -1;
    }
}

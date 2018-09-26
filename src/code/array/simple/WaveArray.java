package code.array.simple;

import java.util.ArrayList;
import java.util.Collections;
/**
 * https://www.interviewbit.com/problems/wave-array/
 */

/**
 * Created by rahul.ka on 15/09/16.
 */
public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        for (int i = 1; i < a.size();) {
            int tmp = a.get(i);
            a.set(i, a.get(i-1));
            a.set(i-1, tmp);
            i += 2;
        }
        return a;
    }
}

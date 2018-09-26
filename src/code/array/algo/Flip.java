package code.array.algo;

/**
 * https://www.interviewbit.com/problems/flip/
 * Variation of Kadane
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by rahul.ka on 14/09/16.
 */
public class Flip {

    public ArrayList<Integer> flip(String A) {
        int sum = 0;
        int startIndex = 0;
        int endIndex = 0;
        int tmpSum = 0;
        int tmpStartIndex = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int index = -1;
        for (Character c : A.toCharArray()) {
            index++;
            if (c == '0') {
                tmpSum++;
                if (tmpSum > sum) {
                    sum = tmpSum;
                    startIndex = tmpStartIndex;
                    endIndex = index;
                }
                continue;
            }
            tmpSum--;
            if (tmpSum < 0) {
                tmpSum = 0;
                tmpStartIndex = index+1;
            }
        }
        if (sum  > 0) {
            result.add(startIndex+1);
            result.add(endIndex+1);
        }
        return result;
    }
}

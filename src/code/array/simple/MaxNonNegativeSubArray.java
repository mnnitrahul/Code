package code.array.simple;

/**
 * https://www.interviewbit.com/problems/max-non-negative-subarray/
 * Use long for sum
 * Consider last sum/size also
 */


import java.util.ArrayList;
import java.util.jar.Pack200;

/**
 * Created by rahul.ka on 13/09/16.
 */
public class MaxNonNegativeSubArray {

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList result = new ArrayList();
        long sum = 0;
        ArrayList tmpResult = new ArrayList();
        long tmpSum = 0;
        if (a == null) {
            return result;
        }
        for (Integer i : a) {
            if (i < 0) {
                if (sum  < tmpSum || (sum == tmpSum && result.size() < tmpResult.size())) {
                    sum = tmpSum;
                    result = tmpResult;
                }
                tmpResult = new ArrayList();
                tmpSum = 0;
                continue;
            }
            tmpSum += i;
            tmpResult.add(i);
        }
        if (sum  < tmpSum || (sum == tmpSum && result.size() < tmpResult.size())) {
            result = tmpResult;
        }
        return result;
    }
}

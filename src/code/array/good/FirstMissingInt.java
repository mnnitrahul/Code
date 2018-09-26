package code.array.good;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * https://www.interviewbit.com/problems/first-missing-integer/
 */

/**
 * Created by rahul.ka on 14/09/16.
 */
public class FirstMissingInt {

    public int firstMissingPositive(ArrayList<Integer> A) {

        int n = A.size() + 1;
        int count;
        int idx = 0;
        int size = A.size();
        count = size - 1;
        System.out.println("initial: " + A);
        /**
         * Move all negative no in last
         */
        for (idx = size - 1; idx >= 0; idx--) {
            int num = A.get(idx);
            if (num <= 0) {
                int val = A.get(count);
                A.set(idx, val);
                A.set(count, num);
                count--;
            }
        }
        System.out.println("loop1: " + A);

        /**
         * Iterate +ve number and if number is in range then -ve the number at that index.
         * Math.abs is done beccause that number cound be location for any previous number
         */
        for (idx = 0; idx <= count; idx++) {
            int num = A.get(idx);
            num = Math.abs(num);
            if (num > 0 && num < n) {
                int index = num - 1;
                int val = A.get(index);
                A.set(index, -val);
            }
        }
        System.out.println("loop2: " + A);

        /**
         * Return if any +ve number found
         */
        //System.out.println("count is  " + count);
        for (idx = 0; idx <= count; idx++) {
            int num = A.get(idx);
            if (num > 0) {
                return idx + 1;
            }
        }
        System.out.println("loop3: " + A);
        return idx + 1;

    }
}

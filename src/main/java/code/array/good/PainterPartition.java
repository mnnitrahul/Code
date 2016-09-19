package code.array.good;

import java.util.ArrayList;


/**
 * https://www.interviewbit.com/problems/painters-partition-problem/
 * integer overflow and convert int to long
 */

/**
 * Created by rahul.ka on 17/09/16.
 */
public class PainterPartition {
    private boolean possible(int a, ArrayList<Integer> c, int mid) {
        int sum = 0;
        for (int i : c) {
//            if (mid == 329) System.out.println("i : " + i + " sum: " + sum + " sum+i: " + (sum+i) + " a: " + a + " mid: " + mid);
            if (i > mid) {
                return false;
            }
            if ((sum+i) > mid) {
                a--;
                sum = i;
            } else {
                sum += i;
            }
            if(a == 0) {
                return false;
            }
        }
        return true;
    }

    private int findResult(int low, int high, ArrayList<Integer> c, int a) {
        int res = 0;
        while (low <= high) {
            int mid = low + (high-low)/2;
            boolean status = possible(a, c, mid);
            //System.out.println("low: " + low + " high: " + high + " mid: " + mid + " possible: " + status);
            if(status) {
                res = mid;
                high = mid-1;
            } else {
                low  = mid+1;
            }
        }
        return res;
    }

    public int paint(int a, int b, ArrayList<Integer> c) {
        int MOD = 10000003;
        int res = findResult(0, Integer.MAX_VALUE, c, a);
        return  (int)((((long)res % MOD)*((long)b % MOD)) % MOD);

    }

    public int books(ArrayList<Integer> a, int b) {
        if (a.size() < b) return -1;
        return findResult(0, Integer.MAX_VALUE, a, b);

    }
}

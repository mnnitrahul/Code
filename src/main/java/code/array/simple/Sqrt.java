package code.array.simple;

/**
 * https://www.interviewbit.com/problems/square-root-of-integer/
 * To Be done for float
 */

/**
 * Created by rahul.ka on 16/09/16.
 */
public class Sqrt {

    public boolean equal(int num, int mid) {
        if (mid == num/mid && num%mid == 0) {
            return true;
        }
        return false;
    }


    public boolean lessThan(int num, int mid) {
        if (mid <= num/mid) {
            return true;
        }
        return false;
    }

    public int sqrt(int a) {
        int low = 0;
        int high = a;
        int floor = 0;
        if (a == 0 || a == 1) return a;
        while (low <= high) {
            int mid = (low+high)/2;
            if (equal(a, mid)) {
                return mid;
            }
            if (lessThan(a, mid)) {
                floor = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return floor;
    }
}

package code.array.algo;

import java.util.ArrayList;
/**
 * https://www.interviewbit.com/problems/find-permutation/
 * So, Suppose we started with a set corresponding to all the elements from that we need to make
 * permutation(i.e all integer from1 to n).
 * the next number should be larger, we need to substitute smallest remaining number from our set
 * corresponding to subsequent I as it automatically makes the next element to be larger.
 * Similar things will happens with character D, we need to substitute the largest remaining number
 * from our set.As the input string size is n - 1, we to append the last integer to our answer
 */


/**
 * Created by rahul.ka on 15/09/16.
 */
public class FindPermutation {

    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> output = new ArrayList<>();
        int min = 1;
        int max = B;
        for (char c : A.toCharArray()) {
            if(c == 'I') output.add(min++);
            if (c == 'D') output.add(max--);

        }
        output.add(min);
        return output;
    }
}

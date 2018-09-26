package code.array.simple;

/**
 * https://www.interviewbit.com/problems/permutations/
 * https://www.interviewbit.com/problems/kth-permutation-sequence/
 */

import java.util.ArrayList;

/**
 * Created by rahul.ka on 26/09/16.
 */
public class Permutation {
    public String getPermutation(int n, int k) {
        StringBuilder builder = new StringBuilder();
        ArrayList<Integer> charSet = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            charSet.add(i+1);
        }
        getPermutation(k-1, builder, charSet);
        return builder.toString();
    }

    public void getPermutation(int k, StringBuilder builder, ArrayList<Integer> charSet) {
        int n = charSet.size();
        if (n == 0) {
            return;
        }
        int f = factorial(n-1);
        int pos = k/f;
//        System.out.println("factorial: " + f + " pos: " + pos + " newk: " + k + " char:" + charSet.get(pos));
        k = k%f;

        builder.append(charSet.get(pos));
        charSet.remove(pos);
        getPermutation(k, builder, charSet);
    }



    private int factorial(int n) {
        int fact = 1; // this  will be the result
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}

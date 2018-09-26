package code.array.algo;

/**
 * https://www.interviewbit.com/problems/next-permutation/
 * The suffix which gets affected is in a descending order before the change.
   A swap with the smaller element happens and then we reverse the affected suffix.
    1 2 3 -> 1 3 2   // Suffix being just the 3.
 1 2 3 6 5 4  -> 1 2 4 3 5 6 // Suffix being 6 5 4 in this case.
 2, 3, 1 -> 3 1 2 // exchange with next bigger value and sort i+1  to nth elements
 */

import java.util.ArrayList;

/**
 * Created by rahul.ka on 15/09/16.
 */
public class NextPermutation {
    private void reverse(ArrayList<Integer> a, int startIndex, int endIndex) {
        while(startIndex < endIndex) {
            int tmp = a.get(startIndex);
            a.set(startIndex, a.get(endIndex));
            a.set(endIndex, tmp);
            startIndex++;
            endIndex--;
        }
    }

    public void nextPermutation(ArrayList<Integer> a) {
        if (a.size() == 1) {
            return;
        }
        int i = a.size()-2;
        for (;i >=0;--i) {
            if (a.get(i) < a.get(i+1)) {
                break;
            }
        }
        if (i < 0) {
            reverse(a, 0, a.size()-1);
            return;
        }
        int exchangePos = a.size()-1;
        for(;exchangePos>i;--exchangePos) {
            if(a.get(exchangePos)> a.get(i)) {
                break;
            }
        }


        int tmp = a.get(i);
        a.set(i, a.get(exchangePos));
        a.set(exchangePos, tmp);
        reverse(a, i+1, a.size()-1);

        /*
          - exchange this with last. reverse from i+1 to n-2
         */
    }
}

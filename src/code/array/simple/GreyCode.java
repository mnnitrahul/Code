package code.array.simple;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * https://www.interviewbit.com/problems/gray-code/
 */

/**
 * Created by rahul.ka on 26/09/16.
 */
public class GreyCode {
    public ArrayList<Integer> grayCode(int a) {
        if (a == 0) {
            return new ArrayList<>(Arrays.asList(0));
        }
        ArrayList<Integer> tillNow = grayCode(a-1);
        //System.out.println("result till " + (a-1) + " is " + tillNow);
        int size = tillNow.size();
        for (int i = size-1;i >=0;--i){
            tillNow.add((tillNow.get(i) | 1 <<(a-1)));
        }
        return tillNow;
    }
}

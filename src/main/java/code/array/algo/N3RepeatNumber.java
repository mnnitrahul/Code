package code.array.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul.ka on 15/09/16.
 */
public class N3RepeatNumber {
    public ArrayList<Integer> getRow(int a) {
        long ans = (long)Math.pow(11, a);
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while(ans > 0) {
            Long i = (ans % 10);
            digits.add(i.intValue());
            ans /= 10;
        }
        return digits;
    }
}

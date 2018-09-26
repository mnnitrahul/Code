package code.dp;

import javax.swing.*;

import static javafx.scene.input.KeyCode.M;

/**
 * Created by rahul.ka on 16/10/16.
 * https://www.interviewbit.com/problems/arrange-ii/
 */
public class ArrangeHorse {
    public int arrange(String a, int b) {
        int[][] count = new int[b+1][a.length()];
        int whitecount = 0;
        int blackcount = 0;
        for (int i = 0; i <=b; ++i) {
            for (int j = 0; j < a.length(); ++j) {
                count[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int end = 0;end < a.length(); end++) { // for 1 stable only 1 possibe solution
            if (a.charAt(end) == 'W') whitecount++;
            if (a.charAt(end) == 'B') blackcount++;
            count[1][end] = whitecount*blackcount;
            //System.out.println("result for 1 from 0th till end : " + end + " result: " + count[1][end]);
        }

        for (int stableCount = 2; stableCount <= b; ++stableCount) { // for each stable count fix end and move start. consider start-end as 1 stable and get min value before start from dp
            for (int end = 0; end <a.length(); ++end) {
                whitecount = 0;
                blackcount = 0;
                for (int start = end; start >0; start--) {
                    if (a.charAt(start) == 'W') whitecount++;
                    if (a.charAt(start) == 'B') blackcount++;
                    int product = whitecount*blackcount;
                    if (count[stableCount-1][start-1] != Integer.MAX_VALUE) {
                        count[stableCount][end] = Math.min(count[stableCount][end], product+count[stableCount-1][start-1]);
                    }
                }
                //System.out.println("result for stable: " + stableCount + " till end: " + end + " is: " + count[stableCount][end]);
            }
        }
        if (count[b][a.length()-1] == Integer.MAX_VALUE) return -1;
        return count[b][a.length()-1];
    }
}

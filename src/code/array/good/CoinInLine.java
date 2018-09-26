package code.array.good;

import java.util.ArrayList;

import static javafx.scene.input.KeyCode.M;

/**
 * Created by rahul.ka on 18/10/16.
 * https://www.interviewbit.com/problems/coins-in-a-line/
 */
public class CoinInLine {
 //ans[i,j] = Max(a[i]+min(ans[i+1][j-1],ans[i+2][j])  ,  a[j]+min(ans[i+1][j-1],ans[i][j-2]) )

    public int maxcoin(ArrayList<Integer> a) {
        int[][] max= new int[a.size()][a.size()];
        for (int i = 0 ; i < a.size(); ++i) {
            max[i][i] = a.get(i);
        }
        for (int i = 0 ; i < a.size()-1; ++i) {
            max[i][i+1] = Math.max(a.get(i), a.get(i+1));
        }
        for (int l = 2; l < a.size(); ++l) {
            for (int i = 0; i+l < a.size(); ++i) {
                int j = i+l;
                max[i][j] = Math.max((a.get(i)+Math.min(max[i+1][j-1], max[i+2][j])), (a.get(j)+Math.min(max[i+1][j-1], max[i][j-2])));
            }
        }
/*        for (int i =0; i < a.size(); ++i) {
            for (int j = i; j < a.size(); ++j) {
                System.out.println("("+i+", "+j+"): " + max[i][j]);
            }
        }
*/        return max[0][a.size()-1];
    }


}

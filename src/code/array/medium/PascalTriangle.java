package code.array.medium;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/pascal-triangle-rows/
 * https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
 * http://ptri1.tripod.com/ -> Pascal triangle properties
 */

/**
 * Created by rahul.ka on 15/09/16.
 */
public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0;i<a;++i) {
            ArrayList<Integer> row = new ArrayList<>();
            if(i == 0) {
                row.add(1);
                res.add(row);
                continue;
            }
            ArrayList<Integer> lastRow = res.get(i-1);
            int prev = 0;
            for (int num : lastRow) {
                row.add(num+prev);
                prev = num;
            }
            row.add(prev);
            res.add(row);
        }
        //System.out.println(res);
        return res;
    }

    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 0;i<a;++i) {
            int last = 0;
            for(int k = 0;k<res.size();++k) {
                int num = res.get(k);
                res.set(k, num+last);
                last = num;
            }
            res.add(last);
        }
        return res;
    }
}

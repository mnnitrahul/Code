package code.binary.matrix;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/matrix-search/
 */

/**
 * Created by rahul.ka on 16/09/16.
 */
public class MatrixSearch {

    private int findRow(ArrayList<ArrayList<Integer>> a, int b, int start, int end) {
        if (start > end) {
            return 0;
        }
        int mid = (end+start)/2;
//        System.out.println("start: " + start + " end: " + end + " mid: " + mid);
        if (a.get(mid).get(0) == b) {
            return mid;
        }
        if (a.get(mid).get(0) > b) {
            return findRow(a, b, start, mid-1);
        }
        if(a.get(mid).get(0) < b && (mid == end || a.get(mid+1).get(0) > b)) {
            return mid;
        }
        return findRow(a, b, mid+1, end);
    }

    private int find(ArrayList<Integer> a, int b, int start, int end) {
        if (start > end) {
            return 0;
        }
        int mid = (end+start)/2;
        if (a.get(mid) == b) {
            return mid;
        }
        if (a.get(mid) > b) {
            if (mid == start) {
                return 0;
            }
            return find(a, b, start, mid-1);
        }
        if (mid == end) {
            return 0;
        }
        return find(a, b, mid+1, end);
    }

    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        if (a.size() == 0 || a.get(0).size()== 0) {
            return 0;
        }
        if(a.get(0).get(0) == b) {
            return 1;
        }
        int row = findRow(a, b, 0, a.size()-1);
        int column = find(a.get(row), b, 0, a.get(row).size()-1);
        //System.out.println("row: " + row + "column: " + column);
        if (a.get(row).get(column)== b) return 1;
        return 0;
    }
}

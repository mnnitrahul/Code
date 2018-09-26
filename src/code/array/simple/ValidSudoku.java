package code.array.simple;

import java.util.List;

/**
 * Created by rahul.ka on 27/09/16.
 */
public class ValidSudoku {
    public int isValidSudoku(final List<String> a) {
        int[][] rowArray = new int[9][9];
        int[][] colArray = new int[9][9];
        int[][][] blockArray = new int[3][3][9];
        System.out.println("value " + rowArray[0][0]);
        int row = 0;
        for (String s : a) {
            char[] c = s.toCharArray();
            for (int col = 0;col < 9;++col ) {
                if (c[col] != '.') {
                    int value = c[col]-'1';
                    if (rowArray[row][value] == 1) {
                        return 0;
                    }
                    if (colArray[row][value] == 1) {
                        return 0;
                    }
                    if (blockArray[row/3][col/3][value] == 1) {
                        return 0;
                    }
                    rowArray[row][value] = 1;
                    colArray[row][value] = 1;
                    blockArray[row/3][col/3][value] = 1;
                }
            }
            row++;
        }
        return 1;
    }
}

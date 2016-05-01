package dynamic;

/**
 * Created by rahul.ka on 01/05/16.
 */

//http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/

public class Interleaving {
    public boolean isInterleave(String A, String B, String C) {
        int aLength = A.length();
        int bLength = B.length();
        int cLength = C.length();
        if (cLength != aLength+bLength) {
            return false;
        }
        boolean[][] result = new boolean[bLength+1][aLength+1];
        for (int i = 0;i <=aLength; ++i) {
            for (int j = 0; j<= bLength; ++j) {
                if(i == 0 && j ==0) {
                    result[i][j] = true;
                    continue;
                }
                if (i == 0) {
                    if(A.charAt(j-1) == C.charAt(j-1)) {
                        result[i][j] = result[i][j - 1];
                    }
                } else if (j == 0) {
                    if (B.charAt(i-1) == C.charAt(i-1)) {
                        result[i][j] = result[i - 1][j];
                    }
                } else if(A.charAt(j-1) == C.charAt(i+j-1) && B.charAt(i-1) != C.charAt(i+j-1)) {
                    result[i][j] = result[i][j-1];
                } else if(B.charAt(i-1) == C.charAt(i+j-1) && A.charAt(j-1) != C.charAt(i+j-1)) {
                    result[i][j] = result[i-1][j];
                } else if(A.charAt(j-1) == C.charAt(i+j-1) && B.charAt(i-1) == C.charAt(i+j-1)) {
                    result[i][j] = result[i][j-1] || result[i-1][j];
                } else result[i][j] = false;
            }
        }
        return result[bLength][aLength];
    }

    public static void main(String[] args) {
        String A = "XXY";
        String B = "XXZ";
        String C = "XXXXZY";
        Interleaving interleaving = new Interleaving();
        System.out.println(interleaving.isInterleave(A, B, C));
    }
}

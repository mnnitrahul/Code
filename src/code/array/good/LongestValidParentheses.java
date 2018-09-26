package code.array.good;

/**
 * Created by rahul.ka on 18/10/16.
 * https://www.interviewbit.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String a) {
        int[] count = new int[a.length()];
        if (a.length() == 1) return 0;
        count[0] = 0;
        count[1] = 0;
        int max = 0;
        if (a.charAt(0) == '(' && a.charAt(1) == ')') {
            count[1] = 2;
            max = 2;
        }

        for (int i = 2; i <a.length(); ++i) {
            count[i] = 0;
            if (a.charAt(i) == ')' && a.charAt(i-1) == '(') {
                count[i] = 2+ count[i-2];
            }
            if (a.charAt(i) == ')' && a.charAt(i-1) == ')' && (i-count[i-1]-1) >= 0 && a.charAt(i-count[i-1]-1) == '(') {
                count[i] = 2+ count[i-1] ;
                if ((i-count[i-1]-2) >= 0) count[i] += count[i-count[i-1]-2];
            }
            max = Math.max(max, count[i]);
            //System.out.println("till i: " + i + "string: " + a.substring(0, i+1) + " count: " + count[i] + " max: " + max);
        }
        return max;
    }
}

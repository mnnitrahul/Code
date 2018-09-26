package code.stack;


import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/redundant-braces/
 */

/**
 * Created by rahul.ka on 18/09/16.
 */
public class RedundantBraces {

    public int braces(String a) {
        Stack<Character> s = new Stack<>();
        for (char c : a.toCharArray()) {
            if (c == '(' || c == '+' || c == '-' || c == '*' || c == '/') {
                s.push(c);
            } else if ( c == ')') {
                if (s.peek() == '(') {
                    return 1;
                }
                while (s.peek() != '(') {
                    s.pop();
                }
                s.pop();

            }
        }
        return 0;
    }
}

package code.array.good;

import code.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 18/10/16.
 */
public class LongestValidParenthesesTest extends BaseTest {
    LongestValidParentheses longestValidParentheses = new LongestValidParentheses();

    @Test
    public void longestValidParentheses() throws Exception {
        int actualResult = longestValidParentheses.longestValidParentheses(")()())");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(4, actualResult);
    }

    @Test
    public void longestValidParentheses2() throws Exception {
        int actualResult = longestValidParentheses.longestValidParentheses("()");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(2, actualResult);
    }

    @Test
    public void longestValidParentheses3() throws Exception {
        int actualResult = longestValidParentheses.longestValidParentheses("(())");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(4, actualResult);
    }

    @Test
    public void longestValidParentheses4() throws Exception {
        int actualResult = longestValidParentheses.longestValidParentheses("()()((())(((())))())))))))(((()())((()()()(()");
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertEquals(20, actualResult);
    }

}
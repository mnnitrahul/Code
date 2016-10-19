package code.array.good;

import code.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by rahul.ka on 19/10/16.
 */
public class WorkBreak2Test extends BaseTest {
    WorkBreak2 workBreak2 = new WorkBreak2();
    @Test
    public void wordBreak() throws Exception {
        String inputString = "catsanddog";
        ArrayList<String> dict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("cat sand dog", "cats and dog"));
        ArrayList<String> actualResult = workBreak2.wordBreak(inputString, dict);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void wordBreak2() throws Exception {
        String inputString = "abcd";
        ArrayList<String> dict = new ArrayList<>(Arrays.asList("abcd"));
        ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("abcd"));
        ArrayList<String> actualResult = workBreak2.wordBreak(inputString, dict);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void wordBreak3() throws Exception {
        String inputString = "a";
        ArrayList<String> dict = new ArrayList<>(Arrays.asList("aabbb"));
        ArrayList<String> expectedResult = new ArrayList<>();
        ArrayList<String> actualResult = workBreak2.wordBreak(inputString, dict);
        System.out.println("Result (" + name.getMethodName() + ") : " + actualResult);
        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

}
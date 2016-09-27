package code.array.good;

import java.util.HashMap;
import java.util.Map;
/**
 * https://www.interviewbit.com/problems/window-string/
 */

/**
 * Created by rahul.ka on 27/09/16.
 */
public class WindowString {
    public String minWindow(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> counter = new HashMap<>();
        for (Character c : T.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                count = 0;
            }
            count++;
            map.put(c, count);
        }
        int totalCount = T.length();
        int end = 0;
        int start = 0;
        int resultStart = 0;
        int resultEnd = Integer.MAX_VALUE;
        while (totalCount >0 && end < S.length()) {
            while (totalCount >0 && end < S.length()) {
                Character c = S.charAt(end);
                Integer count = map.get(c);
                if (count != null) {
                    Integer charCounter = counter.get(c);
                    if (charCounter == null) {
                        charCounter = 0;
                    }
                    charCounter++;
                    counter.put(c, charCounter);
                    if (charCounter <= count) {
                        totalCount--;
                    }
                }
                end++;
            }
            //System.out.println("found result after end: " + counter + "start: " + start + " end: " + end);
            while (start < end && totalCount ==0) {
                Character c = S.charAt(start);
                Integer count = map.get(c);
                if (count != null) {
                    Integer charCounter = counter.get(c);
                    charCounter--;
                    counter.put(c, charCounter);
                    if (charCounter < count) {
                        if ((resultEnd-resultStart) > (end-start)) {
                            resultEnd = end;
                            resultStart = start;
                        }
                        totalCount++;
                    }

                }
                start++;
            }
            //System.out.println("resultStart: " + resultStart + " resultEnd: " + resultEnd);
            //System.out.println("found result after start: " + counter + "start: " + start + " end: " + end);
        }
        //System.out.println("result start: " + resultStart + " char: " + S.charAt(resultStart));
        //System.out.println("result end: " + resultEnd + " char: " + S.charAt(resultEnd-1));
        if (resultEnd == Integer.MAX_VALUE) {
            return "";
        }
        return S.substring(resultStart, resultEnd);
        //return result;

    }
}

package code.array.good;

import java.util.*;


/**
 * Created by rahul.ka on 19/10/16.
 * https://www.interviewbit.com/problems/word-break-ii/
 */
public class WorkBreak2 {
    public ArrayList<String> wordBreak(String a, ArrayList<String> b) {
        ArrayList<String>[] substrings = new ArrayList[a.length()+1];
        substrings[a.length()] = new ArrayList<>();
        Set<String> words = new HashSet<>(b);
        for (int start = a.length()-1; start >= 0; --start) {
            ArrayList<String> list = null;
            for (int end = start+1; end <= a.length(); ++end) {
                String subString = a.substring(start, end);
                if (words.contains(subString)) {
  //                  System.out.println("from start: " + start + " end: " + end + " match word: " + subString);
                    if (list == null) list = new ArrayList<>();
                    if (end == a.length()) {
                        list.add(subString);
                    } else {
  //                      System.out.println("getting future list");
                        if (substrings[end] != null) {
  //                          System.out.println("future list: " + substrings[end+1]);
                            for (String sub : substrings[end]) {
                                list.add(subString + " " + sub);
                            }
                        }
                    }
                }
            }
            substrings[start] = list;
//            System.out.println("subStrigs["+start+"] substring: " + a.substring(start) + " : " + substrings[start]);
        }
        ArrayList<String> ans = substrings[0];
        if (ans == null) return new ArrayList<>();
        Collections.sort(ans);
        return ans;
    }
}

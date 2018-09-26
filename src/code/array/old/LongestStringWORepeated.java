package code.array.old;

/**
 * http://leetcode.com/2011/05/longest-substring-without-repeating-characters.html
 * @author agarwalr
 *
 */
public class LongestStringWORepeated {
	public String longestString(String input) {
		boolean[] isPresent = new boolean[256];
		int start = 0;
		int tmpStart = 0;
		int end = 0;
		int tmpEnd = 0;
		for (int i = 0;i<input.length();i++) {
			char c = input.charAt(i);
			
			if (isPresent[c-'a'] == false) {
				isPresent[c-'a'] = true;
				tmpEnd = i;
			} else {
				//System.out.println("start and end" + tmpStart + " " + tmpEnd);
				if ((end - start) < (tmpEnd-tmpStart)) {
					start = tmpStart;
					end = tmpEnd;	
				}
				for (int j = tmpStart;j < i; ++j) {
					char a = input.charAt(j);
					if (a == c) {
						tmpStart = j +1;
						break;
					} else {
						isPresent[a-'a'] = false;
					}
				}
			}
		}
		if ((end - start) < (tmpEnd-tmpStart)) {
			start = tmpStart;
			end = tmpEnd;
		}
		System.out.println("final start and end" + start + " " + end);
		return input.substring(start, end+1);
	}
	public static void main(String[] args) {
		String input = "ab";
		LongestStringWORepeated longestStringWORepeated = new LongestStringWORepeated();
		String output = longestStringWORepeated.longestString(input);
		System.out.println(output);
	}
}

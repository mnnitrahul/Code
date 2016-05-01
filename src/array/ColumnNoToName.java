package array;

/**
 * http://www.careercup.com/question?id=13576694
 * @author agarwalr
 *
 */
public class ColumnNoToName {
	public String getName(int no) {
		StringBuilder s = new StringBuilder();
		while(no > 0) {
			int rem = no%26;
			if (rem == 0) {
				s.append('z');
				no = (no-1)/26;
				continue;
			}
			no = no/26;		
			char c = (char)('a' + rem-1);
			s.append(c);
		}
		return s.reverse().toString();
	}
	public static void main(String[] args) {
		int i = 703;
		ColumnNoToName columnNoToName = new ColumnNoToName();
		String name = columnNoToName.getName(i);
		System.out.println(name);
	}
}

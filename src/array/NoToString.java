package array;

public class NoToString {
	public String run(int n) {
		StringBuilder s = new StringBuilder();
		while (n > 0) {
			int a = n%26;
			if (a ==0) {
				a = 26;
				n=n-26;
			}
			char c = (char) ('a' + a-1);
			s.append(c);
			n = n/26;
		}
		
		return s.reverse().toString();
	}
	
	public static void main(String[] args) {
		int a = 52;
		NoToString n = new NoToString();
		String s = n.run(a);
		System.out.println(s);
	}
}

package array;

public class Interleaving {
	public Interleaving() {
		
	}
	public boolean verify(String a, String b, String c) {
		int m = a.length();
		int n = b.length();
		boolean[][] res = new boolean[m+1][n+1];
		for (int i = 0 ; i <= m; ++ i) {
			for (int j = 0;j <=n; ++j) {
				if (i==0 && j==0) {
					res[0][0] = true;
					continue;
				}
				if (i == 0) {
				if( b.charAt(j-1) == c.charAt(j-1)) {
					res[i][j] = res[i][j-1];	
					}
				continue;
				}
				if (j == 0) {
					if( a.charAt(i-1) == c.charAt(i-1)) {
						res[i][j] = res[i-1][j];
					}
					continue;
				}
				if (a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) != c.charAt(i+j-1) ) {
					res[i][j] = res[i-1][j];
					continue;
				}
				if (a.charAt(i-1) != c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1) ) {
					res[i][j] = res[i][j-1];
					continue;
				}
				if (a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1) ) {
					res[i][j] = res[i-1][j] || res[i][j-1];
					continue;
				}
			}
		}
		return res[m][n];
	}
	public static void main(String[] args) {
		String a = "xxy";
		String b = "xxz";
		String c = "xxxxyz";
		Interleaving interleaving = new Interleaving();
		boolean result = interleaving.verify(a, b, c);
		System.out.println(result);
	}
}

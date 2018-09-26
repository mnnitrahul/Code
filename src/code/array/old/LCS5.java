package code.array.old;

public class LCS5 {
	LCS5(char[] x, char[] y, int m, int n) {
		int result = 0;
		int[][] ans = new int[m+1][n+1];
		for (int i =0;i<=m;++i) {
			for (int j=0;j<=n;++j) {
				if (i==0 || j==0) {
					ans[i][j] = 0;
				}
				else if (x[i-1] == y[j-1]) {
					ans[i][j] = ans[i-1][j-1] + 1;
					result = result>ans[i][j]?result:ans[i][j];
				}
				else
				//	ans[i][j]  =  ans[i][j-1] > ans[i-1][j] ? ans[i][j-1]:ans[i-1][j];
					ans[i][j] = 0;
			}
		}
		System.out.println("result is " + result);
		
	}
	
	public static void main(String[] args) {
		String x = "OldSite:GeeksforGeeks.org";
		String y = "NewSite:Geeksor";
		LCS5 l = new LCS5(x.toCharArray(), y.toCharArray(), x.length(), y.length());
		
	}
}

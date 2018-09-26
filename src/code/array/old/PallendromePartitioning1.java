package code.array.old;

import java.util.Arrays;


public class PallendromePartitioning1 {
	public PallendromePartitioning1(char[] input, int l) {
		boolean[][] isPallen = new boolean[l][l];
		int[][] minPart = new int[l][l];
		for (int i =0; i<l; ++i) {
			isPallen[i][i] = true;
			minPart[i][i] = 0;
		}
		for (int length = 2; length <=l;++length) {
			for (int i = 0; i+length <= l ; ++i) {
				int j = i+length-1;
				if (length == 2) 
					isPallen[i][j] = input[i] == input[j];
				else
					isPallen[i][j] = (input[i] == input[j]) && isPallen[i+1][j-1];
				if (isPallen[i][j] == true) {
					minPart[i][j] = 0;
				} else {
					minPart[i][j] = l +1;
					for(int k = i;k < j;++k) {
						minPart[i][j] = minPart[i][j] < (minPart[i][k]+minPart[k+1][j]+1)?minPart[i][j]:(minPart[i][k]+minPart[k+1][j]+1);
					}
				}
			}
		}
		System.out.println(isPallen[0][l-1]);
		for (int i = 0; i < l;++i) {
			String s = new String(Arrays.copyOfRange(input, 0, i+1));
			System.out.println(s + " " + minPart[0][i]);
		}
	}
	
	public static void main(String[] args) {
		String input = "ababbbabbababa";
		PallendromePartitioning1 p = new PallendromePartitioning1(input.toCharArray(), input.length());
	}
}

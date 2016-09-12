package code.array.old;

import java.util.Arrays;


public class QuickSortPartition {
	public QuickSortPartition(int[] input) {
		int l = input.length;
		int k=0;
		while(input[k] < 0) {
			k++;
		}
		
		for (int i=k;i<l;++i){
			if (input[i] > 0) {
				continue;
			}
			int temp = input[k];
			input[k] = input[i];
			input[i] = temp;
			k++;
		}
	}
	
	public static void main(String[] args) {
		int[] input = {-1, -2, -3, 4, 5, 6, -7, 8, 9};
		QuickSortPartition q = new QuickSortPartition(input);
		System.out.println(Arrays.toString(input));
	}
}

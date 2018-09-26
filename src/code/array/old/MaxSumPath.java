package code.array.old; /**
 * http://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;


public class MaxSumPath {
	public MaxSumPath() {
		
	}
	public int getMaxSum(Integer[] arr1, Integer[] arr2) {
		int result = 0;
		int sum1 = 0;
		int sum2 = 0;
		int x = 0;
		int y = 0;
		while (x < arr1.length && y < arr2.length) {
			if (arr1[x] < arr2[y]) {
				sum1 += arr1[x];
				x++;
			} else if (arr1[x] > arr2[y]) {
				sum2 += arr2[y];
				y++;
			} else {
				if (sum1 > sum2) {
					result += sum1;
				} else {
					result += sum2;
				}
				result += arr1[x];
				x++;
				y++;
				sum1 = sum2 = 0;
			}
		}
		while (x < arr1.length) {
			result += arr1[x];
			x++;
		}
		while (y < arr2.length) {
			result += arr2[y];
			y++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		MaxSumPath maxSumPath = new MaxSumPath();
		Integer[] ar1 =  {2, 3, 7, 10, 12, 15, 30, 34};
		Integer[] ar2 = {1, 5, 7, 8, 10, 15, 16, 19};
		ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(ar1));
		ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(ar2));
		System.out.println(maxSumPath.getMaxSum(ar1, ar2));
	}
}

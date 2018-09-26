package code.array.old;

/**
 * http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
 * @author agarwalr
 *
 */
public class MinimumUnsortedArray {
	public void getIndexes(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		int i,j;
		for (i = 0;i < end;++i) {
			if (arr[i] > arr[i+1]) {
				break;
			}
		}
		for (j = end;j > 0;j--) {
			if (arr[j] < arr[j-1]) {
				break;
			}
		}
		if (i > j ) {
			return;
		}
		int min = arr[j];
		int max = arr[i];
		for (int k = i; k <=j; ++k) {
			if (arr[k] > max) {
				max = arr[k];
			}
			if (arr[k] < min) {
				min = arr[k];
			}
		}
		for (;i >=0 ;i--) {
			if (arr[i] < min) {
				break;
			}
		}
		for (;j <= end; ++j) {
			if (arr[j] > max) {
				break;
			}
		}
		System.out.println("i is " + arr[++i] + " j is " + arr[--j]);
	}
	public static void main (String[] args) {
		int[] arr = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
//		int[] arr = {10, 12, 20, 30};
//		int[] arr = {30, 20, 10};
		MinimumUnsortedArray minimumUnsortedArray = new MinimumUnsortedArray();
		minimumUnsortedArray.getIndexes(arr);
	}
}

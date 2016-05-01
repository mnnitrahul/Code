package array;

public class Median2EqualSortedArray {
	private int max(int i, int j) {
		int max = i > j ? i:j;
		return max;
	}
	private int min(int i, int j) {
		int min = i < j ? i:j;
		return min;
	}
	public int getMedian(int[] arr1, int[] arr2, int start1, int end1, int start2, int end2) {
		if ((end1-start1) == 1 ) {
			int num1 = max(arr1[start1], arr2[start2]);
			int num2 = min(arr1[end1], arr2[end2]);
			return (num1+num2)/2;
		}
		int mid1 = (end1+start1)/2;
		int mid2 = (end2+start2)/2;
		if (mid1 > mid2) {
			return (getMedian(arr1, arr2, start1, mid1, mid2, end2));
		} 
		return (getMedian(arr1, arr2, mid1, end1, start2, mid2));
	}
	public static void main(String[] args) {
		int arr1[] = {1, 12 };
		int arr2[] = {2,  17};
		Median2EqualSortedArray median2EqualSortedArray = new Median2EqualSortedArray();
		int result = median2EqualSortedArray.getMedian(arr1, arr2, 0, arr1.length-1, 0, arr2.length-1);
		System.out.println("result is " + result);
	}
}

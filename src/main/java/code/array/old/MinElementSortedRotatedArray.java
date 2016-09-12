package code.array.old;

/*
 * Won't handle duplicate elements
 */
public class MinElementSortedRotatedArray {
	public MinElementSortedRotatedArray() {
		
	}
	public int findMin(int[] arr, int start, int end) {
		if (start ==end) {
			return arr[start];
		}
		int mid = start + (end-start)/2;
		if (((mid > start && arr[mid-1] > arr[mid] ) || mid == start) && arr[mid + 1] > arr[mid]) {
			return arr[mid];
		}
		if (arr[mid] < arr[end]) {
			return findMin(arr, start, mid-1);
		}
		return findMin(arr, mid+1, end);
	}
	public static void main(String[] args) {
		MinElementSortedRotatedArray minElementSortedArray = new MinElementSortedRotatedArray();

		int arr1[] =  {1, 2, 3, 4, 5};
		int size1 = arr1.length;
		int minValue1 = minElementSortedArray.findMin(arr1, 0, size1-1);
		System.out.println("Min value is " + minValue1);

	/*	int arr2[] =  {2, 3, 4, 5};
		int size2 = arr2.length;
		int minValue2 = minElementSortedArray.findMin(arr2, 0, size2-1);
		System.out.println("Min value is " + minValue2);

		int arr3[] =    {3};
		int size3 = arr3.length;
		int minValue3 = minElementSortedArray.findMin(arr3, 0, size3-1);
		System.out.println("Min value is " + minValue3);
		
		int arr4[] =    {8, 7, 6, 5, 4};
		int size4 = arr4.length;
		int minValue4 = minElementSortedArray.findMin(arr4, 0, size4-1);
		System.out.println("Min value is " + minValue4);*/

	}
}

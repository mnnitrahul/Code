package array;

public class CountInversion2 {
	public int conversions(int[] arr, int[] tmp, int start, int end) {
		if (start > end) {
			return -1;
		} if (start == end) {
			return 0;
		}
		int count = 0;
		int mid = start + (end-start)/2;
		count += conversions(arr, tmp, start, mid);
		count += conversions(arr, tmp, mid+1, end);
		count += merge(arr, tmp, start, mid+1, end+1);
		return count ;
	}
	private int merge(int[] arr, int[] tmp, int start, int end1, int end2) {
		int i = start;
		int k = start;
		int j = end1;
		int count = 0;
		while (i < end1 && j < end2) {
			if (arr[i] <= arr[j]) {
				tmp[k++] = arr[i++];
			} else {
				tmp[k++] = arr[j++];
				count += end1-i;
			}
		}
		if (i < end1) {
			tmp[k++] = arr[i++];
		} if (j < end2) {
			tmp[k++] = arr[j++];
		}
		return count;
	}
	public static void main(String[] args) {
		 int arr[] = {8,7,6,5,4,3,2,1};
		 int tmp[] = new int[arr.length];
		 CountInversion2 conversion = new CountInversion2();
		 int count = conversion.conversions(arr, tmp, 0, arr.length-1);
		 System.out.println("result is " + count);
	}
}

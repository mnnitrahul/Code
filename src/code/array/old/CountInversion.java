package code.array.old;


public class CountInversion {
	public CountInversion() {
		
	}
	public int mergeSort(int[] arr, int[] tmp, int start, int end) {
		int count = 0;
		if (end > start) {
			int mid = start + (end-start)/2;
			count += mergeSort(arr, tmp, start, mid);
			count += mergeSort(arr, tmp, mid+1, end);
			count += merge(arr, tmp, start, mid+1, end);
		}
		return count;
	}
	private int merge(int[] arr, int[] tmp, int start, int mid, int end) {
		int i = start;
		int j = mid;
		int k = start;
		int count = 0;
		while (i < mid && j <= end) {
			if (arr[i] < arr[j]) {
				tmp[k++] = arr[i++];
			} else {
				tmp[k++] = arr[j++];
				count += mid-i;
			}
		}
		while (i < mid) {
			tmp[k++] = arr[i++];
		}
		while (j <= end) {
			tmp[k++] = arr[j++];
		}
		for ( i = start;i <= end;++i) {
			arr[i] = tmp[i];
		}
		return count;
	}
	public static void main(String[] args) {
		CountInversion countInversion = new CountInversion();
		int[] arr = { 2 };
		int[] tmp = new int[arr.length];
		int res = countInversion.mergeSort(arr, tmp, 0, arr.length-1);
//		System.out.println(Arrays.asList(arr));
		System.out.println("result is " + res);
	}
}

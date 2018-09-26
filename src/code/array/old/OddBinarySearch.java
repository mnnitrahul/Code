package code.array.old;

public class OddBinarySearch {
	
	public int binarySearch(int[] a, int l, int r, int n) {
		if (r < l) {
			return -1;
		}
		int mid = (r-l)/2;
		if (mid%2 == 0) {
			if (a[mid+1]  > n && a[mid-1] < n) {
				return mid;
			}
			if (a[mid+1] > n) {
				return binarySearch(a, l, mid-1, n);
			} else {
				return binarySearch(a, mid+1, r, n);
			}
		} else {
			if (a[mid] > n && a[mid-2] < n) {
				return mid-1;
			} if (a[mid] > n) {
				return binarySearch(a, l, mid-1, n);
			} else {
				return binarySearch(a, mid+1, r, n);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		OddBinarySearch bs = new OddBinarySearch();
	}
}

package code.array.old;

public class BinarySearch {
	public int leftBinarySearch(int[]a, int l, int r, int n) {
		if (l > r) return -1;
		int mid = (l+r)/2;
		if ((a[mid]  == n) && (mid == 0 || a[mid-1] < n)) {
				return mid;
		} else if(a[mid] < n) {
			return leftBinarySearch(a, mid+1, r, n);
		} else 
			return leftBinarySearch(a, l, mid-1, n);
	}
	
	public int rightBinarySearch(int[]a, int l, int r, int n) {
		if (l > r) return -1;
		int mid = (l+r)/2;
		if ((a[mid]  == n) && (mid == (a.length-1) || a[mid+1] > n)) {
				return mid;
		} else if(a[mid] > n) {
			return rightBinarySearch(a, l, mid-1, n);			
		} else  {
			return rightBinarySearch(a, mid+1, r, n);
		}	
	}

	public static void main(String[] args) {
		int arr[] = {1,  2, 2, 3, 3, 3, 3};
		int x = 1;
		BinarySearch b  = new BinarySearch();
		int l = b.leftBinarySearch(arr, 0, arr.length-1, x);
		int r = b.rightBinarySearch(arr, 0, arr.length-1, x);
		System.out.println(l + " " + r + " " + (r-l + 1));
	}
}

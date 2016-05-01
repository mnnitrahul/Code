package array;

public class MinElementInrotated10 {
	int find(int l, int start, int end, int[] a) {
		int mid = (start+end)/2;
		System.out.println("Values are "+ a[start] + " " +  a[end] + " " + mid + " " + a[mid]);
		if (mid == 0) return mid;
		if (mid == l) return mid;
		if (a[mid] < a[mid-1] && a[mid] < a[mid+1]) return mid;
		if (a[mid] > a[l]) return find(l, mid+1, end, a);
		return find(l, start, mid-1,a);
	}
	
	public MinElementInrotated10(int[] input) {
		int ans;
		if (input.length ==  2) 
			ans = input[0] < input[1] ? 0 : 1;
		else 
			ans = find(input.length-1, 0, input.length-1, input);
		System.out.println(input[ans]);
	}
	public static void main(String[] args) {
		int[] input = {3, 4,  1, 2};
		MinElementInrotated10 m = new MinElementInrotated10(input);
	}
}

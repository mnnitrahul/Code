package code.array.old;

public class MaxSum {
	
	public int run(int[] a) {
		int n = a.length;
		int s = 0;
		int sum = 0;
		for (int i =0;i<n;++i) {
			s += a[i];
			if (s < 0) 
				s = 0;
			if(s > sum) 
				sum = s;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] a = {10, -3, -4, 7, 6, 5, -4, -1};
		MaxSum m = new MaxSum();
		int r1 = m.run(a);
		System.out.println(r1);
		int totalSum = 0;
		for (int i = 0;i<a.length;++i) {
			totalSum += a[i];
			a[i] = -a[i];
		}
		int r2 = m.run(a);
		r2 = totalSum + r2;
		System.out.println(r2);
	}
}

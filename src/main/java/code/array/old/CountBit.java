package code.array.old;

public class CountBit {
	private int sum(int bits){
		return (int) (((bits)*(1<< (bits-1)))+1);
	}
	 private int findBit(int num) {
		 int i = 0;
		 int powOf2 = 1;
		 while (powOf2 < num) {
			i++;
			powOf2 = 1<<i;
		 }
		 return i;
	 }
	
	public int run(int num) {
		int s = 0;
		while (num > 1) {
			int i = findBit(num);
			int powOf2 = 1<<i;
			num = num - powOf2;
			s += num;
			s += sum(i);
		}
		if (num == 1) {
			s += 1;
		}
		return s;
	}
	public static void main(String[] args) {
		int n = 2;
		CountBit c = new CountBit();
		int result = c.run(n);
		System.out.println("Ans is " + result);
	}
}

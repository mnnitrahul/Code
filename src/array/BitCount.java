package array;

public class BitCount {
	private int count(int bit) {
		return (int) (bit*Math.pow(2, bit-1)) + 1;
	}
	private int highestBit(int num) {
		
		int n = 1;
		int count = 0;
		while (n <= num) {
			n = n << 1;
			count++;
		}
		return count-1;
	}
	public int countBits(int num) {
		if (num <= 0) {
			return 0;
		}
		if (num == 1) {
			return 1;
		}
		int sum = 0;
		while (num > 0) {
			int bit = highestBit(num);
			sum += count(bit);
			num = num - (1<<bit);
			sum += num;
		}
		return sum;
	}
	public static void main(String[] args)  {
		BitCount bitCount = new BitCount();
		int result = bitCount.countBits(1);
		System.out.println("result is " + result);
	}
}

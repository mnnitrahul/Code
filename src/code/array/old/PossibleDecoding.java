package code.array.old;

public class PossibleDecoding {
	public int decode(char[] input) {
		
		int n = input.length;
		int[] count = new int[n+1];
		
		count[0] = 1;
		count[1] = 1;
		for (int i = 2;i<=n;++i) {
			count[i] = 0;
			if (input[i-1] > '0') {
				count[i] = count[i-1];
			}
			if ((input[i-2] < '2') || (input[i-2] == '2' && input[i-1] < '7')) {
				count[i] += count[i-2];
			}
		}
		return count[n];
	}
	public static void main(String[] args) {
		String input = "02"; // No cannot start from 0 or null
		PossibleDecoding possibleDecoding = new PossibleDecoding();
		int result = possibleDecoding.decode(input.toCharArray());
		System.out.println("result is " + result);
	}
}

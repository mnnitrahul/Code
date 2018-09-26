package code.array.old;

public class RemoveDuplicates {

	public void modifiedString(char[] input) {
		int start = 0;
		int i = 1;
		while ( i < input.length) {
			if (input[i] == input[start]) {
				while ( i < input.length && input[i] == input[start]) {
					i++;
				}
				start--;
			} else {
				start++;
				input[start] = input[i];
				i++;
			}
		}
		start++;
		String result = new String(input, 0, start);
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		String s = "azxxxxxza";
		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		removeDuplicates.modifiedString(s.toCharArray());
	}
}

package code.array.old;

/**
 * http://www.geeksforgeeks.org/maximum-length-bitonic-subarray/
 * @author agarwalr
 *
 */
public class BitonicArray {
	public int maxSize(int[] arr) {
		int max = 1;
		int localMax = 1;
		int start = 0;
		int end = 0;
		boolean isIncreasing = true;
		for (int i = 1; i < arr.length; ++i) {
			if(isIncreasing) {
				if (arr[i] < arr[i-1]) {
					isIncreasing = false;
				}
				localMax++;
				if (max < localMax) {
					max = localMax;
					end = i;
				}
			} else {
				if (arr[i] < arr[i-1]) {
					localMax++;
					if (max < localMax) {
						max = localMax;
						end = i;
					}
				} else {
					isIncreasing = true;
					localMax = 2;
					start = i-1;
				}
				
			}
		}
		System.out.println("start and end is " + start + " " + end);
		return max;
	}
	public static void main(String[] args) {
		int[] arr =  {40, 30, 20, 10};
		BitonicArray bitonicArray = new BitonicArray();
		int result = bitonicArray.maxSize(arr);
		System.out.println("result is" + result) ;
	}
}

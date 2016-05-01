package array;

import java.util.ArrayList;
import java.util.Arrays;

public class Bitonic {

		public int run(ArrayList<Integer> a) {
			Boolean isDecreasing = false;
			int count  = 0;
			int max = 0;
			int last = -1;
			for (int val : a) {
				if(val < last) {
					count++;
					isDecreasing = true;
				} else {
					if (isDecreasing == false) {
						count++;
					} else {
						max = max > count? max : count;
						isDecreasing = false;
						count = 2;
					}
				}
				last = val;
			}
			max = max > count? max : count;
			return max;
		}
		
		public static void main(String[] args){

			
			Integer[] arr = {1, 2, 3, 3 , 1 , 3};
			ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(arr));
			Bitonic b = new Bitonic();
			int result = b.run(a);
			System.out.println("result is " + result);
		}
}

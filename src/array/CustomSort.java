package array;

import java.util.*;

public class CustomSort implements Comparator<Integer>{
	
	private ArrayList<Integer> sortArr;
	
	public  CustomSort(List<Integer> sortArr) {
		this.sortArr = new ArrayList<Integer>(sortArr);
	}
	
	@Override
	public int compare(Integer o1, Integer o2) {
		for (Integer i : sortArr) {
			if (i.equals(o1)) {
				return -1;
			} else if (i.equals(o2)) {
				return 1;
			}
			if (o1.equals(o2)) {
				return 0;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Integer[] arr = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
		Integer[] sortArr = {2, 1, 8, 3, 6};
		CustomSort sortClass = new CustomSort(Arrays.asList(sortArr));
		Collections.sort(Arrays.asList(arr), sortClass);
		System.out.println(Arrays.asList(arr));
	}
}

package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class MaxArea {
	class rect {
		int pos;
		int height;
		public rect(int i, int j) {
			pos = i;
			height = j;
		}
	}
	
	/* For Each index assume i is included. Then calculate Max Left and Right that we can go from here
	 * If i element is less previous then include left element in result.
	 * 
	 */
	
	 public ArrayList<Integer> leftRun(ArrayList<Integer> a) {
		 Stack<rect> s = new Stack();
		 ArrayList<Integer> L = new ArrayList<Integer>();
		 int i = 0;
		 s.push(new rect(-1, -1));
		 for (int val : a) {
				rect top = s.peek();
			 	while (top.height > val) {
			 		s.pop();
		 			top = s.peek();
			 	}
		 		L.add(i-top.pos-1);	 
			 rect r = new rect(i, val);
			 s.push(r);	
			 i++;
		 }
		 return L;
	 }
	 
	 public static void main(String[] args) {
		 ArrayList<Integer> a = new ArrayList<Integer>();
		 a.add(9);
		 a.add(6);
		 a.add(2);
		 a.add(1);
		 a.add(3);
		 a.add(5);
		 a.add(4);
		 a.add(8);
		 a.add(2);
		 a.add(7);
		 MaxArea m = new MaxArea();
		 ArrayList<Integer> L = m.leftRun(a);
		 Collections.reverse(a);
		 ArrayList<Integer> R = m.leftRun(a);
		 Collections.reverse(R);
		 Collections.reverse(a);
		 int max = 0;
		 int index =-1;
		 for (int i = 0;i<a.size();++i) {
			 int s = a.get(i)*(L.get(i)+R.get(i)+1);
			 index = s > max? i:index;
			 max = s > max? s:max;
			 
		 }
		 System.out.println(max + " " + index);
	 }
	 
}

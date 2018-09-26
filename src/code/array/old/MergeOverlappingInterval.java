package code.array.old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class MergeOverlappingInterval {
	
	public MergeOverlappingInterval() {
		
	}
	public void merge() {
		
	}
	
	public static void main(String[] args) {
		ArrayList<Pair> pairs = new ArrayList<Pair>();
/*		pairs.add(new Pair(6, 8));
		pairs.add(new Pair(1, 9));
		pairs.add(new Pair(2, 4));
		pairs.add(new Pair(4, 7));*/
/*		pairs.add(new Pair(6, 8));
		pairs.add(new Pair(1, 3));
		pairs.add(new Pair(2, 4));
		pairs.add(new Pair(4, 7));*/
		pairs.add(new Pair(1, 3));
		pairs.add(new Pair(7, 9));
		pairs.add(new Pair(4, 7));
		pairs.add(new Pair(10, 13));
		
		Collections.sort(pairs);
		Stack<Pair> s = null ;
		for (Pair pair : pairs) {
			if (s == null) {
				s = new Stack<Pair>();
				s.push(pair);
				continue;
			}
			Pair top = s.peek();
			if (top.getEnd() >= pair.getStart()) {
				int biggerEnd = pair.getEnd();
				if (biggerEnd < top.getEnd()) {
					biggerEnd = top.getEnd();
				}
				Pair p = new Pair(top.getStart(), biggerEnd);
				s.pop();
				s.push(p);
				continue;
			}
			s.push(pair);
		}
		for (Pair p : s) {
			System.out.println(p.getStart() + " " + p.getEnd());
		}
	}
	
}

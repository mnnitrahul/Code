package array;

public class Pair implements Comparable<Pair>{
	private Integer start;
	private Integer end;
	public Pair(Integer i, Integer j) {
		start = i;
		end = j;
	}
	public Integer getStart() {
		return start;
	}
	public Integer getEnd() {
		return end;
	}
	@Override
	public int compareTo(Pair o) {
		if (getStart() < o.getStart()) {
			return -1;
		}
		if (getStart() > o.getStart()) {
			return 1;
		}
		// TODO Auto-generated method stub
		return 0;
	}
	
}

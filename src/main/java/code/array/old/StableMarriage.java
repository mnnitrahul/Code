package code.array.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Man {
	ArrayList<Woman> womenPreference;
	Woman preferedWoman;
	int id;
	public Man(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setPreferences(ArrayList<Woman> women) {
		womenPreference = women;
	}
	public ArrayList<Woman> getPreferences() {
		return womenPreference;
	}
	public void assignWoman(Woman woman) {
		this.preferedWoman = woman;
	}
	public Woman getAssignedWoman() {
		return preferedWoman;
	}
	public void deleteAssignedWoman() {
		preferedWoman = null;
	}
}

class Woman {
	ArrayList<Man> menPreferences;
	Man preferedMan;
	int id;
	public Woman(int id) {
		preferedMan = null;
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public void setPreferences(ArrayList<Man> men) {
		menPreferences = men;
	}
	public void assignMan(Man man) {
		this.preferedMan = man;
	}
	public Man getAssignedMan() {
		return preferedMan;
	}
	public boolean isPrefered(Man newMan) {
		for (Man man : menPreferences) {
			if (man == preferedMan) {
				return false;
			}
			if (man == newMan) {
				return true;
			}
		}
		return true;
	}
	public boolean isFree() {
		if (preferedMan == null) {
			return true;
		}
		return false;
	}
}

public class StableMarriage {
	
	
	public static void main(String[] args) {
		StableMarriage stableMarriage = new StableMarriage();
		Man man1 = new Man(0);
		Man man2 = new Man(1);
		Man man3 = new Man(2);
		Man man4 = new Man(3);
		Woman woman1 = new Woman(4);
		Woman woman2 = new Woman(5);
		Woman woman3 = new Woman(6);
		Woman woman4 = new Woman(7);
		Queue<Man> freeMen = new LinkedList<Man>();
		freeMen.add(man1);
		freeMen.add(man2);
		freeMen.add(man3);
		freeMen.add(man4);
		ArrayList<Woman> mlist1 = new ArrayList<Woman>();
		ArrayList<Woman> mlist2 = new ArrayList<Woman>();
		ArrayList<Woman> mlist3 = new ArrayList<Woman>();
		ArrayList<Woman> mlist4 = new ArrayList<Woman>();
		ArrayList<Man> wlist1 = new ArrayList<Man>();
		ArrayList<Man> wlist2 = new ArrayList<Man>();
		ArrayList<Man> wlist3 = new ArrayList<Man>();
		ArrayList<Man> wlist4 = new ArrayList<Man>();
		mlist1.addAll(Arrays.asList(woman1, woman2, woman3, woman4));
		mlist2.addAll(Arrays.asList(woman1, woman2, woman3, woman4));
		mlist3.addAll(Arrays.asList(woman1, woman2, woman3, woman4));
		mlist4.addAll(Arrays.asList(woman1, woman2, woman3, woman4));
		wlist1.addAll(Arrays.asList(man1, man2, man3, man4));
		wlist2.addAll(Arrays.asList(man1, man3, man2, man4));
		wlist3.addAll(Arrays.asList(man1, man2, man3, man4));
		wlist4.addAll(Arrays.asList(man1, man2, man3, man4));
		man1.setPreferences(mlist1);
		man2.setPreferences(mlist2);
		man3.setPreferences(mlist3);
		man4.setPreferences(mlist4);
		woman1.setPreferences(wlist1);
		woman2.setPreferences(wlist2);
		woman3.setPreferences(wlist3);
		woman4.setPreferences(wlist4);
		while(!freeMen.isEmpty()) {
			Man man = freeMen.poll();
			ArrayList<Woman> women = man.getPreferences();
			for (Woman woman : women) {
				if (woman.isFree()) {
	//				System.out.println("man id is " + man.getId() +  " woman " + woman.getId() + " is free");
					man.assignWoman(woman);
					woman.assignMan(man);
	//				System.out.println("women " + woman.getId() + " assigned man " + man.getId());
					break;
				} else {
					boolean preferred = woman.isPrefered(man);
					if (preferred == true) {
						Man assignedMan = woman.getAssignedMan();
						assignedMan.deleteAssignedWoman();
						freeMen.add(assignedMan);
						woman.assignMan(man);
						man.assignWoman(woman);
	//					System.out.println("woman " + woman.getId() + " preferred " + man.getId() + " over " + assignedMan.getId());
						break;
					}
				}
				
			}
		}
		System.out.println(man1.getAssignedWoman().getId() + " " + man1.getAssignedWoman().getAssignedMan().getId());
		System.out.println(man2.getAssignedWoman().getId() + " " + man2.getAssignedWoman().getAssignedMan().getId());
		System.out.println(man3.getAssignedWoman().getId() + " " + man3.getAssignedWoman().getAssignedMan().getId());
		System.out.println(man4.getAssignedWoman().getId() + " " + man4.getAssignedWoman().getAssignedMan().getId());
		
	}
}

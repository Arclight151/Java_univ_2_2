package chap07.hw2.rectangle_main;

import java.util.ArrayList;
import java.util.Random;

import chap07.hw2.rectangle_obj.Missile;
import chap07.hw2.rectangle_obj.Target;

class Setup {
	int areaX = 100, areaY = 100;				// Simulation Area
	int mx = 30, my = 30, mw = 40, mh = 30;		// Missile Size
	int tSize = 30;								// Target w, h
	Missile ms;
	ArrayList<Target> tList;
	ArrayList<Target> hitList;					// List for hit Targets
	
	public Setup() {
		ms = new Missile(mx, my, mw, mh);
		tList = new ArrayList<>();
		hitList = new ArrayList<>();
	}
	
	private void generateTargets(int count) {
		Random rand = new Random();
		for (int i = 0; i < count; i++) {
			Target tg = new Target(rand.nextInt(areaX-tSize+1), rand.nextInt(areaY-tSize+1), tSize);
			tList.add(tg);
		}
	}
	
	private boolean hitScan(Missile m, Target t) {
		if (((m.getX() + m.getW()) >= t.getX() && m.getX() <= (t.getX() + t.getW())) && ((m.getY() + m.getH()) >= t.getY() && m.getY() <= (t.getY() + t.getH())))
			return true;
		else
			return false;
	}
	
	private int hitCount(Missile m, ArrayList<Target> arl) {
		int count = 0, listSize = arl.size();
		for (int i = 0; i < listSize; i++) {
			if (hitScan(m, arl.get(i))) {
				hitList.add(arl.get(i));
				arl.set(i, null);	// Using set(null) instead of remove() to
				count++;			// prevent ArrayIndexOutOfBounds
			}
		}
		return count;
	}
	
	public void start() {
		generateTargets(5);
		int hit = hitCount(ms, tList);
		if (hit != 0)
			System.out.println(hit + " Targets Hit");
		else
			System.out.println("No Targets Hit");
		
		System.out.println("Targets Destroyed: ");
		if (hitList.size() == 0)
			System.out.println("None");
		else {
			for (int i = 0; i < hitList.size(); i++) {
				System.out.print("Target at ");
				hitList.get(i).printPos();
			}
		}
		
		System.out.println("Targets Remaining: ");
		for (int i = 0; i < tList.size(); i++) {
			if (tList.get(i) != null) {		// condition to prevent NullPointerException
				System.out.print("Target at ");
				tList.get(i).printPos();
			}
		}
	}
}

public class Ch07_hw2_MissileSim2 {

	public static void main(String[] args) {
		Setup s = new Setup();
		s.start();

	}

}

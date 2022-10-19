package chap07.hw2.rectangle_main;

import java.util.ArrayList;
//import java.util.Random;

import chap07.hw2.rectangle_obj.Missile;
import chap07.hw2.rectangle_obj.Target;

class Setup_2 {
	int areaX = 100, areaY = 100;
	int mx = 30, my = 30, mw = 40, mh = 30;
	int tSize = 30;
	Missile ms;
	ArrayList<Target> tList;
	ArrayList<Target> hitList;
	
	public Setup_2() {
		ms = new Missile(mx, my, mw, mh);
		tList = new ArrayList<>();
	}
	
//	private void generateTargets(int count) {
//		Random rand = new Random();
//		for (int i = 0; i < count; i++) {
//			Target tg = new Target(rand.nextInt(areaX-tSize+1), rand.nextInt(areaY-tSize+1), tSize);
//			tList.add(tg);
//		}
//	}
	
	private void manualGen() {
		Target tg = new Target(0, 0, tSize);
		tList.add(tg);
		tg = new Target(80, 0, tSize);
		tList.add(tg);
		tg = new Target(0, 75, tSize);
		tList.add(tg);
		tg = new Target(30, 0, tSize);
		tList.add(tg);
		tg = new Target(50, 50, tSize);
		tList.add(tg);
	}
	
	private boolean hitScan(Missile m, Target t) {
		if (((m.getX() + m.getW()) >= t.getX() && m.getX() <= (t.getX() + t.getW())) && ((m.getY() + m.getH()) >= t.getY() && m.getY() <= (t.getY() + t.getH())))
			return true;
		else
			return false;
	}
	
	private int hitCount(Missile m, ArrayList<Target> arl) {
		int count = 0;
		for (int i = 0; i < arl.size(); i++) {
			if (hitScan(m, arl.get(i))) {
				System.out.print("Hit: Target " + i + ": ");
				arl.get(i).printPos();
				arl.remove(i);
				i--;
				count++;
			}
		}
		return count;
	}
	
	public void start() {
//		generateTargets(5);
		manualGen();
		int hit = hitCount(ms, tList);
		if (hit != 0)
			System.out.println(hit + " Targets Hit");
		else
			System.out.println("No Targets Hit");
		
		System.out.println("Targets Remaining: ");
		for (int i = 0; i < tList.size(); i++) {
			if (tList.get(i) != null) {
				System.out.print("Target at ");
				tList.get(i).printPos();
			}
		}
	}
}

public class Ch07_hw2_MissileSim2_v2 {

	public static void main(String[] args) {
		Setup_2 s = new Setup_2();
		s.start();

	}

}

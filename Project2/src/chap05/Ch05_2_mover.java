package chap05;

import java.util.Scanner;

abstract class Mover {
	int x, y;
	Mover(int x, int y) { this.x = x; this.y = y; }
	abstract void move();
	int getx() { return x; }
	int gety() { return y; }
}

class Bear extends Mover {
	private char icon = 'B';
	private Scanner sc;
	
	Bear(int x, int y) {
		super(x, y);
		sc = new Scanner(System.in);
	}
	
	public char getIcon() { return icon; }

	public void move() {
		System.out.print("Move: Up(w) / Down(s) / Left(a) / Right(d): ");
		String key = sc.next();
		switch(key) {
		case("w"):
			this.y--;
			if (this.y < 0)
				this.y = 0;
			break;
		case("s"):
			this.y++;
			if (this.y >= PlayEx.mapX)
				this.y = PlayEx.mapX - 1;
			break;
		case("a"):
			this.x--;
			if (this.x < 0)
				this.x = 0;
			break;
		case("d"):
			this.x++;
			if (this.x >= PlayEx.mapY)
				this.x = PlayEx.mapY - 1;
			break;
		}
	}
}

class Fish extends Mover {
	Fish(int x, int y) {
		super(x, y);
	}

	public void move() {}
		
}

class PlayEx {
	static int mapX = 10;
	static int mapY = 15;
	char[][] map;
	Bear br;
	public PlayEx() {
		map = new char[mapX][mapY];
		br = new Bear(7, 5);
		for (int i = 0; i < mapX; i++) {
			for (int j = 0; j < mapY; j++) {
				map[i][j] = '-';
			}
		}
		
	}
	
	void updateMap() {
		map[br.gety()][br.getx()] = br.getIcon();
	}
	
	void clearMap() {
		map[br.gety()][br.getx()] = '-';
	}
	
	public void drawMap() {
		updateMap();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		clearMap();
	}
}

public class Ch05_2_mover {

	public static void main(String[] args) {
		PlayEx p = new PlayEx();
		while(true) {
			p.drawMap();
			p.br.move();
		}

	}

}

package chap05.game.play;

import chap05.game.fish.Fish;
import chap05.game.bear.Bear;

public class Play {
	public static final int mapX = 10, mapY = 15;
	public static final int INGAME = 0, FISHWIN = 1, BEARWIN = 2;
	public static int gameState = INGAME;
	char[][] map = new char[mapX][mapY];
	Bear br;
	Fish fs;
	
	private void initMap() {
		for (int i = 0; i < mapX; i++) {
			for (int j = 0; j < mapY; j++) {
				map[i][j] = '-';
			}
		}
	}
	
	private void updateMap() {
		map[fs.gety()][fs.getx()] = fs.getIcon();
		map[br.gety()][br.getx()] = br.getIcon();
	}
	
	private void clearMap() {
		map[br.gety()][br.getx()] = '-';
		map[fs.gety()][fs.getx()] = '-';
	}
	
	private void drawMap() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void start() {
		System.out.println("Starting...");
		initMap();
		
		br = new Bear((int)(Math.random() * mapY), (int)(Math.random() * mapX));
		fs = new Fish(mapY / 2, mapX / 2);
		
		updateMap();
		drawMap();
		while(gameState == INGAME) {
			clearMap();
			br.move();
			fs.move();
			if (br.getx() == fs.getx() && br.gety() == fs.gety())
				gameState = BEARWIN;
			if (gameState != INGAME)
				break;
			updateMap();
			drawMap();
		}
		if (gameState == BEARWIN) {
			updateMap();
			drawMap();
			System.out.println("Fish Caught! Bear Wins!");
		}
		else
			System.out.println("Fish Escaped! Fish Wins!");
	}

	public static void main(String[] args) {
		Play p = new Play();
		p.start();

	}

}

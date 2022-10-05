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
	
	void initMap() {
		for (int i = 0; i < mapX; i++) {
			for (int j = 0; j < mapY; j++) {
				map[i][j] = '-';
			}
		}
	}
	
	public void start() {
		while(gameState == INGAME) {
			
		}
	}

	public static void main(String[] args) {
		

	}

}

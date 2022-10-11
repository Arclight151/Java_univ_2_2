package chap05.game.fish;

import chap05.game.mover.Mover;
import chap05.game.play.Play;

public class Fish extends Mover {
	private char icon = 'F';

	public Fish(int x, int y) {
		super(x, y);
	}

	public char getIcon() { return icon; }

	public void move() {
		boolean escape = false;
		int rand = (int)(Math.random() * 8);
		switch(rand) {
		case 0:
			this.x++;
			if (this.x > Play.mapY - 1)
				escape = true;
			break;
		case 1:
			this.x--;
			if (this.x < 0)
				escape = true;
			break;
		case 2:
			this.y++;
			if (this.y > Play.mapX - 1)
				escape = true;
			break;
		case 3:
			this.y--;
			if (this.y < 0)
				escape = true;
			break;
		default:
			break;
		}
		if (escape) {
			Play.gameState = Play.FISHWIN;
		}
	}
	

}

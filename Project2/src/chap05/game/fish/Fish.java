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
		int rand = (int)(Math.random() * 8);
		switch(rand) {
		case 0:
			this.x++;
			break;
		case 1:
			this.x--;
			break;
		case 2:
			this.y++;
			break;
		case 3:
			this.y--;
			break;
		default:
			break;
		}
		if (true) { // TODO: add condition
			Play.gameState = Play.FISHWIN;
		}
	}
	

}

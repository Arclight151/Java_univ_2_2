package chap05.game.bear;

import java.util.Scanner;
import chap05.game.mover.Mover;
import chap05.game.play.Play;

public class Bear extends Mover {
	private char icon = 'B';
	private Scanner sc;

	public Bear(int x, int y) {
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
			if (this.y >= Play.mapX)
				this.y = Play.mapX - 1;
			break;
		case("a"):
			this.x--;
			if (this.x < 0)
				this.x = 0;
			break;
		case("d"):
			this.x++;
			if (this.x >= Play.mapY)
				this.x = Play.mapY - 1;
			break;
		}
	}

}

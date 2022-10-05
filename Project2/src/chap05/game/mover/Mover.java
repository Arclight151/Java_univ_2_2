package chap05.game.mover;

public abstract class Mover {
	protected int x, y;
	public Mover(int x, int y) { this.x = x; this.y = y; }
	public abstract void move();
	public int getx() { return x; }
	public int gety() { return y; }

}

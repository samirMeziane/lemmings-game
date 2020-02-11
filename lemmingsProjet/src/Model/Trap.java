package Model;

public class Trap extends Obstacle{

	public Trap(int x, int y, int t, int l) {
		super(x, y, t, l);
			}

	@Override
	public String typeOf() {
		return "Trap";
	}

}

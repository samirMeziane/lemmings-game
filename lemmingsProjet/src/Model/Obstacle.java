package Model;

import java.awt.Color;

public abstract class Obstacle extends Bloc{	
	protected boolean deletable;

	
	public boolean isDeletable() {
		return deletable;
	}
	public void setDeletable(boolean deletable) {
		this.deletable = deletable;
	}
	public Obstacle(int x, int y,int t ,int l) {
		super(x, y,t,l);
		this.deletable=false;
		
	}
	public abstract String typeOf();
}

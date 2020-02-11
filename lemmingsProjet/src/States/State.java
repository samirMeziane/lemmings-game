package States;

import Model.Game;
import Model.Lemming;

public abstract class State {
	protected Game j;
	public State(Game j) {
		this.j=j;
	}

	public abstract void step(Lemming l);
	
	
	
}

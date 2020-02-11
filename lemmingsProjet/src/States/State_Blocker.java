package States;

import Model.Game;
import Model.Lemming;

public class State_Blocker extends State {
String url="images/block.png";
	public State_Blocker(Game j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void step(Lemming l) {
		
		if(l.ObstacleBottom()) {
			l.setUrl(url);
			AddtoBloqueur(l);
		}else l.setState(new State_Walker(j));}
	
	public void AddtoBloqueur(Lemming l) {
		this.j.getListeLemmingBloqueur().add(l);
	}



}

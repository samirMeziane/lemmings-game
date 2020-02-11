package States;

import Model.Game;
import Model.Lemming;

public class State_driller extends State {
private int compteur;
	public State_driller(Game j) {
		super(j);
		
		this.compteur=0;
	}

	@Override
	public void step(Lemming l) {
	if(l.getLandBottom()!=null){
		if(compteur<=5) {
	l.getLandBottom().setDeletable(true);

	l.setPosY(l.getPosY()+20);
	}else l.setState(new State_Walker(j));
		}else
		l.setState(new State_Walker(j));
		
	}

	

	
}

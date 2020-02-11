package States;

import Model.Direction;
import Model.Game;
import Model.Lemming;

public class State_digger extends State {
int compteur;
	public State_digger(Game j) {
		super(j);
this.compteur=0;
	}

	@Override
	public void step(Lemming l) {
		if(l.getDirection()==Direction.DROITE) {
			if(l.touchTrapRight()) {
			l.getObstacleRight().setDeletable(true);
				l.setDead(true);
		}
			
			if(l.touchLandRight()) {
			l.getObstacleRight().setDeletable(true);
			l.setPosX(l.getPosX()+l.getObstacleRight().getLargeur());
				
			}else { 
				if(compteur<3 && l.getObstacleRight()==null) {
					if(l.TouchIronRight()) {
						l.setPosX(l.getPosX()+10);
						l.setState(new State_Walker(j));
					}else {
					l.setPosX(l.getPosX()+10);
					compteur++;}
				}else
				l.setState(new State_Walker(j));}
		}else if(l.getDirection()==Direction.GAUCHE)  {
			
			if(l.touchTrapLeft()) {
				l.getObstacleLeft().setDeletable(true);
				l.setDead(true);
		}
			if(l.touchLandLeft()) {
				l.getObstacleLeft().setDeletable(true);
				l.setPosX(l.getPosX()-l.getObstacleLeft().getLargeur());	
			}else
			{ 
				if(compteur<3 && l.getObstacleLeft()==null) {
					if(l.TouchIronLeft()) {
						l.setPosX(l.getPosX()+10);
						l.setState(new State_Walker(j));
					}else
					
					l.setPosX(l.getPosX()-10);
					compteur++;
				}else
				l.setState(new State_Walker(j));}
			}

}

}

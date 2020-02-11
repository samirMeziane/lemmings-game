package States;

import Model.Direction;
import Model.Game;
import Model.Land;
import Model.Lemming;

public class State_carpenter extends State {
private int contruction=0;
//State s=new State_Bloqueur(j);
	public State_carpenter(Game j) {
		super(j);
	
	}

	@Override
	public void step(Lemming l) {
		int x=l.getPosX();
		int y=l.getPosY();
		if(l.getDirection()==Direction.DROITE) {
		if(contruction<5) {
		j.addObstacle(new Land(x+10, y, 10,20));
		
		contruction++;  
		x=x+10;
		y-=20;
		l.setPosX(x);
		l.setPosY(y);
		if(l.touchLandRight()|| l.TouchIronRight()) {
			l.setState(new State_Walker(j));
		}
		}else {
			l.setState(new State_Walker(j));
		}
	}else {
		if(contruction<5) {
			j.addObstacle(new Land(x, y, 10,20));
			
			contruction++;
			x=x-10;
			y-=20;
			l.setPosX(x);
			l.setPosY(y);
			if(l.touchLandLeft()|| l.TouchIronLeft()) {
				l.setState(new State_Walker(j));
			}
			}else {
				l.setState(new State_Walker(j));
			}
	}
		
		
	}



}

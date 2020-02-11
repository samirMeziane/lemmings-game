package States;

import Model.Direction;
import Model.Game;
import Model.Lemming;
import Model.Obstacle;

public class State_Walker extends State {
	private String url = "images/walkl.png";
	private String urll = "images/walkr.png";
	public State_Walker(Game j) {
		super(j);
		
		
	}
public void step(Lemming l) {
if(l.getDirection()==Direction.DROITE && l.ObstacleBottom()) {
	l.setUrl(urll);
if(l.getObstacleRight()!=null) {
		Obstacle o=l.getObstacleRight();
		
		if(!j.Abovethis(o.getPosX(), o.getPosY()) && !j.Abovethis(o.getPosX()-10, o.getPosY())) {
		
			l.Climb();
			l.setPosX(l.getPosX()+l.getDirection().getX());
		}else {
		l.setDirection(Direction.GAUCHE);
		
		l.setUrl(url);
		}
	}else if(l.touchBlockerFromRight()) {l.setDirection(Direction.GAUCHE);
	
	l.setUrl(url);}
	else
	l.setPosX(l.getPosX()+l.getDirection().getX());

}
	
if(l.getDirection()==Direction.GAUCHE && l.ObstacleBottom()) {
	l.setUrl(url);
	
	 
	/*
	
	}*/
	if(l.getObstacleLeft()!=null) { Obstacle o=l.getObstacleLeft();
	if(!j.Abovethis(o.getPosX(), o.getPosY()) && !j.Abovethis(o.getPosX()+10, o.getPosY())) {
		
		l.Climb();
		l.setPosX(l.getPosX()+l.getDirection().getX());
	
	}else {
		l.setDirection(Direction.DROITE);
		l.setUrl(urll);	}	
	}else if(l.touchBlockerFromLeft()) {l.setDirection(Direction.DROITE);
	
	l.setUrl(urll);}else {
		l.walkLeft();
		if(l.contactPortal()) {
			l.setPosY(20);
		}
}
	

}

if(!l.ObstacleBottom()) {
	
l.setChute(l.getChute()+1); 

l.setPosY(l.getPosY()+20);}else {

if(l.getChute()>=5 && l.ObstacleBottom()) {
	l.setDead(true);
}else {
	l.setDead(false);
	l.setChute(0);
}
}
}

}
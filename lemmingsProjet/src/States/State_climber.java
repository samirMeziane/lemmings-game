package States;

import Model.Game;
import Model.Lemming;
import Model.Obstacle;

public class State_climber extends State {
private int compteur ;
String url1="images/climbr.png";
String url2="images/climbl.png";
	public State_climber(Game j) {
		super(j);
		this.compteur=0;
		//System.out.println("je suis grimpeur !!");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void step(Lemming l) {
		
		if(l.getDirection()==l.getDirection().GAUCHE) {
			l.setUrl(url2);
		if(l.getObstacleLeft()!=null){
			Obstacle o=l.getObstacleLeft();
			int x=o.getPosX();
			int y=o.getPosY();
			if(j.Abovethis(x,y)  ) {
				if(!j.Abovethis(x+20, y)) {
			y=y-20;}else
			l.setState(new State_Walker(j));
	        }else {
			l.setPosX(l.getPosX()-20);l.setState(new State_Walker(j));
			}
	    if(l.getPosY()>y-20) {
			l.setPosY(l.getPosY()-20);
			}}else {
		if(compteur<=5) {
		    l.setPosX(l.getPosX()-10);
		    compteur++;}else {
		    l.setPosX(l.getPosX()-10);	
		    l.setState(new State_Walker(j));
		    
		    }}

		
	
		}else {
			l.setUrl(url1);
		    if(l.getObstacleRight()!=null) {
			Obstacle o=l.getObstacleRight();
			int x=o.getPosX();
			int y=o.getPosY();
			if(this.j.Abovethis(x,y)){
				if(!j.Abovethis(x-20, y)) {
			y=y-20;	}
			else {l.setPosX(l.getPosX()+10); l.setState(new State_Walker(j));}}
			else {
			l.setPosX(l.getPosX()+20);l.setState(new State_Walker(j));
			}
			
			
	   if(l.getPosY()>y-20) {
			l.setPosY(l.getPosY()-20);
			}
	   }else {
			if(compteur<=5) {
			l.setPosX(l.getPosX()+10);
			compteur++;}else {
				l.setPosX(l.getPosX()+10);
			l.setState(new State_Walker(j));}
		}}}


}
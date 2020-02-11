package Model;

import java.io.IOException;

import States.State;
import States.State_Walker;
import Vue.Gui;





public class Lemming extends Bloc{
private State state;	
private Direction direction;

private int chute;
private Game j;
private boolean isDead;
private boolean isArrived;
	
public Lemming(int x, int y, Game jeu,int t,int l)  {
		super(x, y,t,l);
		direction = Direction.DROITE;
		chute = 0;
		this.isDead=false;
		this.isArrived=false;
		this.j=jeu;
		state=new State_Walker(jeu);
		this.url="images/walkr.png";
	
	}
	
	
public void step() {
		this.state.step(this);
	}
	
public boolean isDead() {
		return isDead;
	}

public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
/*public String role(){
		return state.toString();
	}*/


public State getState() {
		return state;
	}

public void setState(State state) {
		this.state = state;
	}

public Direction getDirection() {
		return direction;
	}

public void setDirection(Direction direction) {
		this.direction = direction;
	}

public int getChute() {
		return chute;
	}

public void setChute(int chute) {
		this.chute = chute;
	}

public Game getGame() {
		return j;
	}

public void setGame(Game j) {
		this.j = j;
	}
	
public void Climb() {
		y=y-20;
	}
	


public void walkRight() {
			x=x+direction.DROITE.getX();}


public void walkLeft() {
			x=x+direction.GAUCHE.getX();
		}

public void TouchLava() {
int y=this.j.getYlave();
if(this.getPosY()+this.getLongeur()==y) {
	System.out.println(y+"haha");
	setDead(true);}

}

public void LemmingOut() {
if(this.x==850 || this.x==0) {
setDead(true);
}


}
public boolean TouchIronRight() {
	Obstacle obs=this.j.getTypeObstacle(x+largeur, this.y);
	if(obs!=null) {
		if(obs instanceof Iron) {
			return true;}}
		return false;
}

public boolean TouchIronLeft() {
	Obstacle obs=this.j.getTypeObstacle(x-10, this.y);
	if(obs!=null) {
		if(obs instanceof Iron)  {
			return true;}}
		return false;
	
}

public void TouchExitDoor() {
	
int xs=(j.getExitDoor().getPosX());
//System.out.println(xs);
if(this.x==xs && this.y==j.getExitDoor().getPosY()) {
	System.out.println("karamba !");
setIsArrived(true);	
	
}

}

public boolean IsArrived() {
	return isArrived;
}


public void setIsArrived(boolean estArrivé) {
	this.isArrived = estArrivé;
}


public Obstacle getLandBottom() {
	Obstacle obs=this.j.Bottom(x,y+longeur);
	if(obs!=null) {
		if(obs instanceof Land) {
			return obs;
		}
	}
	return null ;
}
public boolean touchLandRight() {
	Obstacle obs=this.j.getTypeObstacle(x+largeur,y);
	if(obs!=null) {
		if(obs instanceof Land) {
		
			 
			return true;}}
		return false;
}

public boolean touchLandLeft() {
	Obstacle obs=this.j.getTypeObstacle(x-20, this.y);
	if(obs!=null) {
		if(obs instanceof Land) {
			return true;}}
		return false;}

public boolean touchBlockerFromRight() {
	Lemming l=this.j.getBloqueur(x+largeur,y);
	if(l!=null)return true;
	return false ;
}

public boolean touchBlockerFromLeft() {
	Lemming l=this.j.getBloqueur(x-20,y);
	if(l!=null)return true;
	return false ;
	
}

public boolean contactPortal() {
if(this.x/20==j.getPortal().getPosX()/20 && this.y/20==j.getPortal().getPosY()/20)return true;
return false;
	
}


public Obstacle getObstacleLeft() {
	
	return j.getTypeObstacle(x-20,y);
}
public Obstacle getObstacleRight() {
	
	return j.getTypeObstacle(x+largeur,y);
}




public boolean touchTrapLeft() {
	Obstacle obs=this.j.getTypeObstacle(x-20, this.y);	
	if(obs!=null) {
		if(obs instanceof Trap) {
			return true;}}
		return false;
}	
public boolean touchTrapRight() {
	Obstacle obs=this.j.getTypeObstacle(x+10, this.y);	
	if(obs!=null) {
		if(obs instanceof Trap) {
			return true;}}
		return false;
}	
	
public boolean ObstacleBottom(){
Obstacle  o=this.j.Bottom(x, y+longeur);
if(o!=null) {
	return true;}
else return false;}





}

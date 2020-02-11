package States;

import Model.Direction;
import Model.Game;
import Model.Land;
import Model.Lemming;
import Model.Trap;

public class State_Bombeur extends State {
	String url1="images/bomberr.png";
	String url2="images/bomberl.png";
int compteur=0;
	public State_Bombeur(Game j) {
		super(j);}

	@Override
	public void step(Lemming l) {
		
		exploserObstacle(l);
	}
	
	
	
public void exploserObstacle(Lemming l) {
	if(l.getDirection()==Direction.DROITE) {
		l.setUrl(url1);
		if(l.getObstacleRight()!=null) {
		if(l.getObstacleRight()instanceof Land) {
			l.getObstacleRight().setDeletable(true);
			
		}else if(l.getObstacleRight() instanceof Trap) {
			l.getObstacleRight().setDeletable(true);
			l.setDead(true);
		}
		}if(compteur<3){
		l.setPosX(l.getPosX()+10);
		compteur++;}else l.setDead(true);
		}else {
		l.setUrl(url2);
		if(l.getObstacleLeft()!=null) {
		if(l.getObstacleLeft() instanceof Land) {
		l.getObstacleLeft().setDeletable(true);
					
		}else if(l.getObstacleLeft() instanceof Trap) {
		l.getObstacleLeft().setDeletable(true);
		l.setDead(true);
		}
			
		}if(compteur<3){
			l.setPosX(l.getPosX()-10);
			compteur++;}else l.setDead(true);}
	
}



}

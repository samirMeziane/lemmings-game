package States;

import Model.Direction;
import Model.Game;
import Model.Lemming;

public class State_Parachutiste extends State{
	String url1="images/parar.png";
	String url2="images/paral.png";
	public State_Parachutiste(Game j) {
		super(j);
		System.out.println("parachuuta!");
		// TODO Auto-generated constructor stub
	}

	public void step(Lemming l){
//	l.setChute(0);
	//if(l.getChute()<5) {
	if(!l.ObstacleBottom()) { 
	if(l.getDirection()==Direction.DROITE) {
	l.setUrl(url1);}else {
		l.setUrl(url2);}
	
	l.setPosY(l.getPosY()+10);}else {l.setState(new State_Walker(j));		
	l.setChute(0);	/*if(l.getDirection()==Direction.DROITE) {
		l.setUrl("images/walkr.png");}else {
			l.setUrl("images/walkl.png");}
		l.setState(new State_creuseur(j));*/
		
}

	//}
	

}

	
	
}
	


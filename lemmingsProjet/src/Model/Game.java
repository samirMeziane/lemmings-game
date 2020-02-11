package Model;

import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import Controleur.AuditeurGrille;
import States.State;
import States.State_Blocker;
import States.State_Bombeur;
import States.State_Parachutiste;
import States.State_Walker;
import States.State_carpenter;
import States.State_climber;
import States.State_digger;
import States.State_driller;
import Vue.Gui;
//import States.*;

public class Game{
	//private int niveau;

	
	private int nbLemmingsSauvé;
	private ArrayList<Obstacle> listeO;
	private ArrayList<Lemming>listeLemmingBloqueur;
	 	
	private Gate FrontDoor;
	private Gate ExitDoor;
	private Gate Portal;
	public String selectedState; 				//role selectionne par le joueur
	private AuditeurGrille auditeurG;		
	private int Length;
	private int Width ;
	private ArrayList<GameObserver>lemmingObserv;
	private ArrayList<Lemming> listeL;
	
	
	

	public Game(int largeur,int taille){

	this.selectedState = "Marcheur";
	auditeurG = new AuditeurGrille(this);
	this.nbLemmingsSauvé=0;
	listeL = new ArrayList<Lemming>();
	listeO = new ArrayList<Obstacle>();	
	this.Length=taille;
	this.Width=largeur;
	listeLemmingBloqueur=new ArrayList<>();
	this.lemmingObserv=new ArrayList<>();
	
	}
	
	public Gate getFrontDoor() {
		return FrontDoor;
	}

	public void setFrontDoor(Gate FrontDoor) {
		FrontDoor = FrontDoor;
	}

	public Gate getExitDoor() {
		return ExitDoor;
	}

	public void setExitDoor(Gate ExitDoor) {
		ExitDoor = ExitDoor;
	}

	public Gate getPortal() {
		return Portal;
	}

	public void setPortal(Gate portal) {
		this.Portal = portal;
	}
	
	
	public Gate getPortaile() {
		return Portal;
	}
	


	public void notifyObserver() {
	for(GameObserver l : this.lemmingObserv) {
		l.notiffy();
	}
		
	}


	
	
	public void register(GameObserver l) {
		this.lemmingObserv.add(l);}
	
	
	public void unregister(GameObserver l ) {
		this.lemmingObserv.remove(l);}
	

	public ArrayList<Lemming> getListeLemmingBloqueur() {
		return listeLemmingBloqueur;
	}
	
	

	public void setListeLemmingBloqueur(ArrayList<Lemming> listeLemmingBloqueur) {
		this.listeLemmingBloqueur = listeLemmingBloqueur;
	}

	
	public int getLength() {
		return Length;
	}

	
	public void setLength(int Length) {
		this.Length = Length;
	}
	
	public void addObstacle(Obstacle o) {
	listeO.add(o);	
		
	}

	public int getWidth() {
		return Width;
	}

	public void setWidth(int Width) {
		this.Width = Width;
	}
	
	
	public Obstacle getTypeObstacle(int x,int y) {
		for(Obstacle o: this.listeO ){
			
			if(x==o.x && y==o.y ) {
			return o;	
			}}
		return null;
		}
	
	
	public Obstacle Bottom(int x,int y) {
	for(Obstacle o:listeO ){
			
			if(x>=o.x && x<o.x+20 && y==o.getPosY()) {
				
				return o;
			}
		}
		return null;
	}
	
	public boolean Abovethis(int x,int y) {
		for(Obstacle o: this.listeO) {
			if(o.x==x && o.y+o.longeur==y) {
				return true;
			}}return false;}
	
	
	public int getYlave() {
		for(Obstacle o: this.listeO){
			if(o.typeOf()=="Lave") {
						return o.getPosY();
			}
		}
		return 0;
	}
	public void createLemmings() {
		this.listeL.add(new Lemming(this.FrontDoor.x,this.FrontDoor.y,this,10,20));
	}

	
	public void changeLemmingState(int x,int y){
		for(Lemming l: this.listeL){
			if((x>=l.getPosX() && x<=l.getPosX()+20 )  && y>=l.getPosY() && y<=l.getPosY()+20 ) {
				l.setState(selectedState(this.selectedState));
				//selectedState(selectedState);
				}}}
	
	public void Run() {
	

int i=0;
int tmp=0;
int nbLemming=8;

while(nbLemming>0) {

			if(i<8 && tmp==0) {
			createLemmings();i++;
			tmp=4;
			}
			tmp--;
			try {Thread.sleep(500);
		Iterator<Lemming> iterator1 = listeL.iterator();
		
		while ( iterator1.hasNext() ) {
Lemming l = iterator1.next();

l.TouchLava();
l.LemmingOut();
l.TouchExitDoor();

	if(!l.isDead()) {
		
	l.step();}else {

		iterator1.remove();
		nbLemming--;
	}
	if(l.IsArrived()) {
		nbLemmingsSauvé++;
		iterator1.remove();
		nbLemming--;
		}
	Iterator<Obstacle> iterator2 = listeO.iterator();
	while(iterator2.hasNext()) {
		Obstacle o=iterator2.next();

		if(o.isDeletable()) {
		iterator2.remove();
		}
	}
	
	
	/*ArrayList<LemmingsEvent>Event=new ArrayList<>();
Event.add(new LemmingsEvent(ChangeType.valueOf(this.selectedState)));*/
//System.out.println(Event.get(0).toString());
notifyObserver();

		}
			}catch(InterruptedException e){e.printStackTrace();}
		}
JOptionPane.showMessageDialog(null, "Score : "+nbLemmingsSauvé+" /8 lemmings sauves et", "Fin", JOptionPane.INFORMATION_MESSAGE);
	

 		
		
	}
	





	public State selectedState(String s){
		
		selectedState = s;
		switch (s) {
		case "Bloqueur":
			return new State_Blocker(this);
			
		case "Bombeur":
			return new State_Bombeur(this);
			
		case "Charpentier":
			return new State_carpenter(this);
			
		case "Foreur":
			return new State_driller(this);
			
		case "Grimpeur":
			return new State_climber(this);
			
		case "Parachutiste":
			return new State_Parachutiste(this);
			
		case "Creuseur":
			return new State_digger(this);	
			
			default :
				return new State_Walker(this);
		}
	}
		
	
	public void chargerNiveau(){
		
		File f = new File("niveaux/niv1");
		InputStream in = null;
		try {
			in = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Reader lecteur = new InputStreamReader(in);
		int c;
		try {
			for(int i=0; i<30; i++){
				for(int j=0; j<45; j++){
					c = lecteur.read(); 
					
					switch (c) {
					
					case 49:
						listeO.add(ObstacleFactory.makeTerre(j*20,i*20,20,20));
						break;
					case 50:
						listeO.add(ObstacleFactory.makeLava(j*20,i*20,20,20));
						break;
					case 51:
						listeO.add(ObstacleFactory.makeMetal(j*20,i*20,20,20));
						break;
					case 52:
						this.FrontDoor= GateFactory.makeFrontDoor(j*20, i*20, 20, 20);
						break;
					case 53:
						ExitDoor= GateFactory.makeExitDoor(j*20, i*20, 20, 20);
						break;
					case 54:
						Portal= GateFactory.makePortal(j*20, i*20, 20, 20);
						break;
					case 56:
						listeO.add(ObstacleFactory.makeTrap(j*20, i*20,20, 20));
					default:
						break;
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
public Lemming getBloqueur(int x,int y) {
	for(Lemming lem : listeLemmingBloqueur){
		if(lem.getPosX()== x && lem.getPosY()==y) {
			return lem;
		}
	}
	
	return null;
}



public ArrayList<Lemming> getListeL() {
		return listeL;
}

public void setListeL(ArrayList<Lemming> listeL) {
		this.listeL = listeL;
	}

public ArrayList<Obstacle> getListeO() {
		return listeO;
	}

public void setListeO(ArrayList<Obstacle> listeO) {
		this.listeO = listeO;
	}

public String getSelectedState() {
		return selectedState;
	}

public void setSelectedState(String selectedState) {
		this.selectedState = selectedState;
	}

public AuditeurGrille getAuditeurG() {
		return auditeurG;
	}

public void setAuditeurG(AuditeurGrille auditeurG) {
		this.auditeurG = auditeurG;
	}


		
	
}

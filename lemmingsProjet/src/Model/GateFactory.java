package Model;

public class GateFactory {
	
public static Gate makeFrontDoor(int i,int j,int taille ,int largeur) {
	return new FrontDoor(i,j, taille,largeur);
	
}
public static Gate makeExitDoor(int i,int j,int taille ,int largeur) {
	return new Exit(i,j, taille,largeur);}

public static Gate makePortal(int i,int j,int taille ,int largeur) {
	return new Portal(i,j, taille,largeur);}
}                   

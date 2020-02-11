package Model;

public class ObstacleFactory {
	
public static Obstacle makeTerre(int i,int j,int hauteur,int largeur) {
return new Land(i,j,hauteur,largeur);}

public static Obstacle makeMetal(int i,int j,int hauteur,int largeur) {
return new Iron(i,j,hauteur,largeur);}

public static Obstacle makeTrap(int i,int j,int hauteur,int largeur) {
	return new Trap(i,j,hauteur,largeur);}

public static Obstacle makeLava(int i,int j,int hauteur,int largeur) {
	
	return new Lava(i,j,hauteur,largeur);}
}

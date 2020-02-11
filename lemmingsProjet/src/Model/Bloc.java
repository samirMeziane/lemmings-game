package Model;




import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Bloc {
	protected int x;
	protected int y;
	protected String url;
	protected int largeur;
	protected int longeur ;
	//protected boolean afficher;
	
	
	public Bloc(int x, int y,int largeur,int longeur){
		this.x=x;
		this.y=y;
		//this.setOpaque(false);
		//this.afficher = true;
		this.largeur=largeur;
		this.longeur=longeur;
	
	}
	



	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getLongeur() {
		return longeur;
	}

	public void setLongeur(int longeur) {
		this.longeur = longeur;
	}



	

	public int getPosX() {
		return x;
	}
	public void setPosX(int posX) {
		this.x = posX;
	}
	public int getPosY() {
		return y;
	}
	public void setPosY(int posY) {
		this.y = posY;
	}
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	


}

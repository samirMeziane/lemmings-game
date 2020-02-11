package Model;

import javax.swing.ImageIcon;

public class Exit extends Gate{

	public Exit(int x, int y, int largeur, int longeur) {
		super(x, y, largeur, longeur);
		this.url= "images/sortie.png";
		System.out.println(this.getUrl());
	}


	
}

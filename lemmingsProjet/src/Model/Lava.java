package Model;

import javax.swing.ImageIcon;

public class Lava extends Obstacle {

	public Lava(int x, int y,int t ,int l) {
		super(x,y,t,l);
		this.url = "images/lave.png";
		//this.image=new ImageIcon(this.url);
	}
	@Override
	public String typeOf(){
		return "Lave";
	}
}

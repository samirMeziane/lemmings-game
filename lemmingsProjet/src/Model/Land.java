package Model;

import javax.swing.ImageIcon;

public class Land extends Obstacle {

	public Land(int x, int y,int t ,int l) {
		super(x,y,t,l);
		super.url ="images/terre.png";
		//super.image=new ImageIcon(this.url);
		
	}
	@Override
	public String typeOf(){
		return "Terre";
	}
	
}

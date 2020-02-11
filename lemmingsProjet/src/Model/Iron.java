package Model;

import javax.swing.ImageIcon;

public class Iron extends Obstacle {

	public Iron(int x, int y,int t,int l) {
		
		super(x,y,t,l);
		this.url="images/Metal.png";
		//this.image=new ImageIcon(this.url);
	}
	@Override
	public String typeOf(){
		return "Metal";
	}
}

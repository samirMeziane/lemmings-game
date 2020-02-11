package Controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Game;

public class AuditeurGrille implements MouseListener{
	Game jeu;
	public AuditeurGrille(Game jeu) {
		this.jeu = jeu;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		jeu.changeLemmingState(e.getX(),e.getY());
		
		//System.out.println(e.getYOnScreen()+"click");
		
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}



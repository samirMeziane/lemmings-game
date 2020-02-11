package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JRadioButton;

import Model.Game;

public class AuditeurBarreBoutons implements ActionListener{
	Game jeu;
	public AuditeurBarreBoutons(Game jeu) {
		this.jeu = jeu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Change de role selectionne grace aux boutons dans le jeu
	jeu.selectedState(((JRadioButton) e.getSource()).getText());
	//System.out.println(((AbstractButton)e.getSource()).getText());
	}
}


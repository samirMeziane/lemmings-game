package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Controleur.AuditeurBarreBoutons;


public class BarreBoutons extends JPanel{
	
	//C'est la barre a droite de l'ecran qui permet de selectionner l'action de chaque lemming
	private AuditeurBarreBoutons a;
	private List<JRadioButton> boutons;
	private List<JLabel> imgBoutons;
	
	public BarreBoutons(AuditeurBarreBoutons a){
		this.a = a;
		//this.setSize(100,600);
		boutons = new ArrayList<JRadioButton>();
		imgBoutons = new ArrayList<JLabel>();
		//boutons d'action
		boutons.add(new JRadioButton("Marcheur"));
		imgBoutons.add(new JLabel(new ImageIcon("images/walkr.png")));
		boutons.add(new JRadioButton("Grimpeur"));
		imgBoutons.add(new JLabel(new ImageIcon("images/climbr.png")));
		boutons.add(new JRadioButton("Parachutiste"));
		imgBoutons.add(new JLabel(new ImageIcon("images/parar.png")));
		boutons.add(new JRadioButton("Bloqueur"));
		imgBoutons.add(new JLabel(new ImageIcon("images/block.png")));
		boutons.add(new JRadioButton("Bombeur"));
		imgBoutons.add(new JLabel(new ImageIcon("images/bomberr.png")));
		boutons.add(new JRadioButton("Charpentier"));
		imgBoutons.add(new JLabel(new ImageIcon("images/charr.png")));
		boutons.add(new JRadioButton("Creuseur"));
		imgBoutons.add(new JLabel(new ImageIcon("images/miner.png")));
		boutons.add(new JRadioButton("Foreur"));
		imgBoutons.add(new JLabel(new ImageIcon("images/miner.png")));
		
		//ajout du listener pour chaque bouton
		for(JRadioButton b : boutons)
			b.addActionListener(a);

		
		//ajout des bouton dans un group de selection "unique"
		ButtonGroup actions = new ButtonGroup();
		for(JRadioButton b : boutons)
			actions.add(b);
		
		JPanel barre = new JPanel(new GridLayout(0,1));
		for(JRadioButton b : boutons)
			barre.add(b);
		JPanel barre1 = new JPanel(new GridLayout(0,1));
		for(JLabel lb : imgBoutons){
			lb.setBorder(BorderFactory.createEmptyBorder(2, 0, 1, 0));
			barre1.add(lb);
		}
		
		add(barre1, BorderLayout.LINE_START);
		add(barre, BorderLayout.LINE_START);
	}
}

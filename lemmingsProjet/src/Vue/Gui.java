package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import Model.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Controleur.AuditeurBarreBoutons;
import Controleur.AuditeurGrille;

public class Gui implements GameObserver {
	private int x;
	private int y;
	private Game j;
	private AuditeurGrille auditeur;
	private ArrayList<JButton> ListeB = new ArrayList<>();
	private JFrame frame = new JFrame("Lemmings");

	private JComponent component = new JComponent() {

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			for (Obstacle obs : j.getListeO()) {
				if (obs instanceof Trap) {
					g.setColor(Color.red);
					g.fillRect(obs.getPosX(), obs.getPosY(), 20, 20);

				} else {
					ImageIcon image = new ImageIcon(obs.getUrl());

					g.drawImage(image.getImage(), obs.getPosX(), obs.getPosY(), obs.getLargeur(), obs.getLongeur(),
							null);
				}

			}
			for (Lemming lem : j.getListeL()) {

				ImageIcon image = new ImageIcon(lem.getUrl());
				g.drawImage(image.getImage(), lem.getPosX(), lem.getPosY(), lem.getLargeur(), lem.getLongeur(), null);

			}

			Gate[] gate = { j.getFrontDoor(), j.getExitDoor(), j.getPortal() };
			for (int i = 0; i < 3; i++) {
				ImageIcon image = new ImageIcon(gate[i].getUrl());

				g.drawImage(image.getImage(), gate[i].getPosX(), gate[i].getPosY(), gate[i].getLargeur(),
						gate[i].getLongeur(), null);
			}

		}
	};

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Gui(Game j) {
		frame.setSize(j.getWidth(), j.getLength());

		this.j = j;

		BarreBoutons barre = new BarreBoutons(new AuditeurBarreBoutons(j));
		component.setLayout(new BorderLayout());
		component.add(barre, BorderLayout.EAST);

		this.auditeur = new AuditeurGrille(j);
		this.component.addMouseListener(auditeur);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.blue);
		frame.setContentPane(component);
		frame.setVisible(true);

	}

	/**
	 * dessine tout les modèles
	 * 
	 * @param listeL
	 * @param listeO
	 */

	public void notiffy() {
		component.repaint();
	}

	public Game getJ() {
		return j;
	}

	public void setJ(Game j) {
		this.j = j;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JComponent getComponent() {
		return component;
	}

	public void setComponent(JComponent component) {
		this.component = component;
	}

	/*
	 * public void notify(ArrayList<LemmingsEvent> events) {
	 * this.component.repaint();
	 * 
	 * }
	 */

}

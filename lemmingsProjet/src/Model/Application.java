package Model;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controleur.AuditeurBarreBoutons;
import Vue.BarreBoutons;
import Vue.Gui;


public class Application {
	public static void main(String[] args)  {
	Game jeu = new Game(1050,600);
	jeu.chargerNiveau();
	jeu.register(new Gui(jeu));
	System.out.println("hahaha");
	/*jeu.register(new LemmingObserver() {
		
		@Override
		/*public void notify(ArrayList<LemmingsEvent> events) {
			for(LemmingsEvent event:events) {
				System.out.println(event);
			}
			
		}
	});*/

	
	jeu.Run();
	}	
}

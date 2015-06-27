package Controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GestionClavier implements KeyListener
{
	private Jeu j;
		
		/** 
		 * Constructeur de la classe gestion clavier qui prend en paramètre le controleur Jeu.
		 * La classe jeu va nous permettre d'accéder aux différents éléments de nos modèles et de les manipuler.
		**/
		public GestionClavier(Jeu j)
		{
			this.j=j;
		}
		
		/**
		 * La méthode keyPressed permet d'intercepter l'action de l'utilisateuravec son clavier. 
		**/
		public void keyPressed(KeyEvent e)
		{
				/**
				 * Si l'utilisateur appuie sur une des touches (haut, bas, gauche, droite) du clavier,
				 * On active le déplacement correspondant via une variable booléene et on active aussi l'animation qui correspond.
				 * On appelle ensuite la fonction déplacer correpondante au sens de déplacement
				 * Enfin, on remet la variable à false quand il a fini de se déplacer
				**/
				if ( e.getExtendedKeyCode() == 38 ) {
					j.getNiveau().setDeplacerhaut(true);
					j.setDeplacement("h");
					j.getNiveau().deplacer();
					j.getNiveau().setDeplacerhaut(false);
				}
				if ( e.getExtendedKeyCode() == 40 ) {
					j.getNiveau().setDeplacerbas(true);
					j.setDeplacement("b");
					j.getNiveau().deplacer();
					j.getNiveau().setDeplacerbas(false);
				}
				if ( e.getExtendedKeyCode() == 37 ) {
					j.getNiveau().setDeplacergauche(true);
					j.setDeplacement("g");
					j.getNiveau().deplacer();
					j.getNiveau().setDeplacergauche(false);
				}
				if ( e.getExtendedKeyCode() == 39 ) {
					j.getNiveau().setDeplacerdroite(true);
					j.setDeplacement("d");
					j.getNiveau().deplacer();
					j.getNiveau().setDeplacerdroite(false);
				}
		}
		/**
		 * Cette fonction permet de gérer le personnage lorsque l'utilisateur relache une touche du clavier
		 * Ici on indique la variable de déplacement que qui va permettre de gérer l'animation lorque l'utilisateur relâche une touche
		**/
		@Override
		public void keyReleased(KeyEvent e) {
			j.setDeplacement("f");

		}
		
		
		@Override
		public void keyTyped(KeyEvent arg0) {
		}	
				
	
}

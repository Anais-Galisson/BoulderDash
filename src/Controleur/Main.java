package Controleur;

import Modele.Matrice;
import Modele.Niveau;
import Vue.FenetreBoulder;

public class Main
{
	static Matrice m1;
	static Niveau niveau;
	static Jeu j;
	static FenetreBoulder fb;
	
	public static void main(String[] arg)
	{
		m1 = new Matrice(30, 30);
		//On charge notre fichier .txt pour remplir la matrice
		m1.readFile("hello1.txt");
		//On crée un niveau
		niveau = new Niveau(m1);
		//On crée le jeu avec les animations
		j = new Jeu(m1, niveau);
		//On crée l'objet qui permet d'interagir avec les touches du clavier
		GestionClavier g1 = new GestionClavier(j);
		//On crée la fenêtre qui contient les elements
		fb = new FenetreBoulder(j, m1, g1);
		try {
			//On lance notre boucle de jeu
			niveau.boucle();
			//On appelle la méthode finPartie lorsque la boucle est terminée
			fb.finPartie();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		 //FenetreEditeurDeJeu fdj = new FenetreEditeurDeJeu(j, m1);
	}
}

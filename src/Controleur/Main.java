package Controleur;

import Modele.Matrice;
import Vue.FenetreEditeurDeJeu;

public class Main
{
	public static void main(String[] arg)
	{

		Matrice m1 = new Matrice(30, 30);
		//m1.readFile("hello1.txt");
		//m1.creerElementsMatriceDefault();
		Jeu j = new Jeu(m1);
		//GestionClavier g1 = new GestionClavier(j);
		//FenetreBoulder fb = new FenetreBoulder(j, m1, g1);

		FenetreEditeurDeJeu fdj = new FenetreEditeurDeJeu(j, m1);

	}

}

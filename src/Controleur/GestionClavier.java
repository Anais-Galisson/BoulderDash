package Controleur;

import Vue.FenetreBoulder;

public class GestionClavier
{
	static int x = 0;
	static int y = 0;

	public static void Trame()
	{
		while ( true ) {
			try {
				Thread.sleep(60);
			} catch ( InterruptedException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if ( FenetreBoulder.keyListen.down ) {

				FenetreBoulder.matrice.deplacerbas();

			} else if ( FenetreBoulder.keyListen.up ) {

				FenetreBoulder.matrice.deplacerhaut();
			} else if ( FenetreBoulder.keyListen.right ) {

				FenetreBoulder.matrice.deplacerdroite();

			} else if ( FenetreBoulder.keyListen.left ) {

				FenetreBoulder.matrice.deplacergauche();
			}

			FenetreBoulder.PanelJeu.repaint();

		}
	}
}

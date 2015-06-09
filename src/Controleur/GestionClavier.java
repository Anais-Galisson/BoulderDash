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

				FenetreBoulder.matrice.deplacerBas();

			} else if ( FenetreBoulder.keyListen.up ) {

				FenetreBoulder.matrice.deplacerHaut();
			} else if ( FenetreBoulder.keyListen.right ) {

				FenetreBoulder.matrice.deplacerDroite();

			} else if ( FenetreBoulder.keyListen.left ) {

				FenetreBoulder.matrice.deplacerGauche();
			}

			FenetreBoulder.PanelJeu.repaint();

		}
	}
}

package Controleur;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import Vue.FenetreBoulder;

public class GestionClavier
{
	public static void Trame()
	{
		while ( true ) {
			try {
				Thread.sleep(80);
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

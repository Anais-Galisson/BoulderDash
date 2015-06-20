package Controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GestionClavier implements KeyListener
{
	private Jeu j;
		
		public GestionClavier(Jeu j)
		{
			this.j=j;
		}
		public void keyPressed(KeyEvent e)
		{
			
				if ( e.getExtendedKeyCode() == 38 ) {
						j.getMatrice().deplacerhaut();
				}
				if ( e.getExtendedKeyCode() == 40 ) {
					j.getMatrice().deplacerbas();
				}
				if ( e.getExtendedKeyCode() == 37 ) {
					j.getMatrice().deplacergauche();
				}
				if ( e.getExtendedKeyCode() == 39 ) {
					j.getMatrice().deplacerdroite();
				}
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}	
				
	
}

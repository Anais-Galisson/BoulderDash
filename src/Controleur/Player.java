package Controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener
{

	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;

	@Override
	public void keyPressed(KeyEvent e)
	{

		if ( e.getExtendedKeyCode() == 38 ) {
			up = true;
		}
		if ( e.getExtendedKeyCode() == 40 ) {
			down = true;
		}
		if ( e.getExtendedKeyCode() == 37 ) {
			left = true;
		}
		if ( e.getExtendedKeyCode() == 39 ) {
			right = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if ( e.getExtendedKeyCode() == 38 ) {
			up = false;
		}
		if ( e.getExtendedKeyCode() == 40 ) {
			down = false;
		}
		if ( e.getExtendedKeyCode() == 37 ) {
			left = false;
		}
		if ( e.getExtendedKeyCode() == 39 ) {
			right = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub

	}

}

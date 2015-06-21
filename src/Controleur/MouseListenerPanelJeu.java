package Controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Modele.BrickWall;
import Modele.Diamond;
import Modele.Dirt;
import Modele.Matrice;
import Modele.SteelWall;
import Vue.MonPanel;

public class MouseListenerPanelJeu implements MouseListener
{
	private final ActionListenerButton ListenerButton;
	private final MonPanel PanelJeu;
	private final Matrice m1;
	private String selection;
	private boolean nbre_rockford = true;
	private String elementActuel;

	public MouseListenerPanelJeu(ActionListenerButton ListenerButton, MonPanel panelJeu, Matrice m1)
	{
		this.ListenerButton = ListenerButton;
		this.PanelJeu = panelJeu;
		this.m1 = m1;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		int posx = e.getX();
		int posy = e.getY();
		selection = ListenerButton.getEstSelectionné();

		// Verifier qu'il n'y a qu'un boulder sur ma matrice !!!!
		if ( selection == "rockford" && nbre_rockford == true ) {
			m1.placerRockford(posx / 16, posy / 16);
			System.out.println("rocford est remis à FALSE");
			nbre_rockford = false;
		} else if ( selection == "diamond" ) {

			elementActuel = m1.getCase((posx / 16) + 1, (posy / 16) + 1).getType();
			System.out.println(elementActuel);
			m1.placerElementEditeur((posx / 16) + 1, (posy / 16) + 1, new Diamond());

			if ( elementActuel == "rockford" ) {
				System.out.println(nbre_rockford);
				nbre_rockford = true;
				System.out.println("rocford est remis à true");
				System.out.println(nbre_rockford);
			}
		} else if ( selection == "steelwall" ) {
			System.out.println(elementActuel);
			m1.placerElementEditeur((posx / 16) + 1, (posy / 16) + 1, new SteelWall());
			if ( elementActuel == "rockford" ) {
				System.out.println(nbre_rockford);
				nbre_rockford = true;
				System.out.println("rocford est remis à true");
				System.out.println(nbre_rockford);
			}
		} else if ( selection == "brickwall" ) {
			m1.placerElementEditeur((posx / 16) + 1, (posy / 16) + 1, new BrickWall());
			if ( elementActuel == "rockford" ) {
				System.out.println(nbre_rockford);
				nbre_rockford = true;
				System.out.println("rocford est remis à true");
				System.out.println(nbre_rockford);
			}
		} else if ( selection == "dirt" ) {
			m1.placerElementEditeur((posx / 16) + 1, (posy / 16) + 1, new Dirt());
			if ( elementActuel == "rockford" ) {
				System.out.println(nbre_rockford);
				nbre_rockford = true;
				System.out.println("rocford est remis à true");
				System.out.println(nbre_rockford);
			}
		} else if ( selection == "boulder" ) {
			System.out.println("boulderrrrr");
			// Comment placer boulder ?
		}

		PanelJeu.repaint();

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

}

package Controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Modele.Matrice;
import Vue.MonPanel;

public class MouseListenerPanelJeu implements MouseListener
{
	private final ActionListenerPanelInformation ListenerButton;
	private final MonPanel PanelJeu;
	private final Matrice m1;
	private String selection;
	private final boolean nbre_rockford = true;
	private String elementActuel;

	public MouseListenerPanelJeu(ActionListenerPanelInformation ListenerButton, MonPanel panelJeu, Matrice m1)
	{
		this.ListenerButton = ListenerButton;
		this.PanelJeu = panelJeu;
		this.m1 = m1;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		int posx = (e.getX() / 16) + 1;
		int posy = (e.getY() / 16) + 1;
		selection = ListenerButton.getEstSelectionné();

		m1.placerElementByNom(selection, posx, posy);
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

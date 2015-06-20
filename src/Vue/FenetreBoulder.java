package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import Controleur.GestionClavier;
import Controleur.Jeu;
import Modele.Matrice;

public class FenetreBoulder extends JFrame
{
	private final Matrice m1;
	private final Jeu j;
	private final MonPanel PanelJeu;
	private final Panel PanelInformation;
	private final GestionClavier keylisten;

	BufferedImage bf = null;

	public FenetreBoulder(Jeu j, Matrice m1, GestionClavier g1)
	{
		super("Boulder Dash");
		this.j = j;
		this.m1 = m1;
		this.keylisten = g1;
		PanelJeu = new MonPanel(j);
		PanelInformation = new Panel();
		setSize(680, 480);
		//setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//setLocationRelativeTo(null);
		PanelInformation.setBackground(Color.WHITE);
		PanelInformation.setPreferredSize(new Dimension(200, 480));
		PanelJeu.setBackground(Color.blue);
		PanelJeu.setPreferredSize(new Dimension(480, 480));
		this.getContentPane().add(PanelInformation, BorderLayout.EAST);
		this.getContentPane().add(PanelJeu, BorderLayout.WEST);
		this.addKeyListener(g1);
		this.setVisible(true);

	}
}

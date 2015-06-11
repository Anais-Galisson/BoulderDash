package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import Controleur.GestionClavier;
import Controleur.Player;
import Modele.Diamond;
import Modele.Matrice;

public class FenetreBoulder extends JFrame
{
	// Pour l'affichage de la matrice
	public static MonPanel PanelJeu = new MonPanel();
	public static Matrice matrice = new Matrice(30, 30);
	public static Player keyListen = new Player();

	// diamond pour mettre dans matrice
	Diamond diamond = new Diamond();

	private final Panel PanelInformation = new Panel();
	BufferedImage bf = null;


	public FenetreBoulder()
	{
		super("Boulder Dash");
		setSize(690, 480);
		//setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//setLocationRelativeTo(null);
		PanelInformation.setBackground(Color.WHITE);
		PanelInformation.setPreferredSize(new Dimension(200, 500));
		
		//	PanelJeu.setSize(60, 60);
		PanelJeu.setBackground(Color.blue);
		PanelJeu.setPreferredSize(new Dimension(800, 300));
		this.getContentPane().add(PanelInformation, BorderLayout.EAST);
		this.getContentPane().add(PanelJeu, BorderLayout.WEST);
		this.addKeyListener(keyListen);
		this.setVisible(true);
		
		//this.setContentPane(PanelJeu);
		

		//matrice.remplirMatrice();
		//matrice.placer(5, 5, diamond);
		GestionClavier.Trame();

		this.getContentPane().add(PanelJeu);
	}

}

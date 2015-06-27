package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	public JLabel label;


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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		PanelInformation.setBackground(Color.WHITE);
		PanelInformation.setPreferredSize(new Dimension(200, 480));
		PanelJeu.setBackground(Color.blue);
		PanelJeu.setPreferredSize(new Dimension(480, 480));
		this.getContentPane().add(PanelInformation, BorderLayout.EAST);
		this.getContentPane().add(PanelJeu, BorderLayout.WEST);
		this.addKeyListener(g1);
		label = new JLabel("Score: "+ j.getMatrice().getScore());
		System.out.println(j.getMatrice().getScore());
		PanelInformation.add(label);
		this.setVisible(true);
	}
	
	/**
	 * Méthode qui permet de afficher des alertes à l'utilisateur pour prévenir de la fin de la partie
	**/
	public void finPartie()
	{	
			if(j.getNiveau().isGoodEnd()){
			 JOptionPane.showMessageDialog(null, "La partie est terminée, vous avez gagnez !!");
			}
			if(j.getMatrice().isBadEnd()){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			JOptionPane.showMessageDialog(null, "La partie est terminée, vous avez perdu !!");
			}
	}
	
	/**
	 * Getters 
	**/
	public MonPanel getPanelJeu() 
	{
		return PanelJeu;
	}

	public Panel getPanelInformation() 
	{
		return PanelInformation;
	}

}

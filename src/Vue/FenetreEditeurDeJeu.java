package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controleur.ActionListenerPanelInformation;
import Controleur.Jeu;
import Controleur.MouseListenerPanelJeu;
import Modele.Matrice;

public class FenetreEditeurDeJeu extends JFrame
{
	private final Matrice m1;
	private Jeu j;
	private final MonPanel PanelJeu;
	private final Panel PanelInformation;
	private ActionListenerPanelInformation buttonL;
	private MouseListenerPanelJeu paneljeuL;

	//private ButtonListener keyListen;

	//Controleur.mouseListener mouse1 = new Controleur.mouseListener();
	public FenetreEditeurDeJeu(Jeu j, Matrice m1)
	{
		this.m1 = m1;
		PanelJeu = new MonPanel(j);
		PanelInformation = new Panel();
		FenetreEditeurDeJeuInit();

	}

	public void FenetreEditeurDeJeuInit()
	{

		setSize(700, 520);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		PanelInformation.setPreferredSize(new Dimension(220, 480));
		PanelJeu.setBackground(Color.black);
		PanelJeu.setPreferredSize(new Dimension(480, 480));
		this.getContentPane().add(PanelInformation, BorderLayout.EAST);
		this.getContentPane().add(PanelJeu, BorderLayout.WEST);

		JLabel titre = new JLabel("      Editeur de niveau      ");
		JButton enregistrer = new JButton("Enregistrer");
		JButton annuler = new JButton("Annuler");

		JPanel south = new JPanel();
		JPanel center = new JPanel();
		JPanel north = new JPanel();

		PanelInformation.add(south, BorderLayout.SOUTH);
		PanelInformation.add(center, BorderLayout.CENTER);
		PanelInformation.add(north, BorderLayout.NORTH);

		south.add(titre);
		north.add(enregistrer);
		north.add(annuler);

		GridLayout gl = new GridLayout(3, 2);
		center.setLayout(gl);
		gl.setHgap(20);
		gl.setVgap(20);

		ImageIcon rockford = new ImageIcon("./src/Modele/rockford_remplacant.gif");
		JButton button_rockford = new JButton(rockford);
		ImageIcon diamond = new ImageIcon("./src/Modele/diamond_remplacant.gif");
		JButton button_diamond = new JButton(diamond);
		ImageIcon dirt = new ImageIcon("./src/Modele/dirt.gif");
		JButton button_dirt = new JButton(dirt);
		ImageIcon boulder = new ImageIcon("./src/Modele/boulder.gif");
		JButton button_boulder = new JButton(boulder);
		ImageIcon brickwall = new ImageIcon("./src/Modele/brickwall.gif");
		JButton button_brickwall = new JButton(brickwall);
		ImageIcon steelwall = new ImageIcon("./src/Modele/steelwall.gif");
		JButton button_steelwall = new JButton(steelwall);

		// Création des mouseListener sur chacun des boutons 
		Controleur.ActionListenerPanelInformation ctrl = new ActionListenerPanelInformation(button_dirt, button_boulder, button_brickwall, button_steelwall, button_rockford, button_diamond, enregistrer, annuler);

		button_boulder.addActionListener(ctrl);
		button_brickwall.addActionListener(ctrl);
		button_dirt.addActionListener(ctrl);
		button_steelwall.addActionListener(ctrl);
		button_rockford.addActionListener(ctrl);
		button_diamond.addActionListener(ctrl);
		enregistrer.addActionListener(ctrl);
		annuler.addActionListener(ctrl);

		center.add(button_rockford);
		center.add(button_diamond);
		center.add(button_dirt);
		center.add(button_boulder);
		center.add(button_brickwall);
		center.add(button_steelwall);

		// Creation du mouselIStener du Plateau de Jeu
		MouseListenerPanelJeu mlpj = new MouseListenerPanelJeu(ctrl, PanelJeu, m1);
		PanelJeu.addMouseListener(mlpj);
		this.setVisible(true);
	}

	public void popUpEnregistrement()
	{

		JButton button_enregistrer2 = new JButton();
		final JTextArea nom_fichier_sauvegardé = new JTextArea();
		JFrame parent = new JFrame();

		parent.add(button_enregistrer2);
		parent.add(nom_fichier_sauvegardé);
		parent.setLocationRelativeTo(null);
	}
}

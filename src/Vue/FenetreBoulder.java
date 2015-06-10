package Vue;

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
	public static Matrice matrice = new Matrice(20, 20);
	public static Player keyListen = new Player();

	// diamond pour mettre dans matrice
	Diamond diamond = new Diamond();

	private final Panel PanelInformation = new Panel();
	BufferedImage bf = null;
	Animation Rock;
	static VueRockfort vr = new VueRockfort();

	public FenetreBoulder(/* Player player */)
	{

		this.setVisible(true);
		this.setSize(320, 320);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Boulder Dash");
		this.setContentPane(PanelJeu);
		this.addKeyListener(keyListen);

		// Je ne sais pas ou est ce qu'on créera la matrice après ...
		matrice.remplirMatrice();
		matrice.placer(5, 5, diamond);
		GestionClavier.Trame();

		this.getContentPane().add(PanelJeu);
	}

}

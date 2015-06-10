package Vue;

import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

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
	Diamond diamond = new Diamond(true, true, true);

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

	public void init()
	{
		try {
			vr.loadSpriteSheet("rockford.gif");
		}

		catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();

		sprites.add(vr.getSprite(7, 7, 16, 16));

		sprites.add(vr.getSprite(7, 31, 16, 16));
		sprites.add(vr.getSprite(31, 31, 16, 16));
		//sprites.add(vr.getSprite(31, 31, 16, 16));

		Rock = new Animation(sprites);
		Rock.setSpeed(200);
		Rock.start();
	}

	/*
	 * //Graphics dgb; Image db;
	 * 
	 * //@Override
	 * 
	 * @Override public void paint(Graphics g) { paintComponent(getGraphics());
	 * g.drawImage(db, 0, 0, null); repaint(); }
	 * 
	 * public void paintComponent(Graphics g) { if ( Rock != null ) {
	 * Rock.update(System.currentTimeMillis()); g.drawImage(Rock.sprite, 100,
	 * 100, 50, 50, null); } repaint(); }
	 */

}

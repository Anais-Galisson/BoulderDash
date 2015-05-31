package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FenetreBoulder extends JFrame
{

	private final MonPanel PanelJeu = new MonPanel();
	private final MonPanel PanelInformation = new MonPanel();
	BufferedImage bf = null;
	Animation Rock;
	VueRockfort vr = new VueRockfort();

	public FenetreBoulder()
	{
		super("Boulder Dash");
		setSize(800, 500);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);

		PanelInformation.setBackground(Color.WHITE);
		PanelInformation.setPreferredSize(new Dimension(200, 500));

		//	PanelJeu.setSize(60, 60);
		PanelJeu.setBackground(Color.blue);
		PanelJeu.setPreferredSize(new Dimension(600, 500));

		getContentPane().add(PanelInformation, BorderLayout.EAST);
		getContentPane().add(PanelJeu, BorderLayout.WEST);

		setVisible(true);
		init();
		PanelJeu.paint(getGraphics());

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

	//Graphics dgb;
	Image db;

	//@Override
	@Override
	public void paint(Graphics g)
	{
		paintComponent(getGraphics());
		g.drawImage(db, 0, 0, null);
		repaint();
	}

	public void paintComponent(Graphics g)
	{
		if ( Rock != null ) {
			Rock.update(System.currentTimeMillis());
			g.drawImage(Rock.sprite, 100, 100, 50, 50, null);
		}
		repaint();
	}

	public static void main(String[] args)
	{
		FenetreBoulder FB = new FenetreBoulder();
	}
}

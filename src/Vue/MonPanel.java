package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import sun.java2d.pipe.DrawImage;

import Modele.*;

public class MonPanel extends JPanel
{
	public BufferedImage dt;
	public BufferedImage rock;
	public BufferedImage diam;
	public BufferedImage swall;
	public Dirt dirt = new Dirt();
	public RockfordModel rockford = new RockfordModel();
	public Diamond diamond = new Diamond();
	public SteelWall steelwall = new SteelWall();

	public MonPanel()
	{
		super();
		this.setVisible(true);
		dt = dirt.construireEA();
		rock = rockford.construireEA();
		diam = diamond.construireEA();
		swall = steelwall.construireEA();
		
	}

	Image db;

	@Override
	public void paintComponent(Graphics g)
	{

		//Créer un grand rectangle qui fait toute la longueur de la fenetre
		//g.setColor(new Color(255, 255, 255));
		//g.fillRect(0, 0, this.getSize().width, this.getSize().height);

		// Affichage de la matrice
		for ( int x = 0; x < FenetreBoulder.matrice.getSizeX(); x++ ) {
			for ( int y = 0; y < FenetreBoulder.matrice.getSizeX(); y++ ) {
				if ( FenetreBoulder.matrice.getCase(x, y) == Matrice.dirt ) {
					//g.setColor(new Color(0, 0, 0));
					//g.fillRect(y * 16, x * 16, 16, 16); // Ici j'affiche des rectangles, on utilisera les fonctions getImage ensuite !
					g.drawImage(dt, x*16, y*16, 16, 16, null);
				} else if ( FenetreBoulder.matrice.getCase(x, y) == Matrice.rockford ) {
					//g.setColor(new Color(125, 0, 0));
					//g.fillRect(y * 16, x * 16, 16, 16);
					g.drawImage(rock, x*16, y*16, 16, 16, null);	
				}else if ( FenetreBoulder.matrice.getCase(x, y) == Matrice.diamond) {
					g.drawImage(diam, x*16, y*16, 16, 16, null);
					
				}else if ( FenetreBoulder.matrice.getCase(x, y) == Matrice.steelwall) {
					g.drawImage(swall, x*16, y*16, 16, 16, null);
				}
			}

		}
	}

}

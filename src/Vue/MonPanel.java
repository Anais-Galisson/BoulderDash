package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Modele.*;



public class MonPanel extends JPanel implements Observer
{
	public BufferedImage dt;
	public BufferedImage rock;
	public BufferedImage diam;
	public BufferedImage swall;
	public BufferedImage bold;
	public BufferedImage brick;
	

	public MonPanel()
	{
		super();
		this.setVisible(true);
		dt = Matrice.dirt.construireEA();
		rock = Matrice.rockford.construireEA();
		diam = Matrice.diamond.construireEA();
		swall = Matrice.steelwall.construireEA();
		//bold = Matrice.boulder.construireEA();
		
		
		
		brick = Matrice.brickwall.construireEA();
		Matrice.rockford.addObserver(this);
		
		
	}

	Image db;

	@Override
	public void paint/*Component*/(Graphics g)
	{

		//Creer un grand rectangle qui fait toute la longueur de la fenetre
		//g.setColor(new Color(255, 255, 255));
		//g.fillRect(0, 0, this.getSize().width, this.getSize().height);

		//FenetreBoulder.matrice.afficherMatrice();
		// Affichage de la matrice
		for ( int x = 0; x < FenetreBoulder.matrice.getX(); x++ ) {
			for ( int y = 0; y < FenetreBoulder.matrice.getY(); y++ ) {
				if ( FenetreBoulder.matrice.getCase(x, y) == Matrice.dirt ) {
					g.drawImage(dt, x*16, y*16, 16, 16, null);
				} else if ( FenetreBoulder.matrice.getCase(x, y) == Matrice.rockford ) {					
					g.drawImage(rock, x*16, y*16, 16, 16, null);
				}else if ( FenetreBoulder.matrice.getCase(x, y) == Matrice.diamond) {
					g.drawImage(diam, x*16, y*16, 16, 16, null);
				}else if ( FenetreBoulder.matrice.getCase(x, y) == Matrice.steelwall) {
					g.drawImage(swall, x*16, y*16, 16, 16, null);
				}else if (FenetreBoulder.matrice.getCase(x, y) == Matrice.vide){
					g.setColor(new Color(0, 0, 0));
					g.fillRect(x* 16, y*16, 16, 16);
				}/*else if (FenetreBoulder.matrice.getCase(x, y) == Matrice.boulders){
					g.drawImage(bold, x*16, y*16, 16, 16, null);
				}*/else if (FenetreBoulder.matrice.getCase(x,y) == Matrice.brickwall){
					g.drawImage(brick,x* 16, y*16, 16, 16, null);
				}
					
			}

		}
	}
	
	
	@Override
	public void update(Observable o, Object arg) 
	{
		if(o instanceof RockfordModel){
			RockfordModel rfm = (RockfordModel) o;
			FenetreBoulder.matrice.placer(rfm.getx(),rfm.gety(),rfm);
			//System.out.println("x: "+rfm.getx()+" y: "+rfm.gety());
			
			repaint();
		}
	}

}

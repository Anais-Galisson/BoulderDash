package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Controleur.Jeu;
import Modele.*;

public class MonPanel extends JPanel implements Observer
{
	public BufferedImage dt;
	public BufferedImage rock;
	public BufferedImage diam;
	public BufferedImage swall;
	public BufferedImage bold;
	public BufferedImage brick;	
	private Jeu j;
	
	
	public MonPanel(Jeu jeu)
	{
		super();
		this.setVisible(true);
		this.j=jeu;
		j.getMatrice().rockford.addObserver(this);
		
		
	}
	@Override
	public void paint/*Component*/(Graphics g)
	{	
		//System.out.println("coucou");
		System.out.println(j.getMatrice().getSizeX());
		
		for ( int x = 0; x < j.getMatrice().getX(); x++ ) 
		{
			//System.out.println(j.getMatrice().getX());
			
			for ( int y = 0; y < j.getMatrice().getY(); y++ ) 
			{
				if ( j.getMatrice().getCase(x, y).getType() == "dirt" ) {
					dt = j.getMatrice().getCase(x, y).construireEA();
					g.drawImage(dt, x*16, y*16, 16, 16, null);
					j.getMatrice().getCase(x, y).construireEA();
				} else if ( j.getMatrice().getCase(x, y).getType() == "rockford") {
					rock = j.getMatrice().getCase(x, y).construireEA();
					g.drawImage(rock, x*16, y*16, 16, 16, null);
				}else if ( j.getMatrice().getCase(x, y).getType() == "diamond") {
					diam = j.getMatrice().getCase(x, y).construireEA();
					g.drawImage(diam, x*16, y*16, 16, 16, null);
				}else if ( j.getMatrice().getCase(x, y).getType() == "steelwall") {
					swall = j.getMatrice().getCase(x, y).construireEA();
					g.drawImage(swall, x*16, y*16, 16, 16, null);
				}else if (j.getMatrice().getCase(x, y).getType() == "vide"){
					g.setColor(new Color(0, 0, 0));
					g.fillRect(x* 16, y*16, 16, 16);
				}else if (j.getMatrice().getCase(x, y).getType() == "brickwall"){
					brick = j.getMatrice().getCase(x, y).construireEA();
					g.drawImage(brick,x* 16, y*16, 16, 16, null);
				}
				for (int i=0; i< j.getMatrice().boulders.size(); i++)	
				{
					if (j.getMatrice().getCase(x,y) == Matrice.boulders.get(i))
					{
						g.drawImage(j.getMatrice().boulders.get(i).construireEA(),x* 16, y*16, 16, 16, null);
					}
				}
			}
		}
}
	
	@Override
	public void update(Observable o, Object arg) 
	{
		//System.out.println("coucou");
		if(o instanceof RockfordModel)
		{
			RockfordModel rfm = (RockfordModel) o;
			System.out.println("x: "+rfm.getx()+" y: "+rfm.gety());
			//j.getMatrice().placer(rfm.getx(),rfm.gety(),rfm);
			j.getMatrice().placerRockford(rfm.getx(),rfm.gety());
			
			repaint();
		}
	}

}

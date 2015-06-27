package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import Controleur.Jeu;
import Modele.Niveau;

public class MonPanel extends JPanel implements Observer
{
	private BufferedImage dt;
	private BufferedImage rock;
	private BufferedImage diam;
	private BufferedImage swall;
	private BufferedImage bold;
	private BufferedImage brick;
	private final Jeu j;

	
	public MonPanel(Jeu jeu)
	{
		super();
		this.setVisible(true);
		this.j = jeu;
		j.getNiveau().addObserver(this);
		

	}
	/**
	 * Méthode paint qui permet d'afficher tous les éléments construits dans la matrice
	 * On construit les sprites correspondantes et on les dessine
	**/
	@Override
	public void paint/* Component */(Graphics g)
	{
		for ( int x = 0; x < j.getMatrice().getX(); x++ ) 
		{
			for ( int y = 0; y < j.getMatrice().getY(); y++ ) 
			{
				if ( j.getMatrice().getCase(x, y).getType() == "dirt" ) 
				{
					dt = j.getMatrice().getCase(x, y).construireEA();
					g.drawImage(dt, x * 16, y * 16, 16, 16, null);
				} 
				else if ( j.getMatrice().getCase(x, y).getType() == "rockford" ) 
				{
					rock = j.getMatrice().getCase(x, y).construireEA();
					j.updateRockford(System.currentTimeMillis());
					j.construireSpritesRockford();
					g.drawImage(j.getSpriteR(), x * 16, y * 16, 16, 16, null);
				} 
				else if ( j.getMatrice().getCase(x, y).getType() == "diamond" ) 
				{
					diam = j.getMatrice().getCase(x, y).construireEA();
					j.updateDiamonds(System.currentTimeMillis());
					j.construireSpritesDiamond();
					g.drawImage(j.getSpriteD(), x * 16, y * 16, 16, 16, null);
				} 
				else if ( j.getMatrice().getCase(x, y).getType() == "steelwall" ) 
				{
					swall = j.getMatrice().getCase(x, y).construireEA();
					g.drawImage(swall, x * 16, y * 16, 16, 16, null);
				} 
				else if ( j.getMatrice().getCase(x, y).getType() == "vide" ) 
				{
					g.setColor(new Color(0, 0, 0));
					g.fillRect(x * 16, y * 16, 16, 16);
				} 
				else if ( j.getMatrice().getCase(x, y).getType() == "brickwall" ) 
				{
					brick = j.getMatrice().getCase(x, y).construireEA();
					g.drawImage(brick, x * 16, y * 16, 16, 16, null);
				} 
				else if (j.getMatrice().getCase(x, y).getType() == "exit" ) 
				{
				}
				for ( int i = 0; i < j.getMatrice().getBoulders().size(); i++ ) 
				{
					if ( j.getMatrice().getCase(x, y) == j.getMatrice().getBoulders().get(i) ) 
					{
						g.drawImage(j.getMatrice().getBoulders().get(i).construireEA(), x * 16, y * 16, 16, 16, null);
					}
				}
			}
		}
	}

	/**
	 * Méthode qui permet de mettre à jour la vue en fonction des changements réalisés dans l'observable
	 * On notifie la vue des changements effectués pour les positions de Rockford
	**/
	@Override
	public void update(Observable o, Object arg)
	{
		if ( o instanceof Niveau ) 
		{
			Niveau niv = (Niveau) o;
			j.getMatrice().placerRockford(niv.getMatrice().getRockford().getx(), niv.getMatrice().getRockford().gety());
			repaint();
		}
	}

	
}



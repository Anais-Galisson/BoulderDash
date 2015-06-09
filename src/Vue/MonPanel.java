package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class MonPanel extends JPanel
{

	public MonPanel()
	{
		super();
		this.setVisible(true);
	}

	Image db;

	@Override
	public void paintComponent(Graphics g)
	{
		//paintComponent(getGraphics());
		//g.drawImage(db, 0, 0, null);

		//Créer un grand rectangle qui fait toute la longueur de la fenetre
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, this.getSize().width, this.getSize().height);

		// Affichage de la matrice
		for ( int x = 0; x < FenetreBoulder.matrice.getSizeX(); x++ ) {
			for ( int y = 0; y < FenetreBoulder.matrice.getSizeX(); y++ ) {
				if ( FenetreBoulder.matrice.getCase(x, y) == 'x' ) {
					g.setColor(new Color(0, 0, 0));
					g.fillRect(y * 16, x * 16, 16, 16); // Ici j'affiche des rectangles, on utilisera les fonctions getImage ensuite !
				} else if ( FenetreBoulder.matrice.getCase(x, y) == 'J' ) {
					g.setColor(new Color(125, 0, 0));
					g.fillRect(y * 16, x * 16, 16, 16);
				}
			}

		}
	}
	
}

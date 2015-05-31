package Vue;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class MonPanel extends JPanel{

	public MonPanel()
	{
		super();	
	}
	Image db;
	public void paint(Graphics g)
	{
		paintComponent(getGraphics());
		g.drawImage(db, 0, 0, null);
		repaint();
	}
}

package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;

import javax.imageio.ImageIO;

public abstract class ElementsAffichables extends Observable
{

	public BufferedImage spriteSheet;
	protected Boolean animate;
	protected Boolean move;
	protected Boolean explose;



	public ElementsAffichables(Boolean animate, Boolean move, Boolean explose)

	{
		this.animate = animate;
		this.move = move;
		this.explose = explose;
	}


	public void loadSpriteSheet(String path) throws IOException
	{
		URL url = this.getClass().getResource(path);
		spriteSheet = ImageIO.read(url);
	}
	
	public BufferedImage getSprite(int x,int y, int width, int height)
	{
		BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
		return sprite;
	}
	
	public abstract BufferedImage construireEA();
}

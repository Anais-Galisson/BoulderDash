package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Diamond extends ElementsAffichables
{
	public BufferedImage spriteSheet;

	public Diamond(Boolean animate, Boolean move, Boolean explose) 
	{
		super (animate, move, explose);
	}
	
	public void loadSpriteSheetDiamond(String path) throws IOException
	{
		URL url = this.getClass().getResource(path);
		spriteSheet = ImageIO.read(url);
	}
	
	public BufferedImage getImageDiamond(int x,int y, int width, int height)
	{
		BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
		return sprite;
	}

}

package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Boulder extends ElementsAffichables 
{
	
	public BufferedImage spriteSheet;

	public Boulder(Boolean animate, Boolean move, Boolean explose) 
	{
		 super (animate, move, explose);
	}
	
	public void loadSpriteSheetBoulder(String path) throws IOException
	{
		URL url = this.getClass().getResource(path);
		spriteSheet = ImageIO.read(url);
	}
	
	public BufferedImage getImageBoulder(int x,int y, int width, int height)
	{
		BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
		return sprite;
	}


}

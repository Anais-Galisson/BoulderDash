package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class BrickWall extends ElementsAffichables{
	
	public BufferedImage spriteSheet;

	public BrickWall(Boolean animate, Boolean move, Boolean explose) 
	{
		super (animate, move, explose);
	}
	
	public void loadSpriteSheetBrickWall(String path) throws IOException
	{
		URL url = this.getClass().getResource(path);
		spriteSheet = ImageIO.read(url);
	}
	
	public BufferedImage getImageRockford(int x,int y, int width, int height)
	{
		BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
		return sprite;
	}
	
	public void Move()
	{
		move = false;
	}
	public void Animate()
	{
		animate = false;
	}

}

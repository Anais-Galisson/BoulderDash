package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class RockfordModel extends ElementsAffichables
{
	private int x=0, y=0;
	public BufferedImage spriteSheet;
	
	public RockfordModel(Boolean animate, Boolean move, Boolean explose) 
	{
		 super (animate, move, explose);
	}
	
	public void avancerselonx(){
		this.x=x+1;
	}
	
	public void reculerselonx(){
		this.x=x-1;
	}
	
	public void avancerselony(){
		this.y=y+1;
	}
	
	public void reculerselony(){
		this.y=y-1;
	}
	
	public void loadSpriteSheetRockford(String path) throws IOException
	{
		URL url = this.getClass().getResource(path);
		spriteSheet = ImageIO.read(url);
	}
	
	public BufferedImage getImageRockford(int x,int y, int width, int height)
	{
		BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
		return sprite;
	}

}


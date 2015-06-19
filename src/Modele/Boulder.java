package Modele;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Boulder extends ElementsAffichables
{
	int x, y;
	public Boulder(int x, int y)
	{
		super(true, true, true);
		this.x=x;
		this.y=y;
	}

	@Override
	public BufferedImage construireEA() {
			try 
			{
				this.loadSpriteSheet("boulder.gif");
			}
		
			catch ( IOException e ) 
			{
				e.printStackTrace();
			}
			BufferedImage sprite;
		
			sprite = this.getSprite(0, 0, 16, 16);
			
			//sprites.add(vr.getSprite(31, 31, 16, 16));
			return sprite;
	}
	
	public int getx(){
		return x;
	}
	
	public int gety(){
		return y;
	}
}

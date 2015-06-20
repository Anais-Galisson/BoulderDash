package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Dirt extends ElementsAffichables{

	public Dirt()
	{
		super(false, false, true, "dirt");
	}
	public BufferedImage construireEA(){
		try 
		{
			this.loadSpriteSheet("dirt.gif");
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

}

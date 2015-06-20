package Modele;


import java.awt.image.BufferedImage;
import java.io.IOException;


public class BrickWall extends ElementsAffichables{
	

	public BrickWall()

	{
		super(false, false, true, "brickwall");
	}

	@Override
	public BufferedImage construireEA() {
		try 
		{
			this.loadSpriteSheet("brickwall.gif");
		}
	
		catch ( IOException e ) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage sprite;
	
		sprite = this.getSprite(0, 0, 16, 16);
		
		//sprites.add(vr.getSprite(31, 31, 16, 16));
		return sprite;
	}


}

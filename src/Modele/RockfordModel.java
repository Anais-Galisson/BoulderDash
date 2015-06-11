package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class RockfordModel extends ElementsAffichables
{
	private int x=0, y=0;
	
	public RockfordModel() 
	{
		 super (true, true, true);
	}


	public void avancerselonx()
	{
		this.x = x + 1;
	}

	public void reculerselonx()
	{
		this.x = x - 1;
	}


	@Override
	public BufferedImage construireEA() {
		// TODO Auto-generated method stub
		try 
		{
			this.loadSpriteSheet("rockford.gif");
		}
	
		catch ( IOException e ) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage sprite;
	
		sprite = this.getSprite(7, 7, 16, 16);
		
		//sprites.add(vr.getSprite(31, 31, 16, 16));
		return sprite;
	}
	public void avancerselony()
	{
		this.y = y + 1;
	}

	public void reculerselony()
	{
		this.y = y - 1;
	}
}

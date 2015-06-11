package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class BrickWall extends ElementsAffichables{
	
	public BrickWall(Boolean animate, Boolean move, Boolean explose) 
	{
		super (animate, move, explose);
	}
	
	public void Move()
	{
		move = false;
	}
	public void Animate()
	{
		animate = false;
	}

	@Override
	public BufferedImage construireEA() {
		// TODO Auto-generated method stub
		return null;
	}

}

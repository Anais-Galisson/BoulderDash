package Modele;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;

public abstract class ElementsAffichables extends Observable
{

	public static BufferedImage spriteSheet;
	protected Boolean animate;
	protected Boolean move;
	protected Boolean explose;
	protected String type;

	public ElementsAffichables(Boolean animate, Boolean move, Boolean explose, String type)

	{
		this.animate = animate;
		this.move = move;
		this.explose = explose;
		this.type = type;
	}

	public static BufferedImage loadSpriteSheet(String NameSprite)
	{

		System.out.println("@@@ test");
		try {
			System.out.println(NameSprite + ".gif");
			spriteSheet = ImageIO.read(new File("./src/Modele/" + NameSprite + ".gif"));

		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return spriteSheet;

	}

	public BufferedImage getSprite(int x, int y, int width, int height)
	{
		BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
		return sprite;
	}

	public abstract BufferedImage construireEA();

	public Boolean getAnimate()
	{
		return animate;
	}

	public void setAnimate(Boolean animate)
	{
		this.animate = animate;
	}

	public Boolean getMove()
	{
		return move;
	}

	public void setMove(Boolean move)
	{
		this.move = move;
	}

	public Boolean getExplose()
	{
		return explose;
	}

	public void setExplose(Boolean explose)
	{
		this.explose = explose;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}
}

package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;

import javax.imageio.ImageIO;

public abstract class ElementsAffichables extends Observable
{

	public BufferedImage spriteSheet;
	protected Boolean animate;
	protected Boolean move;
	protected Boolean explose;
	protected String type;



	public ElementsAffichables(Boolean animate, Boolean move, Boolean explose, String type)

	{
		this.animate = animate;
		this.move = move;
		this.explose = explose;
		this.type=type;
	}


	public void loadSpriteSheet(String path) throws IOException
	{
		URL url = this.getClass().getResource(path);
		spriteSheet = ImageIO.read(url);
	}
	
	public BufferedImage getSprite(int x,int y, int width, int height)
	{
		BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
		return sprite;
	}
	
	public abstract BufferedImage construireEA();


	public Boolean getAnimate() {
		return animate;
	}


	public void setAnimate(Boolean animate) {
		this.animate = animate;
	}


	public Boolean getMove() {
		return move;
	}


	public void setMove(Boolean move) {
		this.move = move;
	}


	public Boolean getExplose() {
		return explose;
	}


	public void setExplose(Boolean explose) {
		this.explose = explose;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
}

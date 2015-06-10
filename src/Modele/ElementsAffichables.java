package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public abstract class ElementsAffichables
{

	public BufferedImage spriteSheet;

	protected Boolean animate;
	protected Boolean move;
	protected Boolean explose;

	public ElementsAffichables(Boolean animate, Boolean move, Boolean explose)
	{
		this.animate = animate;
		this.move = move;
		this.explose = explose;
	}

	public void loadSpriteSheetBrickWall(String path) throws IOException
	{
		URL url = this.getClass().getResource(path);
		spriteSheet = ImageIO.read(url);
	}

	public BufferedImage getImageRockford(int x, int y, int width, int height)
	{
		BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
		return sprite;
	}

}

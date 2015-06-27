package Modele;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Diamond extends ElementsAffichables
{
	private static final String NameSprite = "diamond";
	private int x, y;
	
	public Diamond(int x, int y)
	{
		super(true, true, true, "diamond");
		this.x=x;
		this.y=y;
		
	}

	@Override
	public BufferedImage construireEA()
	{
		BufferedImage bf = getSpriteSheet().getSubimage(0, 0, 16, 16);
		return bf;

	}
	
	
	public ArrayList<BufferedImage> construireDiamond()
	{
			
			BufferedImage bf = getSpriteSheet();
			
			ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
		
			sprites.add(bf.getSubimage(0, 0, 16, 16));
			sprites.add(bf.getSubimage(24, 0, 16, 16));
			sprites.add(bf.getSubimage(48, 0, 16, 16));
			sprites.add(bf.getSubimage(72, 0, 16, 16));// calcul des positions des sprites diamond à utiliser comme ceci ou en utilisant une boucle
			sprites.add(bf.getSubimage(96, 0, 16, 16));
			sprites.add(bf.getSubimage(120, 0, 16, 16));
			sprites.add(bf.getSubimage(144, 0, 16, 16));
			sprites.add(bf.getSubimage(168, 0, 16, 16));
			
			return sprites;
	
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Retourne le nom du sprite
	 * 
	 * @return
	 */
	public static String getNameSprite()
	{
		return NameSprite;
	}

	private static class InstanceHolder // Cette classe n'est chargé qu'une seule au premier accès de celle-ci
	{
		private static final BufferedImage sprite = loadSpriteSheet(getNameSprite());

		private InstanceHolder()
		{

		}
	}

	static BufferedImage getSpriteSheet()
	{
		return InstanceHolder.sprite;
	}

}

package Modele;

import java.awt.image.BufferedImage;

public class Boulder extends ElementsAffichables
{

	private int x, y;
	private final static String NameSprite = "boulder";

	public Boulder(int x, int y)
	{
		super(true, true, true, "boulder");
		this.x = x;
		this.y = y;
	}

	public int getx()
	{
		return x;
	}

	public int gety()
	{
		return y;
	}

	public void setx(int x)
	{
		this.x = x;
	}

	public void sety(int y)
	{
		this.y = y;
	}

	/**
	 * Return le sprite déjà chargé
	 */
	@Override
	public BufferedImage construireEA()
	{
		return getSpriteSheet();

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

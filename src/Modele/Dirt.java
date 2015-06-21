package Modele;

import java.awt.image.BufferedImage;

public class Dirt extends ElementsAffichables
{

	private final static String NameSprite = "dirt";

	public Dirt()
	{
		super(false, false, true, "dirt");
	}

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

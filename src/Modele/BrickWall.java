package Modele;

import java.awt.image.BufferedImage;

public class BrickWall extends ElementsAffichables
{

	private static final String NameSprite = "brickwall";

	public BrickWall()

	{
		super(false, false, true, "brickwall");
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

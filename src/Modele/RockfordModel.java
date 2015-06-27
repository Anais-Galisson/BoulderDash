package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observer;

public class RockfordModel extends ElementsAffichables
{
	private int x;
	private int y;
	//private final ArrayList<Observer> tabObservateur;
	private static final String NameSprite = "rockford";

	public RockfordModel(int posinitX, int posinitY)
	{
		super(false, false, false, "rockford");
		x = posinitX;
		y = posinitY;
		//tabObservateur = new ArrayList<Observer>();
	}

	
	
	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
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

	@Override
	public BufferedImage construireEA()
	{
		BufferedImage bf = getSpriteSheet().getSubimage(7, 7, 16, 16);
		return bf;

	}
	
	
	public ArrayList<BufferedImage> construireRockfordVueFace(){
		
		BufferedImage bf = getSpriteSheet();
		
		ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
	
		sprites.add(bf.getSubimage(7, 7, 16, 16));
		sprites.add(bf.getSubimage(7, 31, 16, 16));
		sprites.add(bf.getSubimage(31, 31, 16, 16));
		sprites.add(bf.getSubimage(55, 31, 16, 16));
		sprites.add(bf.getSubimage(79, 31, 16, 16));
		sprites.add(bf.getSubimage(103, 31, 16, 16));
		sprites.add(bf.getSubimage(127, 31, 16, 16));
		sprites.add(bf.getSubimage(151, 31, 16, 16));
		sprites.add(bf.getSubimage(175, 31, 16, 16));
		sprites.add(bf.getSubimage(7, 55, 16, 16));
		sprites.add(bf.getSubimage(31, 55, 16, 16));
		sprites.add(bf.getSubimage(55, 55, 16, 16));
		sprites.add(bf.getSubimage(79, 55, 16, 16));
		sprites.add(bf.getSubimage(103, 55, 16, 16));
		sprites.add(bf.getSubimage(127, 55, 16, 16));
		sprites.add(bf.getSubimage(151, 55, 16, 16));
		sprites.add(bf.getSubimage(175, 55, 16, 16));
		sprites.add(bf.getSubimage(7, 79, 16, 16));
		sprites.add(bf.getSubimage(31, 79, 16, 16));
		sprites.add(bf.getSubimage(55, 79, 16, 16));
		sprites.add(bf.getSubimage(79, 79, 16, 16));
		sprites.add(bf.getSubimage(103, 79, 16, 16));
		sprites.add(bf.getSubimage(127, 79, 16, 16));
		sprites.add(bf.getSubimage(151, 79, 16, 16));
		sprites.add(bf.getSubimage(175, 79, 16, 16));
		
		return sprites;

}
	public ArrayList<BufferedImage> construireRockfordGauche(){
			
			BufferedImage bf = getSpriteSheet();
			
			ArrayList<BufferedImage> spritesgauche = new ArrayList<BufferedImage>();
		
			spritesgauche.add(bf.getSubimage(7, 103, 16, 16));
			spritesgauche.add(bf.getSubimage(31, 103, 16, 16));
			spritesgauche.add(bf.getSubimage(55, 103, 16, 16));
			spritesgauche.add(bf.getSubimage(79, 103, 16, 16));
			spritesgauche.add(bf.getSubimage(103, 103, 16, 16));
			spritesgauche.add(bf.getSubimage(127, 103, 16, 16));
			spritesgauche.add(bf.getSubimage(151, 103, 16, 16));
			spritesgauche.add(bf.getSubimage(175, 103, 16, 16));
	
			return spritesgauche;
	
	}
	public ArrayList<BufferedImage> construireRockfordDroite(){
		
		BufferedImage bf = getSpriteSheet();
		
		ArrayList<BufferedImage> spritesdroite = new ArrayList<BufferedImage>();
	
		spritesdroite.add(bf.getSubimage(7, 127, 16, 16));
		spritesdroite.add(bf.getSubimage(31, 127, 16, 16));
		spritesdroite.add(bf.getSubimage(55, 127, 16, 16));
		spritesdroite.add(bf.getSubimage(79, 127, 16, 16));
		spritesdroite.add(bf.getSubimage(103, 127, 16, 16));
		spritesdroite.add(bf.getSubimage(127, 127, 16, 16));
		spritesdroite.add(bf.getSubimage(151, 127, 16, 16));
		spritesdroite.add(bf.getSubimage(175, 127, 16, 16));

		return spritesdroite;
	}
		public ArrayList<BufferedImage> construireRockfordHaut(){
			
			BufferedImage bf = getSpriteSheet();
			
			ArrayList<BufferedImage> spritesHaut = new ArrayList<BufferedImage>();
		
			spritesHaut.add(bf.getSubimage(31, 31, 16, 16));

			return spritesHaut;

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
		private static final BufferedImage sprite = loadSpriteSheet(getNameSprite());//.getSubimage(7, 7, 16, 16);

		private InstanceHolder()
		{
			
		}
		
	}

	static BufferedImage getSpriteSheet()
	{
		return InstanceHolder.sprite;
	}

}

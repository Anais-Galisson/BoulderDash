package Modele;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Observer;

public class RockfordModel extends ElementsAffichables
{
	private int x;
	private int y;
	private final ArrayList<Observer> tabObservateur;
	private static final String NameSprite = "rockford";

	public RockfordModel(int posinitX, int posinitY)
	{
		super(true, true, true, "rockford");
		x = posinitX;
		y = posinitY;
		tabObservateur = new ArrayList<Observer>();
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
	public void addObserver(Observer o)
	{

		tabObservateur.add(o);
	}

	@Override
	public void deleteObserver(Observer o)
	{

		tabObservateur.remove(o);
	}

	@Override
	public void notifyObservers()
	{
		//System.out.println(tabObservateur.size());
		for ( int i = 0; i < tabObservateur.size(); i++ ) {
			//System.out.println("observeur:"+tabObservateur.get(i));
			Observer o = tabObservateur.get(i);
			o.update(this, null);
		}
	}

	public void deplacerDroite()
	{

		if ( x < 29 ) {
			this.x++;
		}
		System.out.println(this.x);
		//setChanged();
		notifyObservers();

	}

	public void deplacerGauche()
	{
		if ( x > 1 ) {
			this.x--;
			//System.out.println(x);
		}
		//setChanged();
		notifyObservers();

	}

	public void deplacerHaut()
	{
		if ( y > 1 ) {
			this.y--;
		}
		//setChanged();
		notifyObservers();

	}

	public void deplacerBas()
	{
		if ( y < 29 ) {
			this.y++;
		}
		setChanged();
		notifyObservers();
	}

	// GESTION AFFICHAGE DES SPRITES
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

	@Override
	public BufferedImage construireEA()
	{
		// TODO Auto-generated method stub
		return null;
	}

}

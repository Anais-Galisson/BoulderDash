package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observer;

public class RockfordModel extends ElementsAffichables
{
	private int x;
	private int y;
	private ArrayList<Observer> tabObservateur;
	
	public RockfordModel(int posinitX, int posinitY) 
	{
		 super (true, true, true);
		 x=posinitX;
		 y=posinitY;
		 tabObservateur=new ArrayList<Observer>();
	}

	@Override
	public BufferedImage construireEA() {
		// TODO Auto-generated method stub
		try 
		{
			this.loadSpriteSheet("rockford.gif");
		}
	
		catch ( IOException e ) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage sprite;
	
		sprite = this.getSprite(7, 7, 16, 16);
		
		//sprites.add(vr.getSprite(31, 31, 16, 16));
		return sprite;
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
	public void addObserver(Observer o) {
		
		tabObservateur.add(o);
	}

	@Override
	public void deleteObserver(Observer o) {
		
		tabObservateur.remove(o);
	}

/*	public void notifyObserveurs() {
		
		for(int i=0;i<tabObservateur.size();i++)
        {
                Observer o = tabObservateur.get(i);
                o.update(this);
        }
		
	}
*/
	@Override
	public void notifyObservers(){
		
		for(int i=0;i<tabObservateur.size();i++)
        {
			//System.out.println("observeur:"+tabObservateur.get(i));
                Observer o = tabObservateur.get(i);
                o.update(this, null);
        }
	}
		
	
	public void deplacerDroite(){
		
		if(x<29){ //TODO replacer 100 par la taille exacte de la fenetre de jeux (le moins 1 c'est pour les murs)
		this.x++;
		}
		setChanged();
		notifyObservers();
		
	}
	
	public void deplacerGauche(){
		if(x>2){
		this.x--;
		}
		setChanged();
		notifyObservers();
		
	}
	
	public void deplacerHaut(){
		if(y>2){
		this.y--;
		}
		setChanged();
		notifyObservers();
		
	}
	
	public void deplacerBas(){
		if(y<29){
		this.y++;
		}
		setChanged();
		notifyObservers();
	}
	

}

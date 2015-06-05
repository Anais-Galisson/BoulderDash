package Modele;

public class RockfordModel extends ElementsAffichables
{
	private int x=0, y=0;
	
	public RockfordModel(Boolean animate, Boolean move, Boolean explose) 
	{
		 super (animate, move, explose);
	}
	

	public void avancerselonx(){
		this.x=x+1;
	}
	
	public void reculerselonx(){
		this.x=x-1;
	}
	
	public void avancerselony(){
		this.y=y+1;
	}
	
	public void reculerselony(){
		this.y=y-1;
	}
	public void getImageRockford()
	{
		
	}

}


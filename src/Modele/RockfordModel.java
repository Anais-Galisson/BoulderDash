package Modele;

public class RockfordModel 
{
	private int x=0, y=0;
	
	public RockfordModel(int x, int y) 
	{
		this.x=x;
		this.y=y;
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

}


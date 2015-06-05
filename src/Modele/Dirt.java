package Modele;

public class Dirt extends ElementsAffichables{

	public Dirt(Boolean animate, Boolean move, Boolean explose) 
	{
		super (animate, move, explose);
	}

	public void getImageDirt()
	{
		
	}

	public void Animate()
	{
		animate = false;
	}
	public void Move()
	{
		move = false;
	}

}

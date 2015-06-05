package Modele;

public class SteelWall extends ElementsAffichables {

	public SteelWall(Boolean animate, Boolean move, Boolean explose) 
	{
		super (animate, move, explose);
	}

	public void getImageSteelWall()
	{
		
	}
	public void explose()
	{
		explose = false;
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

package Modele;

public class BrickWall extends ElementsAffichables{

	public BrickWall(Boolean animate, Boolean move, Boolean explose) 
	{
		super (animate, move, explose);
	}
	
	public void getImageBrickWall()
	{
		
	}
	
	public void Move()
	{
		move = false;
	}
	public void Animate()
	{
		animate = false;
	}

}

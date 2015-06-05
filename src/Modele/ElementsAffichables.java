package Modele;

public  abstract class ElementsAffichables {

	protected Boolean animate;
	protected Boolean move;
	protected Boolean explose;
	
	public ElementsAffichables (Boolean animate, Boolean move, Boolean explose) 
	{
		this.animate = animate;
		this.move = move;
		this.explose = explose;
	}
	
	public void Move()
	{
		move = true;
	}
	public void explose()
	{
		explose = true;
	}
	public void Animate()
	{
		animate = true;
	}

}

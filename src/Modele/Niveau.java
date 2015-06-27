package Modele;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *  Niveau représente un classe observable
 */
public class Niveau extends Observable{

	private final Matrice m;
	private final ArrayList<Observer> tabObservateur;
	private boolean deplacergauche;
	private boolean deplacerdroite;
	private boolean deplacerhaut;
	private boolean deplacerbas;
	private boolean deplacer;
	private boolean goodEnd;

	/**
	 * Constructeur de mon niveau qui prend une matrice en paramètre
	**/
	public Niveau (Matrice m) 
	{
		this.m = m;
		tabObservateur = new ArrayList<Observer>();
	}
	
	/**
	 * Méthode qui permet de récupérer la matrice
	**/
	public Matrice getMatrice()
    {
        return m;
       
    }
	/**
	 * Méthode qui permet d'ajouter un observer 
	**/
	@Override
	public void addObserver(Observer o)
	{
		tabObservateur.add(o);
	}
	/**
	 * Méthode qui permet de supprimer un observer
	**/
	@Override
	public void deleteObserver(Observer o)
	{
		tabObservateur.remove(o);
	}
	
	/**
	 * Méthode qui permet de notifier l'observer des changements effectués dans l'observable
	 **/
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
	
	/**
	 * Quatre méthodes qui permettent de déplacer Rockford vers la droite, gauche, haut et bas,
	 * en incrémentant ou décrémentant les coordonnées définies dans RockfordModel
	**/
	public void deplacerDroite()
	{
			this.getMatrice().getRockford().setX(getMatrice().getRockford().getx()+1);
	}
	
	public void deplacerGauche()
	{
			this.getMatrice().getRockford().setX(getMatrice().getRockford().getx()-1);	
	}
	
	public void deplacerHaut()
	{
			this.getMatrice().getRockford().setY(getMatrice().getRockford().gety()-1);
	}
	
	public void deplacerBas()
	{
			this.getMatrice().getRockford().setY(getMatrice().getRockford().gety()+1);	
	}
	
	/**
	 * Cette méthode permet de déplacer rockford suivant le sens choisi par l'utilisateur
	 * Elle permet aussi de gérer les collisons avec les différents murs ainsi qu'avec les boulders
	 * Cette fonction permet aussi à Rockford de pousser les boulders via la méthode deplacerBoulder
	**/
	public void deplacer()
	{
		
		int posx = getMatrice().getRockford().getx();
		int posy = getMatrice().getRockford().gety();
		if (deplacer){
			
			if (this.deplacerdroite)
			{
				if ( getMatrice().getRockford().getx() < getMatrice().getSizeX() ) {
					if ( getMatrice().getCase(posx + 1, posy).getType() == "brickwall" || getMatrice().getCase(posx+1, posy).getType() == "steelwall")
					{	
					}
					else if (getMatrice().getCase(posx + 1, posy) instanceof Boulder){
						if(m.getCase(posx+2, posy) instanceof Dirt || m.getCase(posx+2, posy) instanceof SteelWall || m.getCase(posx+2, posy) instanceof Boulder || m.getCase(posx+2, posy) instanceof Diamond || m.getCase(posx+2, posy) instanceof BrickWall){
							
						}else{
							deplacerBoulder(posx,posy);
							deplacerDroite();
							getMatrice().placer(posx + 1, posy + 1, new Vide());
						}
						
					}
					else
					{
						
						deplacerDroite();
						getMatrice().placer(posx + 1, posy + 1, new Vide());
					}
				}
			}
		
			else if (deplacergauche)
			{
				if ( getMatrice().getRockford().getx() > 0 ) {
					if ( getMatrice().getCase(posx - 1, posy).getType() == "brickwall" || getMatrice().getCase(posx - 1, posy).getType() == "steelwall" )
					{	
					}
					else if (getMatrice().getCase(posx - 1, posy) instanceof Boulder){
						if(m.getCase(posx-2, posy) instanceof Dirt || m.getCase(posx-2, posy) instanceof SteelWall || m.getCase(posx-2, posy) instanceof Boulder || m.getCase(posx-2, posy) instanceof Diamond || m.getCase(posx-2, posy) instanceof BrickWall){
							
						}else{
							deplacerBoulder(posx,posy);
							deplacerGauche();
							getMatrice().placer(posx + 1, posy + 1, new Vide());
						}
					}
					else
					{
						deplacerGauche();
						getMatrice().placer(posx +1 , posy +1 , new Vide());
					}
				}
			}
		
			else if (deplacerhaut)
			{
				if ( getMatrice().getRockford().gety() > 0 ) {
					if ( getMatrice().getCase(posx, posy-1).getType() == "brickwall" || getMatrice().getCase(posx, posy-1).getType() == "steelwall"|| getMatrice().getCase(posx, posy-1) instanceof Boulder )
					{	
					}
					else
					{
						deplacerHaut();
						getMatrice().placer(posx + 1, posy + 1, new Vide());
						
					}
				}
			}
			else if (deplacerbas)
			{
				if ( getMatrice().getRockford().gety() < getMatrice().getSizeY()-1 ) {
					if ( getMatrice().getCase(posx, posy+1).getType() == "brickwall" || getMatrice().getCase(posx, posy+1).getType() == "steelwall"|| getMatrice().getCase(posx, posy+1) instanceof Boulder )
					{	
					}
					else
					{
						deplacerBas();
						getMatrice().placer(posx + 1, posy + 1, new Vide());
					}
				}
			}
		}else{
			System.out.println("je ne bouge pas");
		}
}
	/**
	 * Cette méthode permet de déplacer les boulders là ou il y a du vide 
	**/
	public void deplacerBoulder(int posx,int posy){
		
		if (this.deplacerdroite)
		{
			for(int i=0;i<m.getsizeboulders();i++){
				if(m.getCase(posx+1, posy) == m.getBoulders().get(i) && m.getCase(posx+2, posy)instanceof Vide){ // pour deplacer un boulder, ça marche mais pas tout à fait
					
						m.placer(posx+3,posy+1,m.getBoulders().get(i));
						m.getBoulders().get(i).setx(posx+3);
						m.getBoulders().get(i).sety(posy+1);
				}
			}
		}
		else if (this.deplacergauche)
		{	
			for(int i=0;i<m.getsizeboulders();i++){
				if(m.getCase(posx-1, posy) == m.getBoulders().get(i) && m.getCase(posx-2, posy)instanceof Vide){ // pour deplacer un boulder, ça marche mais pas tout à fait
					
						m.placer(posx-1,posy+1,m.getBoulders().get(i));
						m.getBoulders().get(i).setx(posx-1);
						m.getBoulders().get(i).sety(posy+1);
				}
			}
		}
		
	}
	
	/**
	 * Cette méthode permet de prévenir de la fin du jeu lorsque Rockford a mangé tous les diamonds
	 * Ansi, on utilise une variable booléene (End)
	s**/
	public void MangeDiamonds()
	{		
		for(int i=0;i<m.getsizeListeDiamond();i++)
		{
			//
			if(m.getRockford().getx() == m.getDiamonds().get(i).getX()-1 && m.getRockford().gety() == m.getDiamonds().get(i).getY()-1)
			{ 
				m.setScore(m.getScore()+1);
				m.getDiamonds().remove(i);
				System.out.println(m.getScore());
			}
		}
			if(m.getScore() == m.getSizeDiamonds() && m.getSizeDiamonds() != 0){ // pour tester (mettre la condition de fin sur rockfort atteint l'exit)
				m.setEnd(true);
				goodEnd=true;
			}	
	}
	
	/**
	 *Boucle de jeu
	 *Le thread permet de ralentir ou d'accélerer le jeu, sans lui tous les elements se déplacent trop rapidement
	 *On appelle la fonction de déplacer à chaque tour de boucle 
	 *On appelle aussi la fonction qui previent de la fin a chaque tour de boucle
	 *On notifie les observers à chaque tour de boucle que les positions ont changé (si ils ont changé)
	 *On fait tomber tous les elements qui tombent que ce soit diamonds ou boulders
	 **/
    public void boucle() throws InterruptedException
    {
        while ( ! getMatrice().isEnd() ) 
        {
        	Thread.sleep(100);
        	deplacer();
            this.MangeDiamonds();
        	setChanged();
        	notifyObservers();
            getMatrice().chute();
            deplacer = true;
       	}
    }
    
    /**
     * Getters et setters 
    **/
	public boolean isDeplacergauche() {
		return deplacergauche;
	}

	public void setDeplacergauche(boolean deplacergauche) {
		this.deplacergauche = deplacergauche;
	}

	public boolean isDeplacerdroite() {
		return deplacerdroite;
	}

	public void setDeplacerdroite(boolean deplacerdroite) {
		this.deplacerdroite = deplacerdroite;
	}

	public boolean isDeplacerhaut() {
		return deplacerhaut;
	}

	public void setDeplacerhaut(boolean deplacerhaut) {
		this.deplacerhaut = deplacerhaut;
	}

	public boolean isDeplacerbas() {
		return deplacerbas;
	}

	public void setDeplacerbas(boolean deplacerbas) {
		this.deplacerbas = deplacerbas;
	}

	public boolean isGoodEnd() {
		return goodEnd;
	}

       
 }
    


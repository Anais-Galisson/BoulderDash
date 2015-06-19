package Modele;

import java.awt.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Vue.FenetreBoulder;


public class Matrice 
{
	private final int taillex, tailley;
	private final ElementsAffichables[][] matrice;
	public static Dirt dirt = new Dirt();
	public static Vide vide = new Vide();
	public static RockfordModel rockford = new RockfordModel(2,2);
	public static Diamond diamond = new Diamond();
	//public static Boulder boulder = new Boulder();
	public static BrickWall brickwall = new BrickWall();
	public static ArrayList<ElementsAffichables> boulders = new ArrayList<ElementsAffichables>();
	public static SteelWall steelwall = new SteelWall();
	public BufferedImage d;


	public Matrice(int taillex, int tailley)
	{
		this.taillex = taillex;
		this.tailley = tailley;
		matrice = new ElementsAffichables[taillex][tailley];
		
		Boulder b1 = new Boulder(4,5);
		Boulder b2 = new Boulder (11,10);
		Boulder b3 = new Boulder (9,12);
		Boulder b4 = new Boulder (21,9);
		Boulder b5 = new Boulder (24,23);
		boulders.add(b1);
		boulders.add(b2);
		boulders.add(b3);
		boulders.add(b4);
		boulders.add(b5);
		//rockford.addObserver(this);
		//d = dirt.construireDirt();
		remplirMatrice();
		placer(b1.getx(),b1.gety(), boulders.get(0));
		placer(b2.getx(),b2.gety(), boulders.get(1));
		placer(b3.getx(),b3.gety(), boulders.get(2));
		placer(b4.getx(),b4.gety(), boulders.get(3));
		placer(b5.getx(),b5.gety(), boulders.get(4));
		placer(5, 5, diamond);
		placer(10,20, diamond);
		placer(20,10, diamond);
		placer(20,20, diamond);
		placer(15,20, diamond);
		placer(20,15, diamond);

		//chute();
	}
	public int getY()
	{
		return tailley;
	}
	public int getX(){
		return taillex;
	}
	public void remplirMatrice()
	{
		for ( int i = 1; i < taillex-1; i++ ) {
			for ( int j = 1; j < tailley-1; j++ ) {
				matrice[i][j] = dirt;
			}
		}
		for (int j = 0; j < tailley; j++ ){
			matrice[0][j] = steelwall;
			matrice[taillex-1][j] = steelwall;
		}
		for (int i = 0; i < taillex; i++ ){
			matrice[i][0] = steelwall;
			matrice[i][tailley-1] = steelwall;
		}
		
		for (int i =1; i<taillex-7; i++){
			matrice[i][10] = brickwall;
		}
		for (int i =7; i<taillex-1; i++){
			matrice[i][20] = brickwall;
		}
		placer(2,2,rockford);
	
	}

	public int getSizeX()
	{
		return matrice.length;
	}

	public int getSizeY()
	{
		return matrice.length;
	}

	public void afficherMatrice()
	{
		System.out.println();
		for ( int i = 0; i < taillex; i++ ) {
			for ( int j = 0; j < tailley; j++ ) {
				System.out.print(" " + matrice[i][j]);
			}
			System.out.println("---------------------------------------------- ");
		}
	}

	public void placer(int x_placement, int y_placement, ElementsAffichables elem)
	{
		x_placement = x_placement - 1;
		y_placement = y_placement - 1;

		if ( x_placement < 0 || y_placement < 0 || y_placement > tailley || x_placement > taillex ) 
		{
			System.out.println("ERREUR");
		} 
		else if ( matrice[x_placement][y_placement] == dirt ) 
		{
			//System.out.println("dirt x_placement: "+x_placement+" y_placement: "+y_placement);
			matrice[x_placement][y_placement] = elem;
			//System.out.println("dirtbis x_placement: "+x_placement+" y_placement: "+y_placement);
		} 
		else if (matrice[x_placement][y_placement] == diamond)
		{
			System.out.println("vous avez mangé le diamond !!");
			//System.out.println("diamond x_placement: "+x_placement+" y_placement: "+y_placement);
			matrice[x_placement][y_placement] = rockford;
			//System.out.println("diamondbis x_placement: "+x_placement+" y_placement: "+y_placement);	
		} 
		else if (matrice[x_placement][y_placement] == rockford){ //contre le dédoublement
			matrice[x_placement][y_placement] = elem;
		}
		else if (matrice[x_placement][y_placement] == vide){ //contre le passage dans le vide
			matrice[x_placement][y_placement] = elem;
		}
		else 
		{
			System.out.println("Bug, pas de dirt, autre objet, impossible de s'y mettre !");
		}
		//ajouter d'autres conditions..
	}

	public ElementsAffichables getCase(int x, int y)
	{
		return matrice[x][y];

	}

	public void deplacerdroite(){
		int posx=rockford.getx();
		int posy=rockford.gety();
		if (matrice[posx][posy-1] == brickwall || matrice[posx][posy-1] == steelwall)
		{
			placer(posx, posy, rockford);
		}
		else
		{
			rockford.deplacerDroite();
			//chute();
			placer(posx, posy, vide);
		}
	}
		
	public void deplacergauche(){
		int posx=rockford.getx();
		int posy=rockford.gety();
		if (matrice[posx-2][posy-1] == brickwall || matrice[posx-2][posy-1] == steelwall)
		{ 
			placer(posx, posy, rockford);
		}
		else
		{
			rockford.deplacerGauche();
			//chute();
			placer(posx, posy, vide);
		}
	}
	public void deplacerhaut(){
		int posx=rockford.getx();
		int posy=rockford.gety();
		if (matrice[posx-1][posy-2] == brickwall || matrice[posx-1][posy-2] == steelwall)
		{
			placer(posx, posy,rockford);
		}
		else
		{
			rockford.deplacerHaut();
			//chute();
			placer(posx, posy, vide);
		}	
	}
	public void deplacerbas(){
		int posx=rockford.getx();
		int posy=rockford.gety();
		if (matrice[posx-1][posy] == brickwall || matrice[posx-1][posy] == steelwall)
		{		
			placer(posx, posy, rockford);
		}
		else
		{
			rockford.deplacerBas();	
			//chute();
			placer(posx, posy, vide);
		}
	}
	/*
	public void chute()
	{
		int posx=rockford.getx();
		int posy=rockford.gety();
		
		//while ()
		
		if ( matrice[posx-1][posy-2] == boulder  )
		{
			while (rockford.getx() == posx-1 && rockford.gety() < posy-2){
			for(int i=posy-1; i<tailley; i++)
			{
				if (matrice[posx-1][i] == vide)
				{
					placer(posx,i+1, boulder);
					placer(posx, i, vide);
				}
				else if (matrice[posx-1][i] == dirt){
					
				}
			}
			}
		}	
	}*/
	

	public ElementsAffichables[][] getMatrice()
	{
		return matrice;
	}


}

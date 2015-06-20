package Modele;

import java.util.ArrayList;

public class Matrice
{
	private final int taillex, tailley;
	private final ElementsAffichables[][] matrice;
	public RockfordModel rockford;
	public static ArrayList<Boulder> boulders = new ArrayList<Boulder>();

	//public BufferedImage d;

	public Matrice(int taillex, int tailley)
	{
		this.taillex = taillex;
		this.tailley = tailley;
		matrice = new ElementsAffichables[taillex][tailley];
		rockford = new RockfordModel(2, 2);
		//creerElementsMatriceDefault();
		//chute();
	}

	public int getsizeboulders()
	{
		return boulders.size();
	}

	public int getY()
	{
		return tailley;
	}

	public int getX()
	{
		return taillex;
	}

	public void remplirMatrice()
	{
		for ( int i = 1; i < taillex - 1; i++ ) {
			for ( int j = 1; j < tailley - 1; j++ ) {
				matrice[i][j] = new Dirt();
			}
		}
		for ( int j = 0; j < tailley; j++ ) {
			matrice[0][j] = new SteelWall();
			matrice[taillex - 1][j] = new SteelWall();
		}
		for ( int i = 0; i < taillex; i++ ) {
			matrice[i][0] = new SteelWall();
			matrice[i][tailley - 1] = new SteelWall();
		}

		for ( int i = 1; i < taillex - 7; i++ ) {
			matrice[i][10] = new BrickWall();
		}
		for ( int i = 7; i < taillex - 1; i++ ) {
			matrice[i][20] = new BrickWall();
		}
		placerRockford(2, 2);

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
				System.out.print(" " + matrice[j][i].getType());
			}
			System.out.println(" ");
		}
	}

	public void placer(int x_placement, int y_placement, ElementsAffichables elem)
	{
		x_placement = x_placement - 1;
		y_placement = y_placement - 1;

		if ( x_placement < 0 || y_placement < 0 || y_placement > tailley || x_placement > taillex ) {
			System.out.println("ERREUR");
		} else if ( matrice[x_placement][y_placement].getType() == "dirt" ) {
			matrice[x_placement][y_placement] = elem;
		} else if ( matrice[x_placement][y_placement].getType() == "diamond" ) {
			System.out.println("vous avez mangé le diamond !!");
			//matrice[x_placement][y_placement] = rockford;
			placerRockford(x_placement, y_placement);
		} else if ( matrice[x_placement][y_placement].getType() == "rockford" ) { //contre le dédoublement
			matrice[x_placement][y_placement] = elem;
		} else if ( matrice[x_placement][y_placement].getType() == "vide" ) { //contre le passage dans le vide
			matrice[x_placement][y_placement] = elem;
		} else {
			System.out.println("Bug, pas de dirt, autre objet, impossible de s'y mettre !");
		}
		//ajouter d'autres conditions..
	}

	public ElementsAffichables getCase(int x, int y)
	{
		return matrice[x][y];

	}

	public void deplacerdroite()
	{
		int posx = rockford.getx();
		int posy = rockford.gety();
		if ( matrice[posx][posy - 1].getType() == "brickwall" || matrice[posx][posy - 1].getType() == "steelwall" || matrice[posx][posy - 1] instanceof Boulder ) {
			//placer(posx, posy, rockford);
			placerRockford(posx - 1, posy - 1);
		} else {
			rockford.deplacerDroite();
			//chute();

		}
	}

	public void deplacergauche()
	{
		int posx = rockford.getx();
		int posy = rockford.gety();
		if ( matrice[posx - 2][posy - 1].getType() == "brickwall" || matrice[posx - 2][posy - 1].getType() == "steelwall" || matrice[posx - 2][posy - 1] instanceof Boulder ) {
			//placer(posx, posy, rockford);
			placerRockford(posx - 1, posy - 1);
		} else {
			rockford.deplacerGauche();
			//chute();

		}
	}

	public void deplacerhaut()
	{
		int posx = rockford.getx();
		int posy = rockford.gety();
		if ( matrice[posx - 1][posy - 2].getType() == "brickwall" || matrice[posx - 1][posy - 2].getType() == "steelwall" || matrice[posx - 1][posy - 2] instanceof Boulder ) {
			//placer(posx, posy,rockford);
			placerRockford(posx - 1, posy - 1);
		} else {
			rockford.deplacerHaut();
			//chute();

		}
	}

	public void deplacerbas()
	{
		int posx = rockford.getx();
		int posy = rockford.gety();
		if ( matrice[posx - 1][posy].getType() == "brickwall" || matrice[posx - 1][posy].getType() == "steelwall" || matrice[posx - 1][posy] instanceof Boulder ) {
			//placer(posx, posy, rockford);
			placerRockford(posx - 1, posy - 1);
		} else {
			rockford.deplacerBas();
			//chute();
			placer(posx + 1, posy, new Vide());
		}
	}

	/*
	 * public void chute() { for (int i=0; i<boulders.size(); i++) { if
	 * (matrice[boulders.get(i).getx()][(boulders.get(i).gety())+1] == vide ) {
	 * placer((boulders.get(i).getx())+1,(boulders.get(i).gety())+2 ,vide);
	 * placer((boulders.get(i).getx()),boulders.get(i).gety()+1,
	 * boulders.get(i)); } }
	 * 
	 * }
	 */

	public ElementsAffichables[][] getMatrice()
	{
		return matrice;
	}

	public void creerElementsMatriceDefault()
	{

		remplirMatrice();
		Boulder b1 = new Boulder(4, 5);
		Boulder b2 = new Boulder(11, 10);
		Boulder b3 = new Boulder(9, 12);
		Boulder b4 = new Boulder(21, 9);
		Boulder b5 = new Boulder(24, 23);
		boulders.add(b1);
		boulders.add(b2);
		boulders.add(b3);
		boulders.add(b4);
		boulders.add(b5);
		//rockford.addObserver(this);
		//d = dirt.construireDirt();
		remplirMatrice();
		placer(b1.getx(), b1.gety(), boulders.get(0));
		placer(b2.getx(), b2.gety(), boulders.get(1));
		placer(b3.getx(), b3.gety(), boulders.get(2));
		placer(b4.getx(), b4.gety(), boulders.get(3));
		placer(b5.getx(), b5.gety(), boulders.get(4));
		placer(5, 5, new Diamond());
		placer(10, 20, new Diamond());
		placer(20, 10, new Diamond());
		placer(20, 20, new Diamond());
		placer(15, 20, new Diamond());
		placer(20, 15, new Diamond());
	}

	public void placerRockford(int x, int y)
	{
		this.matrice[x][y] = this.rockford;
		this.rockford.setX(x);
		this.rockford.setY(y);
	}

}

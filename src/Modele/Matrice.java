package Modele;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
		//creerElementsMatriceDefault();
		rockford = new RockfordModel(-1, -1);
		remplirMatriceEditeur();
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

	/**
	 * Rempli la matrice d'élément dirt et tout autour d'élémenet Steelwall
	 * Cette fonction est notamment utilisé pour l'éditeur de niveau
	 */
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

	}

	public void remplirMatriceEditeur()
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

	}

	/**
	 * Retourne la taille de la matrice sur l'axe x
	 * 
	 * @return
	 */
	public int getSizeX()
	{
		return matrice.length;
	}

	/**
	 * Retourne la taille de la matrice sur l'axe y
	 * 
	 * @return
	 */
	public int getSizeY()
	{
		return matrice.length;
	}

	/**
	 * Permet d'afficher la matrice dans la console (debug)
	 */
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

	/**
	 * Place les éléments dans le plateau de l'éditeur de niveau
	 * 
	 * @param x_placement
	 * @param y_placement
	 * @param elem
	 */
	public void placerElementEditeur(int x_placement, int y_placement, ElementsAffichables elem)
	{
		x_placement = x_placement - 1;
		y_placement = y_placement - 1;

		if ( x_placement < 0 || y_placement < 0 || y_placement > tailley || x_placement > taillex ) {
			System.out.println("ERREUR");
		} else {
			matrice[x_placement][y_placement] = elem;
		}
	}

	/**
	 * Place un élément dans la matrice en connaissant seulement sont nom et son
	 * placement
	 * 
	 * @param nom
	 * @param i
	 * @param j
	 */
	public void placerElementByNom(String nom, int i, int j)
	{

		switch ( nom ) {
			case "rockford" :

				this.placerRockford(i - 1, j - 1);
				break;
			case "diamond" :
				this.placerElementEditeur(i, j, new Diamond());

				break;
			case "steelwall" :
				this.placerElementEditeur(i, j, new SteelWall());

				break;
			case "brickwall" :
				this.placerElementEditeur(i, j, new BrickWall());

				break;
			case "dirt" :
				this.placerElementEditeur(i, j, new Dirt());

				break;
			case "boulder" :
				this.placerBoulder(i, j);
				break;
			default :
				break;
		}
	}

	/**
	 * Récupère l'élément affichable présent à l'emplacement de la matrice voulu
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public ElementsAffichables getCase(int x, int y)
	{
		return matrice[x][y];

	}

	public void deplacerdroite()
	{
		int posx = rockford.getx();
		int posy = rockford.gety();
		//System.out.println(matrice[posx][posy-1].getType());
		//System.out.println(matrice[posx][posy-1].getType());
		if ( matrice[posx + 1][posy].getType() == "brickwall" || matrice[posx + 1][posy].getType() == "steelwall" || matrice[posx + 1][posy] instanceof Boulder )
		//if (matrice[posx][posy-1].getType() == "brickwall" || matrice[posx][posy-1].getType() == "steelwall" || matrice[posx][posy-1] instanceof Boulder )
		{
			//placer(posx, posy, new RockfordModel(posx-1, posy-1));
			//placerRockford(posx-1, posy-1);
		} else {
			rockford.deplacerDroite();
			placer(posx + 1, posy + 1, new Vide());
			//chute();

		}
	}

	public void deplacergauche()
	{
		int posx = rockford.getx();
		int posy = rockford.gety();
		if ( matrice[posx - 1][posy].getType() == "brickwall" || matrice[posx - 1][posy].getType() == "steelwall" || matrice[posx - 1][posy] instanceof Boulder ) {
			//placer(posx, posy, new RockfordModel(posx-1, posy-1));
		} else {
			rockford.deplacerGauche();
			//chute();
			placer(posx + 1, posy + 1, new Vide());
		}
	}

	public void deplacerhaut()
	{
		int posx = rockford.getx();
		int posy = rockford.gety();
		if ( matrice[posx][posy - 1].getType() == "brickwall" || matrice[posx][posy - 1].getType() == "steelwall" || matrice[posx][posy - 1] instanceof Boulder ) {
			//placerRockford(posx-1, posy -1);
		} else {
			rockford.deplacerHaut();
			//chute();
			placer(posx + 1, posy + 1, new Vide());
		}
	}

	public void deplacerbas()
	{
		int posx = rockford.getx();
		int posy = rockford.gety();
		if ( matrice[posx][posy + 1].getType() == "brickwall" || matrice[posx][posy + 1].getType() == "steelwall" || matrice[posx][posy + 1] instanceof Boulder ) {
			//placerRockford(posx-1, posy -1);
		} else {
			rockford.deplacerBas();
			//chute();
			placer(posx + 1, posy + 1, new Vide());
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

	/**
	 * Créer un niveau par défault
	 */
	public void creerElementsMatriceDefault()
	{

		remplirMatrice();
		placerBoulder(4, 5);
		placerBoulder(9, 12);
		placerBoulder(11, 10);
		placerBoulder(21, 9);
		placerBoulder(24, 23);

		placer(5, 5, new Diamond());
		placer(10, 20, new Diamond());
		placer(20, 10, new Diamond());
		placer(20, 20, new Diamond());
		placer(15, 20, new Diamond());
		placer(20, 15, new Diamond());
		placerRockford(2, 2);
	}

	/**
	 * Permet de placer de rockford dans la matrice
	 * 
	 * @param x
	 * @param y
	 */
	public void placerRockford(int x, int y)
	{

		int x_avant = rockford.getx();
		int y_avant = rockford.gety();

		if ( x_avant == -1 && y_avant == -1 ) {
			matrice[x][y] = this.rockford;
			this.rockford.setX(x);
			this.rockford.setY(y);
		} else {
			matrice[x_avant][y_avant] = new Dirt();
			matrice[x][y] = this.rockford;
			this.rockford.setX(x);
			this.rockford.setY(y);
		}

	}

	/**
	 * Place un élément de type Boulder dans la matrice Ajoute la boulder créer
	 * dans la liste "boulders"
	 * 
	 * @param x
	 * @param y
	 */
	public void placerBoulder(int x, int y)
	{
		Boulder boulder = new Boulder(x, y);
		boulders.add(boulder);
		int position = boulders.indexOf(boulder);
		System.out.println(position);
		placer(x, y, boulder);
	}

	/**
	 * Cherche le rockford dans la matrice et return sa position x
	 * 
	 * @return
	 */
	public int trouverRockfordX()
	{
		int tailleX = -3;
		for ( int x = 1; x < taillex - 1; x++ ) {
			for ( int y = 1; y < tailley - 1; y++ ) {
				if ( matrice[x][y].getType() == "rockford" ) {
					tailleX = x;
				}
			}
		}
		System.out.println(tailleX);
		return tailleX;

	}

	/**
	 * Cherche le rockford dans la matrice et return sa position y
	 * 
	 * @return
	 */
	public int trouverRockfordY()
	{
		int tailleY = -3;
		for ( int x = 1; x < taillex - 1; x++ ) {
			for ( int y = 1; y < tailley - 1; y++ ) {
				if ( matrice[x][y].getType() == "rockford" ) {
					tailleY = x;
				}
			}
		}
		System.out.println(tailleY);
		return tailleY;

	}

	/**
	 * Sauvegarde des éléments de la matrice dans un fichier .txt
	 * 
	 * @param nomFichier
	 */
	public void writeFile(String nomFichier)
	{
		try {
			// Créer un objet java.io.FileWriter avec comme argument le mon du fichier dans lequel enregsitrer
			FileWriter fileWriter = new FileWriter("src/Niveaux/" + nomFichier + ".txt");
			// Mettre le flux en tampon (en cache)
			BufferedWriter out = new BufferedWriter(fileWriter);

			for ( int i = 0; i < this.getSizeX(); i++ ) {
				for ( int j = 0; j < this.getSizeY(); j++ ) {
					fileWriter.write("" + this.getCase(i, j).getType() + ";");
				}
				fileWriter.write("\n");
			}
			// Fermer le flux (c'est toujours mieux de le fermer explicitement)
			out.close();

		} catch ( IOException er ) {

		}
	}

	public void readFile(String nomFichier)
	{

		try {
			FileReader fread = new FileReader("src/Niveaux/" + nomFichier);
			BufferedReader bread = new BufferedReader(fread);

			for ( int i = 0; i < this.getSizeX(); i++ ) {
				String[] tabNom = bread.readLine().split(";");
				for ( int j = 0; j < this.getSizeY(); j++ ) {
					String nom = tabNom[j];
					placerElementByNom(nom, i, j);
				}
			}
		} catch ( IOException e ) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}

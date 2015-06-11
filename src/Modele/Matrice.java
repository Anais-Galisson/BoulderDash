package Modele;

import java.awt.image.BufferedImage;

public class Matrice
{
	private final int x, y;
	private final ElementsAffichables[][] matrice;
	public static Dirt dirt = new Dirt();
	public static RockfordModel rockford = new RockfordModel();
	public static Diamond diamond = new Diamond();

	public static SteelWall steelwall = new SteelWall();
	public BufferedImage d;


	public Matrice(int x, int y)
	{
		this.x = x;
		this.y = y;
		matrice = new ElementsAffichables[x][y];
		//d = dirt.construireDirt();

		remplirMatrice();
		placer(5, 5, diamond);
		placer(10,20, diamond);
		placer(20,10, diamond);
		placer(30,20, diamond);
		placer(15,20, diamond);
		placer(20,15, diamond);
	}
	public int getY()
	{
		return y;
	}
	public void remplirMatrice()
	{
		for ( int i = 1; i < x-1; i++ ) {
			for ( int j = 1; j < y-1; j++ ) {
				matrice[i][j] = dirt;
			}
		}
		for (int j = 0; j < y; j++ ){
			matrice[0][j] = steelwall;
		}
		for (int i = 0; i < x; i++ ){
			matrice[i][0] = steelwall;
		}
		/*for (int i = 0; i < x; i++ ){
			
			matrice[i][y] = steelwall;
		}
		for (int j = 0; j < x; j++ ){
			
			matrice[x][j] = steelwall;
		}*/
		

		matrice[1][1] = rockford;
	}

	public int getSizeX()
	{
		return matrice.length;
	}

	public int getSizeY()
	{
		return matrice[0].length;
	}

	public void afficherMatrice()
	{
		System.out.println();
		for ( int i = 0; i < x; i++ ) {
			for ( int j = 0; j < y; j++ ) {
				System.out.print(" " + matrice[i][j]);
			}
			System.out.println(" ");
		}
	}

	public void placer(int x_placement, int y_placement, ElementsAffichables elem)
	{
		x_placement = x_placement - 1;
		y_placement = y_placement - 1;

		if ( x_placement < 0 || y_placement < 0 || y_placement > y || x_placement > x ) {
			System.out.println("ERREUR");
		} else if ( matrice[x_placement][y_placement] == dirt ) {
			matrice[x_placement][y_placement] = elem;
		} else {
			System.out.println("Bug, pas de dirt, autre objet, impossible de s'y mettre !");
		}

		//ajouter d'autre conditions..

	}

	public ElementsAffichables getCase(int x, int y)
	{
		return matrice[x][y];

	}

	public void deplacerdroite()
	{
		ElementsAffichables tmp;
		for ( int i = 0; i < x; i++ ) {
			for ( int j = 0; j < y; j++ ) {

				if ( matrice[i][j] == rockford ) { // Egale au type joueur, a changer /!\
					if ( i + 1 < x && matrice[i + 1][j] == dirt ) { // Si c'est du vide ..
						tmp = matrice[i][j];
						matrice[i][j] = dirt;
						i = i + 1;
						matrice[i][j] = tmp;
					} else if ( i + 1 < x && matrice[i + 1][j] == diamond ) { // Si c'est un diamant...
						System.out.println("tesst");
						tmp = matrice[i][j];
						matrice[i][j] = dirt;
						i = i + 1;
						matrice[i][j] = rockford;
						System.out.println("Vous avez trouvé le diamant pas la droite");
					}
				}
			}
		}
	}

	public void deplacergauche()
	{
		ElementsAffichables tmp;
		for ( int i = 0; i < x; i++ ) {
			for ( int j = 0; j < y; j++ ) {

				if ( matrice[i][j] == rockford ) { // Egale au type joueur, a changer /!\
					if ( i > 0 && matrice[i - 1][j] == dirt ) { //vérifier que l'espace est vide
						tmp = matrice[i][j];
						matrice[i][j] = dirt;
						i = i - 1;
						matrice[i][j] = tmp;
					} else if ( i > 0 && matrice[i - 1][j] == diamond ) {
						tmp = matrice[i][j];
						matrice[i][j] = dirt;
						i = i - 1;
						matrice[i][j] = rockford;
						System.out.println("Vous avez trouvé le diamant par la gauche!");
					}
				}
			}
		}
	}

	public void deplacerhaut()
	{
		ElementsAffichables tmp;
		for ( int i = 0; i < x; i++ ) {
			for ( int j = 0; j < y; j++ ) {

				if ( matrice[i][j] == rockford ) { // Egale au type joueur, a changer /!\
					if ( j > 0 && matrice[i][j - 1] == dirt ) { // Vérifier que l'espace est dirt
						tmp = matrice[i][j];
						matrice[i][j] = dirt;
						j = j - 1;
						matrice[i][j] = tmp;
					} else if ( j > 0 && matrice[i][j - 1] == diamond ) {
						tmp = matrice[i][j];
						matrice[i][j] = dirt;
						System.out.println("hello");
						j = j - 1;
						matrice[i][j] = rockford;
						System.out.println("Vous avez trouvé le diamant par le haut!");
					}
				}
			}
		}
	}

	public void deplacerbas()
	{
		ElementsAffichables tmp;
		for ( int i = 0; i < x; i++ ) {
			for ( int j = 0; j < y; j++ ) {

				if ( matrice[i][j] == rockford ) { // Egale au type joueur, a changer /!\
					if ( j + 1 < y && matrice[i][j + 1] == dirt ) { // vérifier que l'espace est vide
						tmp = matrice[i][j];
						matrice[i][j] = dirt;
						j = j + 1;
						matrice[i][j] = tmp;
					} else if ( j + 1 < y && matrice[i][j + 1] == diamond ) {
						tmp = matrice[i][j];
						matrice[i][j] = dirt;
						j = j + 1;
						matrice[i][j] = rockford;
						System.out.println("Vous avez gagné le diamant par le bas");
					}
				}
			}
		}
	}

	public int getX()
	{
		return x;
	}

	

	public ElementsAffichables[][] getMatrice()
	{
		return matrice;
	}

}

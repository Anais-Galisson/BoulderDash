package Modele;

public class Matrice
{
	private final int x, y;
	private final ElementsAffichables[][] matrice;
	public static Dirt dirt = new Dirt(false, false, true);
	public static RockfordModel rockford = new RockfordModel(true, true, true);
	public static Diamond diamond = new Diamond(true, true, true);

	public Matrice(int x, int y)
	{
		this.x = x;
		this.y = y;
		matrice = new ElementsAffichables[x][y];

		remplirMatrice();
	}

	public void remplirMatrice()
	{
		for ( int i = 0; i < x; i++ ) {
			for ( int j = 0; j < y; j++ ) {
				matrice[i][j] = dirt;
			}
		}

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

	public void deplacerBas()
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
						tmp = matrice[i][j];
						matrice[i][j] = dirt;
						i = i + 1;
						matrice[i][j] = rockford;
						System.out.println("Vous avez trouvé le diamant pas le bas");
					}
				}
			}
		}
	}

	public void deplacerHaut()
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
						System.out.println("Vous avez trouvé le diamant par le haut!");
					}
				}
			}
		}
	}

	public void deplacerGauche()
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
						System.out.println("Vous avez trouvé le diamant par la gauche!");
					}
				}
			}
		}
	}

	public void deplacerDroite()
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
						System.out.println("Vous avez gagné le diamant par la droite");
					}
				}
			}
		}
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public ElementsAffichables[][] getMatrice()
	{
		return matrice;
	}

}

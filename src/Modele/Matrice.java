package Modele;

public class Matrice
{
	private final int x, y;
	private final char[][] matrice;

	public Matrice(int x, int y)
	{
		this.x = x;
		this.y = y;
		matrice = new char[x][y];

		remplirMatrice();
	}

	public void remplirMatrice()
	{
		for ( int i = 0; i < x; i++ ) {
			for ( int j = 0; j < y; j++ ) {
				matrice[i][j] = 'x';
			}
		}

		matrice[1][1] = 'J';
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

	public void placer(int x_placement, int y_placement, char P)
	{
		x_placement = x_placement - 1;
		y_placement = y_placement - 1;

		if ( x_placement < 0 || y_placement < 0 || y_placement > y || x_placement > x ) {
			System.out.println("ERREUR");
		} else if ( matrice[x_placement][y_placement] == 'x' ) {
			matrice[x_placement][y_placement] = P;
		} else {
			System.out.println("Bug, pas de 'x' !");
		}

		//ajouter d'autre conditions..

	}

	public char getCase(int x, int y)
	{
		return matrice[x][y];

	}

	public void deplacerBas()
	{
		char tmp;
		for ( int i = 0; i < x; i++ ) {
			for ( int j = 0; j < y; j++ ) {

				if ( matrice[i][j] == 'J' ) { // Egale au type joueur, a changer /!\
					if ( i + 1 < x && matrice[i + 1][j] == 'x' ) { // Si c'est du vide ..
						tmp = matrice[i][j];
						matrice[i][j] = 'x';
						i = i + 1;
						matrice[i][j] = tmp;
					} else if ( i + 1 < x && matrice[i + 1][j] == 'D' ) { // Si c'est un diamant...
						tmp = matrice[i][j];
						matrice[i][j] = 'x';
						i = i + 1;
						matrice[i][j] = 'J';
						System.out.println("Vous avez trouvé le diamant pas le bas");
					}
				}
			}
		}
	}

	public void deplacerHaut()
	{
		char tmp;
		for ( int i = 0; i < x; i++ ) {
			for ( int j = 0; j < y; j++ ) {

				if ( matrice[i][j] == 'J' ) { // Egale au type joueur, a changer /!\
					if ( i > 0 && matrice[i - 1][j] == 'x' ) { //vérifier que l'espace est vide
						tmp = matrice[i][j];
						matrice[i][j] = 'x';
						i = i - 1;
						matrice[i][j] = tmp;
					} else if ( i > 0 && matrice[i - 1][j] == 'D' ) {
						tmp = matrice[i][j];
						matrice[i][j] = 'x';
						i = i - 1;
						matrice[i][j] = 'J';
						System.out.println("Vous avez trouvé le diamant par le haut!");
					}
				}
			}
		}
	}

	public void deplacerGauche()
	{
		char tmp;
		for ( int i = 0; i < x; i++ ) {
			for ( int j = 0; j < y; j++ ) {

				if ( matrice[i][j] == 'J' ) { // Egale au type joueur, a changer /!\
					if ( j > 0 && matrice[i][j - 1] == 'x' ) { // Vérifier que l'espace est vide
						tmp = matrice[i][j];
						matrice[i][j] = 'x';
						j = j - 1;
						matrice[i][j] = tmp;
					} else if ( j > 0 && matrice[i][j - 1] == 'D' ) {
						tmp = matrice[i][j];
						matrice[i][j] = 'x';
						j = j - 1;
						matrice[i][j] = 'J';
						System.out.println("Vous avez trouvé le diamant par la gauche!");
					}
				}
			}
		}
	}

	public void deplacerDroite()
	{
		char tmp;
		for ( int i = 0; i < x; i++ ) {
			for ( int j = 0; j < y; j++ ) {

				if ( matrice[i][j] == 'J' ) { // Egale au type joueur, a changer /!\
					if ( j + 1 < y && matrice[i][j + 1] == 'x' ) { // vérifier que l'espace est vide
						tmp = matrice[i][j];
						matrice[i][j] = 'x';
						j = j + 1;
						matrice[i][j] = tmp;
					} else if ( j + 1 < y && matrice[i][j + 1] == 'D' ) {
						tmp = matrice[i][j];
						matrice[i][j] = 'x';
						j = j + 1;
						matrice[i][j] = 'J';
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

	public char[][] getMatrice()
	{
		return matrice;
	}

}

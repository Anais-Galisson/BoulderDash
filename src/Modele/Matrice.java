package Modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Matrice
{
	private final int taillex, tailley;
	private final ElementsAffichables[][] matrice;
	private RockfordModel rockford;
	private ArrayList<Boulder> boulders;
	private ArrayList<Diamond> diamonds;
	private int score = 0;
	private boolean end;
    private final int sizeDiamonds;
	private boolean badEnd;
	private int indiceD=0;
	private int indiceB=0;

	/**
	 * Constructeur de la matrice qui prend en paramètre les tailles (x,y)
	 * On créée les elements dont on aura besoin et si besoin avec des listes comme pour les boulders et les diamonds
	**/
	public Matrice(int taillex, int tailley)
	{
		boulders = new ArrayList<Boulder>();
		diamonds = new ArrayList<Diamond>();
		this.taillex = taillex;
		this.tailley = tailley;
		matrice = new ElementsAffichables[taillex][tailley];
		rockford = new RockfordModel(2, 2);
		//remplirMatriceEditeur();
		sizeDiamonds = diamonds.size();
	}

	/**
	 * Cette fonction n'est utile que pour le debug (pour afficher la matrice d'objets dans la console
	**/
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

	/**
	 * Fonction qui permet de placer les differents objets qui héritent de la classe ElementsAffichable (dirt, boulders...)
	**/
	public void placer(int x_placement, int y_placement, ElementsAffichables elem)
	{
		x_placement = x_placement - 1;
		y_placement = y_placement - 1;

		if ( x_placement < 0 || y_placement < 0 || y_placement > tailley || x_placement > taillex ) 
		{
			System.out.println("ERREUR");
		}
		else if ( matrice[x_placement][y_placement].getType() == "dirt" )
		{
			matrice[x_placement][y_placement] = elem;
		}
		//Pour ne pas avoir de dédoublement
		else if ( matrice[x_placement][y_placement].getType() == "rockford" ) 
		{
			matrice[x_placement][y_placement] = elem;
		//Pour ne pas avoir de passage dans le vide 
		} 
		else if ( matrice[x_placement][y_placement].getType() == "vide" ) 
		{
			matrice[x_placement][y_placement] = elem;
		}
		else
		{
			System.out.println("debug");
		}
	}

	/**
	 * Place les éléments dans le plateau de l'éditeur de niveau
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
	 * Méthode qui permet la chute des boulders ou des diamonds dès qu'il y a du vide en dessous
	**/
	public void chute()
	{
		for (int i=0; i<boulders.size(); i++)	
		{
			if (matrice[boulders.get(i).getx()-1][boulders.get(i).gety()].getType() == "vide" )
			{
				matrice[boulders.get(i).getx()-1][boulders.get(i).gety()]=boulders.get(i);
				matrice[boulders.get(i).getx()-1][boulders.get(i).gety()-1] = new Vide(); 
				boulders.get(i).sety(boulders.get(i).gety()+1);
				if(matrice[boulders.get(i).getx()-1][boulders.get(i).gety()].getType() == "rockford")
				{
					GameOver(boulders.get(i).getx()-1, boulders.get(i).gety());
				}
			}
		}
		for (int i=0; i<diamonds.size(); i++)	
		{
			if (matrice[diamonds.get(i).getX()-1][diamonds.get(i).getY()].getType() == "vide" )
			{
				placer((diamonds.get(i).getX()),diamonds.get(i).getY()+1, diamonds.get(i));
				matrice[diamonds.get(i).getX()-1][diamonds.get(i).getY()-1] = new Vide(); 
				diamonds.get(i).setY(diamonds.get(i).getY()+1);
				if(matrice[diamonds.get(i).getX()-1][diamonds.get(i).getY()].getType() == "rockford")
				{
					GameOver(diamonds.get(i).getX()-1, diamonds.get(i).getY());
				}
			}
		}
	}
	/**
	 * Cette méthode permet de placer du vide à la place des elements qui se sont explosés
	**/
	public void GameOver(int x, int y)
	{
		matrice[x][y]= new Vide();
		matrice[x-1][y-1]=new Vide();
		matrice[x][y-1]= new Vide();
		matrice[x-1][y]=new Vide();
		matrice[x+1][y+1]=new Vide();
		matrice[x+1][y]=new Vide();
		matrice[x][y+1]=new Vide();
		matrice[x+1][y-1]=new Vide();
		matrice[x-1][y+1]=new Vide();
		end=true;
		badEnd=true;
	}
	
	/**
	 * Cette méthode permet de forcer Rockford à se placer dans une position (x,y)
	**/
	public void placerRockford(int x, int y)
	{
		rockford.setX(x);
		rockford.setY(y);
		matrice[x][y] = rockford;
	}
	
	/**
	 * Cette méthode permet de placer les éléments qui existent dans le fichier.txt dans la matrice
	 * Elle permet de creer des objets d'elements affichables dans les endroites renseignés par un type
	 **/
	public void placerElementByNom(String nom, int i, int j)
	{

		switch ( nom ) {
			case "rockford" :
				this.placerRockford(i, j);
				break;
			case "diamond" :
				diamonds.add(new Diamond(i+1, j+1));
				matrice[diamonds.get(indiceD).getX()-1][diamonds.get(indiceD).getY()-1]=diamonds.get(indiceD);
				indiceD++;
				break;
			case "steelwall" :
				matrice[i][j] = new SteelWall();
				break;
			case "brickwall" :
				matrice[i][j] = new BrickWall();
				break;
			case "dirt" :
				matrice[i][j] = new Dirt();
				break;
			case "boulder" :
				boulders.add(new Boulder(i+1, j+1));
				matrice[boulders.get(indiceB).getx()-1][boulders.get(indiceB).gety()-1]=boulders.get(indiceB);
				indiceB++;
				break;
			default :
				break;
		}
	}
	/**
	 * Cette méthode permet le chargement d'un fichier .txt qui contient les elements séparés par des ";"
	**/
	public void readFile(String nomFichier)
	{
		try 
		{
			FileReader fread = new FileReader("src/Niveaux/" + nomFichier);
			@SuppressWarnings("resource")
			BufferedReader bread = new BufferedReader(fread);
			for ( int i = 0; i < this.getSizeX(); i++ ) 
			{
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
	
	/**
	 * Getters et Setters
	**/
	
	public RockfordModel getRockford()
	    {
	        return this.rockford;
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
		public int getSizeX()
		{
			return matrice.length;
		}

		public int getSizeY()
		{
			return matrice.length;
		}
		public ElementsAffichables getCase(int x, int y)
		{
			return matrice[x][y];

		}
		public ElementsAffichables[][] getMatrice()
		{
			return matrice;
		}
		
		public int getsizeListeBoulder()
		{
			return boulders.size();
		}
		public int getsizeListeDiamond()
		{
			return diamonds.size();
		}
		public boolean isEnd() {
			return end;
		}

		public void setEnd(boolean end) {
			this.end = end;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public ArrayList<Boulder> getBoulders() {
			return boulders;
		}

		public int getSizeDiamonds() {
			return sizeDiamonds;
		}

		public ArrayList<Diamond> getDiamonds() {
			return diamonds;
		}

		public void setDiamonds(ArrayList<Diamond> diamonds) {
			this.diamonds = diamonds;
		}

		public void setBoulders(ArrayList<Boulder> boulders) {
			this.boulders = boulders;
		}
		
		public void setCase(int x,int y, ElementsAffichables elem){
			matrice[x][y]=elem;
		}

		public boolean isBadEnd() {
			return badEnd;
		}
}



package Controleur;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Modele.Matrice;
import Modele.Niveau;

public class Jeu
{

	private final Matrice m;
	private ArrayList<BufferedImage> framesRockford, framesDiamonds;
	private volatile boolean running = false;
	private long  previousTimeD, previousTimeR, speed;
	private Niveau niveau;
	private int currentFrameD, currentFrameR;
	private BufferedImage spriteR, spriteD;
	private String deplacement;
	
	/**
	 * Constructeur du controleur du Jeu  qui prend en paramètre un niveau et une matrice
	**/
	public Jeu(Matrice m , Niveau niveau)
	{
		/** 
		 * On contruit les sprites des éléments affichés et on lance l'animation. 
		 * On fixe la variable d'animation (déplacement) de telle sorte que lorque le personne ne bouge pas, 
		 * on affiche l'animation qui correspond
		**/
		this.m = m;
		this.niveau = niveau;
		this.deplacement="f";
		construireSpritesRockford();
		construireSpritesDiamond();
		this.setSpeed(30);
		this.start();
	}
	
	/**
	 * Un setter qui permet de changer les sprites de Rockford si besoin
	**/
	public void setFramesRockford(ArrayList<BufferedImage> framesRockford) {
		this.framesRockford = framesRockford;
	}
	
	/**
	 * Un setter qui permet de changer les sprites de Diamond si besoin
	**/
	public void setFramesDiamonds(ArrayList<BufferedImage> framesDiamonds) {
		this.framesDiamonds = framesDiamonds;
	}

	/**
	 * Un getter de notre modèle de matrice qui est passé en paramètre dans la classe
	**/
	public Matrice getMatrice()
	{
		return this.m;
	}

	/**
	 * Cette méthode permet de récupérer les sprites de Rockford (getter)
	**/
	public BufferedImage getSpriteR() {
		return spriteR;
	}
	
	/**
	 * Cette méthode permet de récupérer les sprites du Diamond (getter)
	**/
	public BufferedImage getSpriteD() {
		return spriteD;
	}
	
	/**
	 * Un setter de la variable speed qui reprèsente l'interval de l'animation
	**/
	public void setSpeed(long speed){
		this.speed = speed;
	}
	
	/**
	 * Cette fonction permet de recuperer les frames de l'animation **/
	public void updateRockford(long time)
	{
		if(running)
		{
			//On verifie si l'interval entre le temps actuel et précédent n'est pas supérieure à l'interval que l'on veut
			if(time - previousTimeR >= speed){
				//On incrémente les frames
				currentFrameR++;
				try{
					// On récupére la frame à chaque fois pour la stocker donc spriteR et ensuite l'afficher dans la vue
					spriteR = framesRockford.get(currentFrameR);
				//Exception en cas d'echec
				}catch(IndexOutOfBoundsException e){
					currentFrameR = 0;
					spriteR = framesRockford.get(currentFrameR);
					
				}
				//On remet previousTimeR au moment actuel pour pouvoir réafficher une seconde frame
				previousTimeR = time;
			}
		}
	}
	
	/**
	 * La même fonction que pour les diamonds
	**/
	public void updateDiamonds(long time)
	{
		if(running)
		{
		
			if(time - previousTimeD >= speed){
				currentFrameD++;
				try{
					spriteD = framesDiamonds.get(currentFrameD);
				}catch(IndexOutOfBoundsException e){
					currentFrameD = 0;
					spriteD = framesDiamonds.get(currentFrameD);
					
				}
				previousTimeD = time;
				//rfm.avancerselony();
			}
		}
	}
	/**
	 * La méthode qui permet de lancer l'animation en mettant la variable booléene à true
	**/
	public void start ()
	{
		running = true;
		previousTimeD = 0;
		previousTimeR = 0;
		currentFrameD = 0;
		currentFrameR = 0;
	
		
	}
	/**
	 * Cette méthode permet de construire les sprites de Rockford en fonction de son deplacement
	**/
	public void construireSpritesRockford()
	{	
		switch (deplacement)
		{
		  case "h":
		    setFramesRockford(m.getRockford().construireRockfordHaut());
		    break;
		  case "g":
			  setFramesRockford(m.getRockford().construireRockfordGauche());
		    break;
		  case "d":
			    setFramesRockford(m.getRockford().construireRockfordDroite());
			    break;
		  default:
			  	setFramesRockford(m.getRockford().construireRockfordVueFace());
		}
		
	}

	/**
	 * Cette fonction permet de construire les sprites des diamond
	 **/
	public void construireSpritesDiamond()
	{
		setFramesDiamonds(m.getDiamonds().get(0).construireDiamond());
	}
	
	/**
	 * Cette méthode permet de récupérer notre modèle de niveau
	**/
	public Niveau getNiveau() {
		return niveau;
	}

	/**
	 * Getter de la variable de l'animation (deplacement) 
	**/
	public String getDeplacement() {
		return deplacement;
	}

	/**
	 * Setter de la variable de l'animation 
	**/
	public void setDeplacement(String deplacement) {
		this.deplacement = deplacement;
	}
}

package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;

import sun.java2d.loops.DrawRect;

public class Vide extends ElementsAffichables{

	public Vide() 
	{
		super (false, false, false, "vide");
	}

	@Override
	public BufferedImage construireEA() {

		return null;
	}
}

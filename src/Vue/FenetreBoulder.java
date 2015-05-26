package Vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

// ça fonctionne !

public class FenetreBoulder extends JFrame
{

	private final JPanel PanelJeu = new JPanel();
	private final JPanel PanelInformation = new JPanel();

	public FenetreBoulder()
	{
		super("Boulder Dash");
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().add(PanelJeu, BorderLayout.CENTER);
		PanelJeu.setBackground(Color.WHITE);
		getContentPane().add(PanelInformation, BorderLayout.EAST);

		setVisible(true);
	}

	public static void main(String[] args)
	{
		FenetreBoulder FB = new FenetreBoulder();
	}
}

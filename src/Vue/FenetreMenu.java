package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreMenu extends JFrame
{

	private JPanel panelMenu;
	private JPanel panelImage;
	private JPanel panelButton;
	private JPanel panelBas;
	private final ImageIcon logo = new ImageIcon("./src/Modele/BoulderLogo.png");
	private JButton jouer;
	private JButton editer;

	public FenetreMenu()
	{
		MenuInit();
	}

	public void MenuInit()
	{

		panelMenu = new JPanel();
		panelButton = new JPanel();
		panelBas = new JPanel();
		panelImage = new JPanel();
		jouer = new JButton("Jouer");
		editer = new JButton("Editer");

		JLabel titre = new JLabel("Boulder Dash");
		setSize(400, 550);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		panelButton.setBackground(Color.WHITE);
		panelImage.setBackground(Color.WHITE);
		panelBas.setBackground(Color.WHITE);

		this.add(panelMenu);
		this.getContentPane().add(panelImage, BorderLayout.NORTH);
		this.getContentPane().add(panelButton, BorderLayout.CENTER);
		this.getContentPane().add(panelBas, BorderLayout.SOUTH);
		panelImage.setPreferredSize(new Dimension(400, 200));
		panelBas.setPreferredSize(new Dimension(400, 200));

		panelImage.add(titre);
		panelButton.add(jouer);
		panelBas.add(editer);

		JLabel boulderlogo = new JLabel(logo);
		panelImage.add(boulderlogo);

		this.setVisible(true);
	}
}

package ihm.champ;

import java.awt.Dimension;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class ChampFrame extends JFrame {


	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	private ChampPanel contentPane;
	private String mode;
	
	/**
	 * Create the frame.
	 */
	public ChampFrame() {
		this.setResizable(false);
		this.setName("Classement Mondiaux");
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1};
		gridBagLayout.rowHeights = new int[]{1};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0};
		getContentPane().setLayout(gridBagLayout);

		contentPane = new ChampPanel();
		GridBagConstraints gbc_contentPane = new GridBagConstraints();		
		gbc_contentPane.gridy = 0;
		gbc_contentPane.gridx = 0;
		gbc_contentPane.fill = GridBagConstraints.BOTH;
		
		getContentPane().add(contentPane, gbc_contentPane);		
	}


	public String getMode() {
		return mode;
	}

	public void setMode(String type) {
		this.mode = type;
	}
	

}

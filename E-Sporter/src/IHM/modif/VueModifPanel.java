package ihm.modif;


import javax.swing.JPanel;

import controleur.ControleurModif;
import controleur.ModeleESporter;
import object.Ecurie;
import object.Equipe;
import object.Joueur;
import object.Nationalite;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class VueModifPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField NameTF;
	private JTextField firstNameTF;
	private JTextField pseudoTF;
	private JComboBox<String> natChoice;
	private Equipe e;
	private Ecurie ec;
	private Joueur j;

	public VueModifPanel(Equipe e) {
		this.e = e;
		ControleurModif controleurModif = new ControleurModif(e, this); 
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{100, 100, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel PrincPanel = new JPanel();
		PrincPanel.setLayout(null);
		GridBagConstraints gbc_PrincPanel = new GridBagConstraints();
		gbc_PrincPanel.insets = new Insets(0, 0, 5, 0);
		gbc_PrincPanel.fill = GridBagConstraints.BOTH;
		gbc_PrincPanel.gridx = 0;
		gbc_PrincPanel.gridy = 0;
		add(PrincPanel, gbc_PrincPanel);
		
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 92, 27);
		PrincPanel.add(lblNewLabel);
		
		NameTF = new JTextField(e.getNom());
		NameTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		NameTF.setBounds(10, 36, 430, 28);
		NameTF.setColumns(10);
		PrincPanel.add(NameTF);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		btnNewButton.setBounds(240, 25, 200, 50);
		btnNewButton.addActionListener(controleurModif);
		panel.add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(controleurModif);
		btnAnnuler.setForeground(new Color(255, 0, 0));
		btnAnnuler.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		btnAnnuler.setBounds(10, 25, 100, 50);
		panel.add(btnAnnuler);
	}
	
	public VueModifPanel(Ecurie ec) {
		this.ec = ec;
		ControleurModif controleurModif = new ControleurModif(ec, this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 100, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel PrincPanel = new JPanel();
		PrincPanel.setLayout(null);
		GridBagConstraints gbc_PrincPanel = new GridBagConstraints();
		gbc_PrincPanel.insets = new Insets(0, 0, 5, 0);
		gbc_PrincPanel.fill = GridBagConstraints.BOTH;
		gbc_PrincPanel.gridx = 0;
		gbc_PrincPanel.gridy = 0;
		add(PrincPanel, gbc_PrincPanel);
		
		NameTF = new JTextField(ec.getNom());
		NameTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		NameTF.setBounds(10, 36, 430, 28);
		NameTF.setColumns(10);
		PrincPanel.add(NameTF);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNom.setBounds(10, 10, 92, 27);
		PrincPanel.add(lblNom);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		JButton confBtn = new JButton("Confirmer");
		confBtn.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		confBtn.setBounds(240, 25, 200, 50);
		confBtn.addActionListener(controleurModif);
		panel.add(confBtn);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(255, 0, 0));
		btnAnnuler.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		btnAnnuler.setBounds(10, 25, 100, 50);
		btnAnnuler.addActionListener(controleurModif);
		panel.add(btnAnnuler);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public VueModifPanel(Joueur j) {
		ControleurModif controleurModif = new ControleurModif(j, this);
		this.j = j;
		System.out.println(j);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{430, 75, 0};
		gridBagLayout.columnWeights = new double[]{2.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setLayout(null);
		GridBagConstraints gbc_MainPanel = new GridBagConstraints();
		gbc_MainPanel.insets = new Insets(0, 0, 5, 0);
		gbc_MainPanel.fill = GridBagConstraints.BOTH;
		gbc_MainPanel.gridx = 0;
		gbc_MainPanel.gridy = 0;
		add(MainPanel, gbc_MainPanel);
		
		JLabel Title = new JLabel("");
		Title.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		Title.setBounds(125, 0, 200, 25);
		MainPanel.add(Title);
		
		JLabel nameLabel = new JLabel("Nom  :");
		nameLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, ModeleESporter.FONT_SIZE_LARGE));
		nameLabel.setBounds(10, 53, 120, 20);
		
		
		NameTF = new JTextField(j.getNom());
		NameTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, ModeleESporter.FONT_SIZE_LARGE));
		NameTF.setBounds(140, 53, 150, 20);
		NameTF.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom  :");
		lblPrenom.setFont(new Font("Berlin Sans FB", Font.PLAIN, ModeleESporter.FONT_SIZE_LARGE));
		lblPrenom.setBounds(10, 78, 120, 20);
		
		
		firstNameTF = new JTextField(j.getPrenom());
		firstNameTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, ModeleESporter.FONT_SIZE_LARGE));
		firstNameTF.setColumns(10);
		firstNameTF.setBounds(140, 81, 150, 20);
		
		
		JLabel lblPseudonyme = new JLabel("Pseudonyme  :");
		lblPseudonyme.setFont(new Font("Berlin Sans FB", Font.PLAIN, ModeleESporter.FONT_SIZE_LARGE));
		lblPseudonyme.setBounds(10, 108, 130, 20);
		
		
		pseudoTF = new JTextField(j.getPseudo());
		pseudoTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, ModeleESporter.FONT_SIZE_LARGE));
		pseudoTF.setColumns(10);
		pseudoTF.setBounds(140, 109, 150, 20);
		
		
		
		JPanel BtnPanel = new JPanel();
		BtnPanel.setLayout(null);
		GridBagConstraints gbc_BtnPanel = new GridBagConstraints();
		gbc_BtnPanel.insets = new Insets(0, 0, 5, 0);
		gbc_BtnPanel.fill = GridBagConstraints.BOTH;
		gbc_BtnPanel.gridx = 0;
		gbc_BtnPanel.gridy = 1;
		add(BtnPanel, gbc_BtnPanel);
		
		JButton confirmBtn = new JButton("Confirmer");
		confirmBtn.setFont(new Font("Berlin Sans FB", Font.PLAIN, ModeleESporter.FONT_SIZE_LARGE));
		confirmBtn.setBounds(275, 10, 200, 50);
		confirmBtn.addActionListener(controleurModif);
		BtnPanel.add(confirmBtn);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(255, 0, 0));
		btnAnnuler.setFont(new Font("Berlin Sans FB", Font.PLAIN, ModeleESporter.FONT_SIZE_LARGE));
		btnAnnuler.setBounds(10, 10, 200, 50);
		btnAnnuler.addActionListener(controleurModif);
		BtnPanel.add(btnAnnuler);
		
		JLabel lblNat = new JLabel("Nationalités : ");
		lblNat.setFont(new Font("Berlin Sans FB", Font.PLAIN, ModeleESporter.FONT_SIZE_LARGE));
		lblNat.setBounds(10, 138, 130, 20);
		
		DefaultComboBoxModel<String> modelNat = new DefaultComboBoxModel<>(ModeleESporter.getAllNat()); 
		natChoice = new JComboBox<>();
		natChoice.setModel(modelNat);
		natChoice.setSelectedItem(j.getNationalite().getNom());
		natChoice.setBounds(140, 140, 150, 22);
	
		
		MainPanel.add(nameLabel);
		MainPanel.add(NameTF);
		
		Title.setText("Modification d'un joueur");
		MainPanel.add(lblPrenom);
		MainPanel.add(firstNameTF);
		MainPanel.add(lblPseudonyme);
		MainPanel.add(pseudoTF);
		MainPanel.add(natChoice);
		MainPanel.add(lblNat);

	}
	
	public Equipe getAllInfoEquipe() {
		Equipe res = this.e;
		res.setNom(this.NameTF.getText());
		return res;
	}
	
	public Ecurie getAllInfoEcurie() {
		Ecurie res = this.ec;
		res.setNom(this.NameTF.getText());
		return res;
	}

	public Joueur getAllInfoJoueur() {
		Joueur res = this.j;
		System.out.println(this.j.getId());
		res.setNom(this.NameTF.getText());
		res.setPrenom(this.firstNameTF.getText());
		res.setPseudo(this.pseudoTF.getText());
		res.setNationalite(Nationalite.getByNom((String) this.natChoice.getSelectedItem()));
		res.setId(this.j.getId());
		return res;
	}
}


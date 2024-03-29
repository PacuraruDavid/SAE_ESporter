package ihm.tournois;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import controleur.ControleurInscription;
import controleur.ControleurInscriptionMouse;
import controleur.ModeleESporter;
import object.Equipe;
import object.Joueur;
import object.Nationalite;
import object.Tournoi;

import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;

public class VueInscriptionTournois extends JPanel{

	private Tournoi t;
	private Object obj;
	private static JList<Equipe> listEquipe = new JList<>();
	private static DefaultListModel<Equipe> modeleEquipe = new DefaultListModel<>();
	private static JList<Equipe> listEquipesTournoi = new JList<>();
	private static DefaultListModel<Equipe> modeleEquipeTournoi = new DefaultListModel<>();
	private static List<Equipe> suppressionList;
	private static List<Equipe> ajoutList;
	private static List<Equipe> allModeList;
	private static List<Equipe> allTournoiEquipeList;
	
	public VueInscriptionTournois(Tournoi t) {
		
		this.t = t;
		VueInscriptionTournois.allModeList = Equipe.getAllEquipesFromModeDeJeu(t.getId_Mode().getIdMode());
		VueInscriptionTournois.allTournoiEquipeList = Equipe.getAllEquipesFromTournoi(t);
		ControleurInscriptionMouse cm1 = new ControleurInscriptionMouse(this, "Equipe");
		ControleurInscriptionMouse cm2 = new ControleurInscriptionMouse(this, "EquipeTournoi");
		modeleEquipe.clear();
		System.out.println(t.getId_Mode().getIdMode());
		modeleEquipe.addAll(equipeDif(t, allModeList));		
		modeleEquipeTournoi.clear();
		modeleEquipeTournoi.addAll(allTournoiEquipeList);
		
		listEquipe = new JList<>();
		listEquipesTournoi = new JList<>();
		
		listEquipe.setModel(modeleEquipe);
		listEquipesTournoi.setModel(modeleEquipeTournoi);
				
		listEquipe.addMouseListener(cm1);
		listEquipesTournoi.addMouseListener(cm2);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{40, 200, 50, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panelTitre = new JPanel();
		GridBagConstraints gbc_panelTitre = new GridBagConstraints();
		gbc_panelTitre.insets = new Insets(0, 0, 5, 0);
		gbc_panelTitre.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelTitre.gridx = 0;
		gbc_panelTitre.gridy = 0;
		add(panelTitre, gbc_panelTitre);
		GridBagLayout gbl_panelTitre = new GridBagLayout();
		gbl_panelTitre.columnWidths = new int[]{450, 0};
		gbl_panelTitre.rowHeights = new int[]{35, 0};
		gbl_panelTitre.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelTitre.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTitre.setLayout(gbl_panelTitre);
		
		JLabel titreLbl = new JLabel(t.getNom());
		titreLbl.setFont(ModeleESporter.FONT_LARGE);
		titreLbl.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_titreLbl = new GridBagConstraints();
		gbc_titreLbl.fill = GridBagConstraints.BOTH;
		gbc_titreLbl.gridx = 0;
		gbc_titreLbl.gridy = 0;
		panelTitre.add(titreLbl, gbc_titreLbl);
		
		JPanel listPanel = new JPanel();
		GridBagConstraints gbc_listPanel = new GridBagConstraints();
		gbc_listPanel.insets = new Insets(0, 0, 5, 0);
		gbc_listPanel.fill = GridBagConstraints.BOTH;
		gbc_listPanel.gridx = 0;
		gbc_listPanel.gridy = 1;
		add(listPanel, gbc_listPanel);
		GridBagLayout gbl_listPanel = new GridBagLayout();
		gbl_listPanel.columnWidths = new int[]{225, 225, 0};
		gbl_listPanel.rowHeights = new int[]{102, 0};
		gbl_listPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_listPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		listPanel.setLayout(gbl_listPanel);
		
		JPanel panelEquipe = new JPanel();
		panelEquipe.setLayout(null);
		GridBagConstraints gbc_panelEquipe = new GridBagConstraints();
		gbc_panelEquipe.fill = GridBagConstraints.BOTH;
		gbc_panelEquipe.insets = new Insets(0, 0, 0, 5);
		gbc_panelEquipe.gridx = 0;
		gbc_panelEquipe.gridy = 0;
		listPanel.add(panelEquipe, gbc_panelEquipe);
		
		JLabel lblEquipes = new JLabel("Equipes : ");
		lblEquipes.setBounds(0, 0, 223, 30);
		panelEquipe.add(lblEquipes);
		lblEquipes.setFont(ModeleESporter.FONT_MEDIUM);
		lblEquipes.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPaneEquipe = new JScrollPane(listEquipe);
		scrollPaneEquipe.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneEquipe.setBounds(22, 40, 180, 150);
		panelEquipe.add(scrollPaneEquipe);
		
		JPanel panelEquipeTournoi = new JPanel();
		panelEquipeTournoi.setLayout(null);
		
		JScrollPane scrollPaneEquipeTournoi = new JScrollPane(listEquipesTournoi);
		scrollPaneEquipeTournoi.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneEquipeTournoi.setBounds(22, 40, 180, 150);
		panelEquipeTournoi.add(scrollPaneEquipeTournoi);
		
		GridBagConstraints gbc_panelEquipeTournoi = new GridBagConstraints();
		gbc_panelEquipeTournoi.fill = GridBagConstraints.BOTH;
		gbc_panelEquipeTournoi.gridx = 1;
		gbc_panelEquipeTournoi.gridy = 0;
		listPanel.add(panelEquipeTournoi, gbc_panelEquipeTournoi);
		
		JLabel lblEquipeTournoi = new JLabel("Equipes Tournoi :\r\n");
		lblEquipeTournoi.setBounds(0, 0, 225, 30);
		panelEquipeTournoi.add(lblEquipeTournoi);
		lblEquipeTournoi.setFont(ModeleESporter.FONT_MEDIUM);
		lblEquipeTournoi.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(null);
		GridBagConstraints gbc_btnPanel = new GridBagConstraints();
		gbc_btnPanel.fill = GridBagConstraints.BOTH;
		gbc_btnPanel.gridx = 0;
		gbc_btnPanel.gridy = 2;
		add(btnPanel, gbc_btnPanel);
		
		ControleurInscription ci = new ControleurInscription(this);

		
		JButton confirmer = new JButton("Confirmer");
		confirmer.setBounds(175, 0, 100, 50);
		btnPanel.add(confirmer);
		confirmer.addActionListener(ci);
	}

	private static List<Equipe> equipeDif(Tournoi t,List<Equipe> allEquipesFromModeDeJeu) {
		List<Equipe> res = new ArrayList<>();
		List<Equipe> equipes = Equipe.getAllEquipesFromTournoi(t);
		boolean equipesDif = false;
		for (Equipe e : allEquipesFromModeDeJeu) {
			for (Equipe e2 : equipes) {
				if (e.getId() == e2.getId()) {
					equipesDif = true;
					break;
				}
			}
			if (equipesDif == false) {
				res.add(e);
			}
			else {
				equipesDif = false;
			}
		}
		return res;
	}

	public Tournoi getTournoi() {
		return t;
	}

	public Equipe getInfoToObject() {
		if(listEquipe.getSelectedValue() == null) {
			return listEquipe.getModel().getElementAt(0);
		}
		return listEquipe.getSelectedValue();
	}
	public Equipe getListEquipesTournoi() {
		if(listEquipesTournoi.getSelectedValue() == null) {
			return listEquipesTournoi.getModel().getElementAt(0);
		}
		return listEquipesTournoi.getSelectedValue();
	}

	public List<Equipe> getAllListEquipesTournoi() {
		List<Equipe> e = new LinkedList<Equipe>();
		
		for(int i = 0; i < listEquipesTournoi.getModel().getSize(); i++) {
			e.add(listEquipesTournoi.getModel().getElementAt(i));
		}
		
		return e;
	}
	
	public static void addListEquipeTournoi(Equipe e) {
		VueInscriptionTournois.modeleEquipeTournoi.addElement(e);
	}
	
	public static void delListEquipeTournoi(Equipe e) {
		VueInscriptionTournois.modeleEquipeTournoi.removeElement(e);
	}

	public static void updateListEquipe(Tournoi t) {
		modeleEquipe.clear();
		modeleEquipe.addAll(equipeDif(t, VueInscriptionTournois.allModeList));	
		listEquipe.setModel(modeleEquipe);
		
		listEquipesTournoi.setModel(modeleEquipeTournoi);
	}
	
	public void addAjoutList(Equipe e) {
		VueInscriptionTournois.ajoutList.add(e);
	}
	
	public void delAjoutList(Equipe e) {
		VueInscriptionTournois.ajoutList.remove(e);
	}
	
	public List<Equipe> getAjoutList(){
		return VueInscriptionTournois.ajoutList;
	}
	
	public void addDelList(Equipe e) {
		VueInscriptionTournois.suppressionList.add(e);
	}
	
	public void delDelList(Equipe e) {
		VueInscriptionTournois.suppressionList.remove(e);
	}
	
	public List<Equipe> getDelList() {
		return VueInscriptionTournois.suppressionList;
	}
	
	
}

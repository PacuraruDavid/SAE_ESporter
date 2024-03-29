package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import ihm.MainPanel;
import ihm.VuePrincipale;
import object.Ecurie;
import object.Equipe;

public class ControleurRecherche implements ActionListener{
	
	private VuePrincipale vue;
	private ModeleESporter modele;
	public static List<Ecurie> rechercheEcurie = new LinkedList<>();
	public static List<Equipe> rechercheEquipe = new LinkedList<>();

	
	public ControleurRecherche(VuePrincipale vue) {
		this.vue = vue;
		this.modele = new ModeleESporter();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ModeleESporter.resultatRechercheEquipes.clear();
		ModeleESporter.resultatRechercheEcuries.clear();
		rechercheEcurie.clear();
		rechercheEquipe.clear();
		String prompt = this.vue.getTextSearch();
		//System.out.println(prompt);
		this.modele.setLastRecherche(this.modele.getRechercheEcurie(prompt), this.modele.getRecherche(prompt));
		rechercheEcurie.addAll(ModeleESporter.resultatRechercheEcuries);
		rechercheEquipe.addAll(ModeleESporter.resultatRechercheEquipes);
		MainPanel.changeModelElementEquipe(rechercheEquipe);
		MainPanel.changeModelElementEcurie(rechercheEcurie);
	}

}

package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ihm.add.AddFrame;

public class ControleurAddFrame implements ActionListener{
	
	private AddFrame frame;
	private Object obj;
	
	public ControleurAddFrame(Object obj) {
		this.frame = null;
		this.obj = obj;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		switch(btn.getText()) {
			case "Ajouter un joueur":{
				this.frame = new AddFrame("Player", this.obj);
				this.frame.setVisible(true);
				break;
			}
			case "Ajouter une équipe":{
				this.frame = new AddFrame("Team", this.obj);
				this.frame.setVisible(true);
				break;
			}
			case "Ajouter une écurie":{
				this.frame = new AddFrame("Orga", null);
				this.frame.setVisible(true);
				break;
			}
			case "Ajouter un tournoi":{
				this.frame = new AddFrame("Tournament", null);
				this.frame.setVisible(true);
				break;
			}
			default:{
				break;
			}
		}
		
		
	}

}

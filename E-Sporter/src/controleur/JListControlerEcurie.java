package controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;

import IHM.SeeOrganisationInfoFrame;
import IHM.SeeTeamInfoFrame;
import Object.Ecurie;
import Object.Equipe;

public class JListControlerEcurie implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		JList<Ecurie> list = (JList<Ecurie>) e.getSource();
		int index = list.locationToIndex(e.getPoint());
		System.out.println(list.getModel().getElementAt(index).toString());
		SeeOrganisationInfoFrame window = new SeeOrganisationInfoFrame(list.getModel().getElementAt(index));
		window.setVisible(true);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
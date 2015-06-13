package graphique;

//En gros sa permet de modifier larraylist pour donner un meilleur visuel, sa sapplique
//pour arraylist des voeux




import generated.Voeu;
import generated.decision;
import generated.etatvoeux;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author puls2
 */
class MyCellRenderer extends JLabel implements ListCellRenderer<Object> {

	ImageIcon icon; 
	ImageIcon selectIconI;
	ImageIcon selectIconH;
	ImageIcon selectIconE;
	Color selectCouleur = Color.RED;
	Client cl;
	public  MyCellRenderer(Client clp){
		icon = new ImageIcon(getClass().getResource("Postuler.jpg"));
		cl = clp;
	}



	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list,
			Object values, int index, boolean isSelected, boolean cellHasFocus) {

		//Le contenu de mon voeux


		//si lobjet est selectioner 
		if (isSelected) {
			Voeu vx=( Voeu)list.getSelectedValue();
			setBackground(list.getSelectionBackground());
			setForeground(selectCouleur);
			/*if(vx.dcsEtudiant!=decision.NONutilse)
			{
			
				cl.bouttonchoix(true);
			}
			else
			{
				cl.bouttonchoix(false);	
			}*/
			
			if(vx.etatVoeu==etatvoeux.accepter)
			{
				cl.bouttonchoix(true);
			}
			else
			{
				cl.bouttonchoix(false);
			}
			
			setText("ordre: "+vx.numeroVoeu+" Université:"+vx.formationVoeu.nomUniv+" type de formation:"+vx.formationVoeu.TypeFormation);
			
			if(vx.formationVoeu.TypeFormation.equals("Informatique"))
			{
				//Pour l'instant je leur met tous la meme image.
				setIcon(icon);
			}else if(vx.formationVoeu.TypeFormation.equals("math")){
				setIcon(icon);
			}else if(vx.formationVoeu.TypeFormation.equals("physique")){
				setIcon(icon);
			} else {
				setIcon(icon);

			}

		}else
		{

			Voeu vx = ( Voeu)values;

			if(vx.dcsEtudiant!=decision.NONutilse)
			{
				setText("Nom Formation:"+vx.formationVoeu.NomFormation+" Reponse:"+vx.dcsEtudiant);
				cl.bouttonchoix(true);
			}
			else
			{
				setText("Nom Formation:"+vx.formationVoeu.NomFormation+" Etat:"+vx.etatVoeu);
				cl.bouttonchoix(false);
			}

			setBackground(list.getBackground());
			setForeground(list.getForeground());

			setIcon(icon);
		}
		setEnabled(list.isEnabled());
		setFont(list.getFont());
		setOpaque(true);
		return this;
	}
}

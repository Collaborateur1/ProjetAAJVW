package devON;

//En gros sa permet de modifier larraylist pour donner un meilleur visuel, sa sapplique
//pour arraylist des voeux




import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import PostLicence.Voeu;


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
   public  MyCellRenderer(){
      icon = new ImageIcon(getClass().getResource("math.png"));
    
   }
  


@Override
public Component getListCellRendererComponent(JList<? extends Object> list,
		Object values, int index, boolean isSelected, boolean cellHasFocus) {
	 
    //Le contenu de mon voeux
    String s = values.toString();
	
    //si lobjet est selectioner 
    if (isSelected) {
    	Voeu vx=( Voeu)list.getSelectedValue();
       setBackground(list.getSelectionBackground());
       setForeground(selectCouleur);
       
      setText(vx.toString());
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
       
    }else{
        //j'y comprend rien javais pas comenter *.*"
        //en gros sa c'est quand on clique pas sur nos voeux
       setBackground(list.getBackground());
       setForeground(list.getForeground());
       setText(s);
       setIcon(icon);
    }
    setEnabled(list.isEnabled());
    setFont(list.getFont());
    setOpaque(true);
    return this;
}
}

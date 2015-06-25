package graphique;

//package ebay_project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Liste des Boutons:
bouton "recherche" jButton3
bouton  "->Fair un voeu->" jButton2
bouton "modifier" jButton7
bouton "descendre" jButton5
bouton "accepter" jButton9
bouton refusé jButton8
bouton modifierProfil jButton4   
bouton déconnecter jButton6
bouton a cocher "math" jCheckBox1
bouton a cocher "info" jCheckBox2
bouton a cocher "droit" jCheckBox3
bouton a cocher "gestion" jCheckBox4
bouton a cocher "psyco" jCheckBox15
Le champs pour rentrer les recherche jTextfield1
la liste qui affiche les recherches  jList1
la liste qui affiche les voeux choisie  jList2
champ Nom :jLabel3
 prenom : jLabel6
 adresse : jLabel7
 mail  : jLabel5
 */

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.Formation;
import generated.UtilisationInterdite;
import generated.Voeu;
import generated.decision;
import generated.etatvoeux;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ListModel;

import classeIMPL.EtudiantIMPl;
/**
 *
 * @author Vinss
 */
public class Client extends javax.swing.JFrame {

	/**
	 * Creates new form Client
	 */

	EtudiantIMPl etudiant;  

	public void Initialisation_Element_Interface()
	{
		//personnaliser graphiquement la jlist
		jList2.setCellRenderer(new MyCellRenderer(this));
		jList1.setCellRenderer(new MyCellRendererRecherche());

	}


	public Client(EtudiantIMPl etu) {
		initComponents();

		etudiant=etu;
		Initialisation_Element_Interface();
		

	}

	public Client() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(245, 245, 225));

        jTabbedPane1.setBackground(new java.awt.Color(245, 245, 225));

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton4.setText("Modifier mon profil");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jButton6.setBackground(new java.awt.Color(255, 102, 102));
        jButton6.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton6.setText("Se deconnecter");
        jButton6.setAutoscrolls(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(59, 89, 152));
        jLabel20.setText("Nom");

        jLabel21.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(59, 89, 152));
        jLabel21.setText("Prenom");

        jLabel22.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(59, 89, 152));
        jLabel22.setText("E-mail@");

        jLabel23.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(59, 89, 152));
        jLabel23.setText("Adresse");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)))
                        .addGap(118, 118, 118)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(34, 34, 34)))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Profil", jPanel2);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphique/fleche_haut.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton1ActionPerformed(evt);
				} catch (DonneesInvalides e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UtilisationInterdite e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jButton2.setText(">");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton2ActionPerformed(evt);
				} catch (DonneesInvalides | UtilisationInterdite e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jLabel15.setFont(new java.awt.Font("Cambria", 1, 21)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 0, 0));
        jLabel15.setText("Accueil Post Licence");

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton3.setText("Rechercher");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jButton5.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphique/fleche_bas.png"))); // NOI18N
        jButton5.setActionCommand("Monter");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton5ActionPerformed(evt);
				} catch (DonneesInvalides | UtilisationInterdite e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jButton7.setText("<");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton7ActionPerformed(evt);
				} catch (DonneesInvalides | UtilisationInterdite e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jComboBox1.setBackground(new java.awt.Color(204, 204, 255));
        jComboBox1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selectionner", "OUI", "OUI MAIS", "NON MAIS", "NON" }));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphique/marianne.png"))); // NOI18N

        jButton8.setText("Valider");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton8ActionPerformed(evt);
				} catch (DonneesInvalides | UtilisationInterdite e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(371, 371, 371))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addGap(478, 478, 478))
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(75, 75, 75))))
        );

        jTabbedPane1.addTab("Page Accueil", jPanel1);

        jScrollPane7.setBackground(new java.awt.Color(245, 245, 225));
        jScrollPane7.setForeground(new java.awt.Color(245, 245, 225));

        jLabel10.setBackground(new java.awt.Color(245, 245, 225));
        jLabel10.setForeground(new java.awt.Color(0, 102, 255));
        jLabel10.setAutoscrolls(true);
        jScrollPane7.setViewportView(jLabel10);

        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Copyright © 2015 Amel BELKACEMI, Wassef BHIH, Alex COMBEMOREL & Jean Vincent GENNADE. All rights reserved.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(253, Short.MAX_VALUE)
                        .addComponent(jLabel14)))
                .addGap(2, 2, 2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) throws DonneesInvalides, UtilisationInterdite {//GEN-FIRST:event_jButton7ActionPerformed
		// TODO add your handling code here:

		if(jList2.getSelectedValue()instanceof Voeu )	
		{
			Voeu Vx=(Voeu) jList2.getSelectedValue();
			etudiant.supprimerVoeu(etudiant.getINE(), Vx.numeroVoeu);

		}

	}//GEN-LAST:event_jButton7ActionPerformed

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) throws DonneesInvalides, UtilisationInterdite {//GEN-FIRST:event_jButton5ActionPerformed
		// TODO add your handling code here:
		//bouton descendre
		short derniereplace;
		short descendre=0;
		if(jList2.getSelectedValue()instanceof Voeu )	
		{
			ListModel< Voeu> list =jList2.getModel();
			derniereplace=(short) list.getSize();
			Voeu Vx=(Voeu) jList2.getSelectedValue();

			if(derniereplace!=Vx.numeroVoeu)
			{
				etudiant.modifierVoeu(etudiant.getINE(), Vx.numeroVoeu, descendre);

			}



		}


	}//GEN-LAST:event_jButton5ActionPerformed

	private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
		// TODO add your handling code here:
	}//GEN-LAST:event_jList2ValueChanged

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
		//Bouton recherche
		// TODO add your handling code here:
		if(!jTextField1.equals(""))
		{
			Formation[] fr = null;
			ArrayList array = new ArrayList<Formation>();
			if(etudiant.getGDV().existFormation(jTextField1.getText()))
			{
				fr= etudiant.getGDV().rechercherFormation(jTextField1.getText());
				array= new ArrayList<Formation>();
				for(int i=0;i<fr.length;i++)
				{

					array.add(fr[i]);

				}
			}



			if(!array.isEmpty())
				jList1.setListData(array.toArray());
		}    





	}//GEN-LAST:event_jButton3ActionPerformed

	//Permet d'enchérire un objet

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws DonneesInvalides, UtilisationInterdite {//GEN-FIRST:event_jButton2ActionPerformed
		//bouton "faire un voeu"

		if(jList1.getSelectedValue()instanceof Formation )	
		{

			Voeu vx;
			short flag = 0;
			int i=0;
			ListModel<Voeu> list =jList2.getModel();
			short placeVoeux = (short) (list.getSize()+1);


			if(placeVoeux<6)
			{
				Voeu voeux=new Voeu((Formation)jList1.getSelectedValue(), etatvoeux.soumis, decision.NONutilse,placeVoeux,etudiant.getGDV().numeroGDV());
				for(int y=0;y<list.getSize();y++)
				{
					if(voeux.formationVoeu.NomFormation.equals(list.getElementAt(y).formationVoeu.NomFormation))
						flag = 1;
				}

				if(flag == 0)
					etudiant.fairVoeux(voeux,etudiant.getINE(),placeVoeux);
				else
					jLabel10.setText("Vous ne pouvez pas faire 2 fois le voeu "+voeux.formationVoeu.NomFormation);
			}
			else
				jLabel10.setText("Vous avez deja 5 voeux dans votre liste");



		}
		else
		{
			jLabel10.setText("Selectionner une formation -.-");
		}

	}//GEN-LAST:event_jButton2ActionPerformed

	//
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws DonneesInvalides, UtilisationInterdite {//GEN-FIRST:event_jButton1ActionPerformed
		short place1=1;
		short monter=1;
		if(jList2.getSelectedValue()instanceof Voeu )	
		{

			Voeu Vx=(Voeu) jList2.getSelectedValue();
			if(Vx.numeroVoeu!=place1)
			{
				etudiant.modifierVoeu(etudiant.getINE(), Vx.numeroVoeu, monter);
			}
		}

		// }
}//GEN-LAST:event_jButton1ActionPerformed

	//Comporte la mise a jour du slider, lors de la selction d'un objet 
	//dans la partie recherche d'objet
	//a chaque fois q'un onjet est selectionné la jlist s'adapte
	private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged

		// TODO add your handling code here:
	}//GEN-LAST:event_jList1ValueChanged

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextField1ActionPerformed

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jComboBox1ActionPerformed

	// La deconnexion
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //bouton déconnecter
        etudiant.deconnexion(etudiant.getINE());
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

	//Listener du bouton connexion, valide ou pas la connexion
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //bouton modifierProfil
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) throws DonneesInvalides, UtilisationInterdite {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String choixVoeu = (String) jComboBox1.getSelectedItem();
		if(jList2.getSelectedValue()instanceof Voeu )	
		{
			Voeu v=(Voeu) jList2.getSelectedValue();

			switch (choixVoeu)
			{
			case "OUI":
				etudiant.repondreAunVoeu(etudiant.getINE(), v.numeroVoeu, decision.OUIdefinitif);
				break;
			case "NON":
				etudiant.repondreAunVoeu(etudiant.getINE(), v.numeroVoeu, decision.NONdefinitif);
				break;
			case "OUI MAIS":
				etudiant.repondreAunVoeu(etudiant.getINE(), v.numeroVoeu, decision.OUImais);
				break;
			case "NON MAIS":
				etudiant.repondreAunVoeu(etudiant.getINE(), v.numeroVoeu, decision.NONmais);
				break;
			default:
				jLabel10.setText("Veuillez choisir une r�ponse pour ce voeu");
				break;
			}
		}
		else
			jLabel10.setText("Veuillez selectionner un voeu");
    }//GEN-LAST:event_jButton8ActionPerformed


	public void configuration_de_connexion(Etudiant etudiant,Voeu[] vx)
	{


		if(vx!=null)
		{
			ArrayList array=new ArrayList(); 

			for(int i=0;i<vx.length;i++)
			{
				array.add(vx[i]);
			}
			jList2.setListData(array.toArray());

		}

		jLabel3.setText(etudiant.nomEtudiant);
		jLabel6.setText(etudiant.prenomEtudiant);
		jLabel7.setText(etudiant.adresse);
		jLabel5.setText(etudiant.nomEtudiant+"univ.fr");

	}

	public void miseAjourJlist2(Voeu[] vx)
	{
		if(vx!=null)
		{
			ArrayList array=new ArrayList(); 

			for(int i=0;i<vx.length;i++)
			{
				array.add(vx[i]);
			}
			jList2.setListData(array.toArray());

		} 
	}
	
	public void miseAjourJlist2(ArrayList array)
	{
		if(array!=null)
		{
			
			jList2.setListData(array.toArray());

		} 
	}
	public void deconnexion()
	{

	}
	public void notification( String st) 
	{
     jLabel10.setText(st);
     if(st.contains("vous navez plus de voeux"))
     {
    	ArrayList<Voeu> array =new ArrayList<Voeu>();
    	
    	 jList2.setListData(array.toArray());
     }
	}
	public void Mise_a_Jour_Parametre_ConnexionEtablit() 
	{

	}   
	//La mise a jour de longlet recherche 
	public void Mise_a_Jour_Recherche(ArrayList array)
	{

	}
	public void lancementVague1()
	{
		jButton1.setEnabled(false);
		jButton2.setEnabled(false);
		jButton7.setEnabled(false);
		jButton5.setEnabled(false);
	}
	public void lancementVague2()
	{
		jButton1.setEnabled(false);
		jButton2.setEnabled(false);
		jButton7.setEnabled(false);
		jButton5.setEnabled(false);
	}
	
	
	public void bouttonchoix(boolean b)
	{
		jButton8.setEnabled(b);
		jComboBox1.setVisible(b);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Client().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
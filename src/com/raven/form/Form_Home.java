/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.bd.DatabaseConnector;
import com.raven.main.Main;
import com.raven.model.Model_Card;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

/**
 *
 * @author lenovo
 */
public class Form_Home extends javax.swing.JPanel {
private Main main;
    /**
     * Creates new form Form_Home
     */
    public Form_Home(Main main) {
        
        initComponents();
        this.main = main;
        int nbReserve = getCaftanCountByAvailability("no");
        int nbDispo = getCaftanCountByAvailability("yes");
        
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Caftans réservés", nbReserve));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/profit.png")), "Caftans disponibles", nbDispo));
       }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card1 = new com.raven.component.Card();
        card2 = new com.raven.component.Card();
        nvCaf = new javax.swing.JButton();
        nvRes1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        card1.setColor1(new java.awt.Color(255, 102, 102));
        card1.setColor2(new java.awt.Color(153, 0, 102));

        card2.setColor1(new java.awt.Color(255, 204, 102));
        card2.setColor2(new java.awt.Color(255, 102, 51));

        nvCaf.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        nvCaf.setText("Nouveau Caftan");
        nvCaf.setBorder(null);
        nvCaf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nvCafActionPerformed(evt);
            }
        });

        nvRes1.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        nvRes1.setText("Nouvelle Reservation");
        nvRes1.setBorder(null);
        nvRes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nvRes1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nvCaf, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nvRes1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(208, 208, 208))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addComponent(nvRes1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nvCaf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nvCafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nvCafActionPerformed
        // TODO add your handling code here:
         Form_AddItem addItemForm = new Form_AddItem(main);
    
    // Make the form visible
    addItemForm.setVisible(true);
        
    }//GEN-LAST:event_nvCafActionPerformed

    private void nvRes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nvRes1ActionPerformed
        // TODO add your handling code here:
         Form_2 form2 = new Form_2();
         form2.setVisible(true);
         //setForm(form2);
      
    }//GEN-LAST:event_nvRes1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private javax.swing.JButton nvCaf;
    private javax.swing.JButton nvRes1;
    // End of variables declaration//GEN-END:variables

    private int getCaftanCountByAvailability(String availability) {
        int count = 0;
    try {
        Connection connection = DatabaseConnector.getConnection();
        // Execute a query to count the number of caftans with the given availability
        String query = "SELECT COUNT(*) FROM caftan WHERE availability = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, availability);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        resultSet.close();
        statement.close();
    } catch (SQLException ex) {
        // Handle any SQL exceptions here
        ex.printStackTrace();
    }
    return count;
    
         }

    public void refreshHomeFormData() {
    // Update the data displayed on the home form
    int nbReserve = getCaftanCountByAvailability("no");
    int nbDispo = getCaftanCountByAvailability("yes");
    
    // Update the data on the cards
    card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Caftans réservés", nbReserve));
    card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/profit.png")), "Caftans disponibles", nbDispo));
}
}

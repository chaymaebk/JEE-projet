/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.component;

import com.raven.bd.DatabaseConnector;
import com.raven.form.Form_AddItem;
import com.raven.main.Main;
import com.raven.model.ModelItem;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class Item extends javax.swing.JPanel {
  private Main main; 
// Add a field to store the Main object
    /**
     * @return the data
     */
    public ModelItem getData() {
        return data;
    }

     private boolean selected;
   public Item(Main main) {
        this.main = main; // Initialize the Main object
        initComponents();
        setOpaque(false);
    }
    private ModelItem data;
    public void setData(ModelItem data){
        this.data = data;
        id.setText(String.valueOf(data.getItemID()));
        pic.setImage(data.getImage());
        IbItemName.setText(data.getItemName());
        IbItemDescription.setText(data.getDescription());
        IbBrand.setText(data.getBrandName());
        DecimalFormat df = new DecimalFormat("DH#,##0.00");
        IbPrice.setText(df.format(data.getPrice()));
        
    }
   
    @Override
    public void paint(Graphics grphcs){
        Graphics2D g2=(Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242,242,242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
          if (selected) {
            g2.setColor(new Color(94, 156, 255));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        g2.dispose();
        super.paint(grphcs);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IbItemName = new javax.swing.JLabel();
        IbItemDescription = new javax.swing.JLabel();
        pic = new com.raven.swing.PictureBox();
        IbPrice = new javax.swing.JLabel();
        IbBrand = new javax.swing.JLabel();
        supprimer = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();

        IbItemName.setFont(new java.awt.Font("Liberation Serif", 1, 18)); // NOI18N
        IbItemName.setForeground(new java.awt.Color(76, 76, 76));
        IbItemName.setText("Item Name");

        IbItemDescription.setFont(new java.awt.Font("Liberation Serif", 1, 14)); // NOI18N
        IbItemDescription.setForeground(new java.awt.Color(178, 178, 178));
        IbItemDescription.setText("Item Name");

        pic.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/raven/images/pp.png"))); // NOI18N

        IbPrice.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        IbPrice.setForeground(new java.awt.Color(76, 76, 76));
        IbPrice.setText("$0.00");

        IbBrand.setFont(new java.awt.Font("Liberation Serif", 1, 14)); // NOI18N
        IbBrand.setForeground(new java.awt.Color(76, 76, 76));
        IbBrand.setText("Brand");

        supprimer.setBackground(new java.awt.Color(241, 110, 110));
        supprimer.setFont(new java.awt.Font("Liberation Serif", 0, 15)); // NOI18N
        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        modifier.setBackground(new java.awt.Color(143, 182, 220));
        modifier.setFont(new java.awt.Font("Liberation Serif", 0, 15)); // NOI18N
        modifier.setText("Modifier");
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(76, 76, 76));
        jLabel1.setText("ID:");

        id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        id.setText("id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IbBrand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IbPrice)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modifier)
                                .addGap(18, 18, 18)
                                .addComponent(supprimer))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(IbItemName, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(IbItemDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IbItemName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IbItemDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IbPrice)
                    .addComponent(IbBrand))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifier)
                    .addComponent(supprimer))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        // TODO add your handling code here:
    int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de bien vouloir supprimer cet élément?", "Confirmation", JOptionPane.YES_NO_OPTION);
    if (confirmation == JOptionPane.YES_OPTION) { int itemId = data.getItemID();
        // Remove the item from the database using the Main object
        main.removeItemFromDatabase(itemId);
    
        // Get the parent container of this item
        java.awt.Container parent = this.getParent();
    
        // Remove this item from its parent container
        parent.remove(this);
    
        // Repaint the parent container to reflect the changes
        parent.repaint();
        parent.revalidate();
        // Perform deletion action
        // Write your deletion logic here
    } else {
        // User clicked No or closed the dialog, do nothing
    }


       
        
    }//GEN-LAST:event_supprimerActionPerformed
  
private void openModifyItemForm(ModelItem itemToModify) throws IOException {
    // Create a new instance of Form_AddItem with the item to modify
    Form_AddItem modifyForm = new Form_AddItem(itemToModify,main);
    
    // Show the Form_AddItem frame
    modifyForm.setVisible(true);
}

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
      try {
          openModifyItemForm(data);
      } catch (IOException ex) {
          Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_modifierActionPerformed

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IbBrand;
    private javax.swing.JLabel IbItemDescription;
    private javax.swing.JLabel IbItemName;
    private javax.swing.JLabel IbPrice;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton modifier;
    private com.raven.swing.PictureBox pic;
    private javax.swing.JButton supprimer;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.form;

import com.raven.main.Main;
import com.raven.model.ModelItem;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class Form_AddItem extends javax.swing.JFrame {
   private ModelItem currentItem;
       private boolean isVariabilitySelected; // Variable to track the state of the checkbox
   
     private Main main;
     private byte[] imageData;
    public Form_AddItem(Main main) {
        if (main == null) {
            System.err.println("Main object is null!");
        }
        this.main = main;
        initComponents();
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }
    public Form_AddItem(ModelItem currentItem,Main main) throws IOException {
        // Add this line in the constructor of Form_AddItem just before setVisible(true)

        this.main = main;
        initComponents();
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        this.currentItem = currentItem;
        
        // Populate form fields with existing item's details
        jTextFieldName.setText(currentItem.getItemName());
        jTextFieldDescription.setText(currentItem.getDescription());
        DecimalFormat df = new DecimalFormat("#.00");
    jTextFieldPrice.setText(df.format(currentItem.getPrice()));
        jTextFieldBrand.setText(currentItem.getBrandName());
       jCheckBoxVariability.setSelected(currentItem.getDispo());
     ImageIcon currentImageIcon = (ImageIcon) currentItem.getImage();
    picBox.setImage(currentImageIcon);
    BufferedImage bufferedImage = new BufferedImage(currentImageIcon.getIconWidth(), currentImageIcon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = bufferedImage.createGraphics();
    g2d.drawImage(currentImageIcon.getImage(), 0, 0, null);
    g2d.dispose();

    // Convert BufferedImage to byte array and assign to instance variable
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(bufferedImage, "png", baos);
    this.imageData = baos.toByteArray();
        
    }

  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ajouter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldDescription = new javax.swing.JTextField();
        jTextFieldBrand = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCheckBoxVariability = new javax.swing.JRadioButton();
        ouvrir = new javax.swing.JButton();
        picBox = new com.raven.swing.PictureBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ajouter.setBackground(new java.awt.Color(255, 221, 184));
        ajouter.setFont(new java.awt.Font("Liberation Serif", 1, 18)); // NOI18N
        ajouter.setText("Enregistrer");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Serif", 0, 18)); // NOI18N
        jLabel1.setText("Type");

        jLabel2.setFont(new java.awt.Font("Liberation Serif", 0, 18)); // NOI18N
        jLabel2.setText("Description");

        jLabel3.setFont(new java.awt.Font("Liberation Serif", 0, 18)); // NOI18N
        jLabel3.setText("Prix");

        jLabel4.setFont(new java.awt.Font("Liberation Serif", 0, 18)); // NOI18N
        jLabel4.setText("Taille");

        jLabel5.setFont(new java.awt.Font("Liberation Serif", 0, 18)); // NOI18N
        jLabel5.setText("Image");

        jCheckBoxVariability.setFont(new java.awt.Font("Liberation Serif", 0, 18)); // NOI18N
        jCheckBoxVariability.setText("Disponibilité");
        jCheckBoxVariability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxVariabilityActionPerformed(evt);
            }
        });

        ouvrir.setFont(new java.awt.Font("Liberation Serif", 0, 18)); // NOI18N
        ouvrir.setText("Ouvrir");
        ouvrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouvrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1)))
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addComponent(jTextFieldDescription)
                    .addComponent(jTextFieldBrand)
                    .addComponent(jTextFieldPrice))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jCheckBoxVariability))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ouvrir, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(picBox, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jCheckBoxVariability)
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ouvrir)))
                    .addComponent(picBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private byte[] readImageFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] imageData = new byte[(int) file.length()];
        fis.read(imageData);
        fis.close();
        return imageData;
    }

private void showErrorDialog(String message) {
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
}

private boolean validateFields() {
    // Validate input fields
    String name = jTextFieldName.getText();
    String description = jTextFieldDescription.getText();
    String priceText = jTextFieldPrice.getText();
    String brand = jTextFieldBrand.getText();
    boolean variability = jCheckBoxVariability.isSelected(); 
    byte[] imageData1 = imageData; // You need to implement this method to retrieve image data

    // Check if any field is empty or invalid
    if (name == null || name.isEmpty() || description == null || description.isEmpty() || priceText.isEmpty() || brand == null || brand.isEmpty() || imageData == null) {
        showErrorDialog("Veuillez remplir tous les champs correctement.");
        return false;
    }

    // Validate price
    try {
        double price = Double.parseDouble(priceText);
        if (price <= 0) {
            showErrorDialog("Veuillez saisir un prix positif valide.");
            return false;
        }
    } catch (NumberFormatException e) {
        showErrorDialog("Please enter a valid numeric price.");
        return false;
    }

    return true; // All fields are valid
}




    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
         if (!validateFields()) {
        return; // Stop further processing if fields are invalid
    } 
         
         // Get item details from text fields
    String name = jTextFieldName.getText();
    String description = jTextFieldDescription.getText();
    String priceText = jTextFieldPrice.getText();
    String brand = jTextFieldBrand.getText();
    boolean variability = jCheckBoxVariability.isSelected(); 
    String availability = variability ? "yes" : "no"; // Simplified using ternary operator
    
    // Input validation for price
    double price = 0;
    try {
        price = Double.parseDouble(priceText);
        if (price < 0) {
            throw new NumberFormatException(); // Ensure price is non-negative
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Veuillez saisir un prix numérique positif valide.", "Prix invalide", JOptionPane.ERROR_MESSAGE);
        return; // Exit the method if price is invalid
    }
    
    int roundedPrice = (int) Math.round(price); // Round to the nearest integer
    
    // Check if main object is null
    if (main != null) {
        try {
            if (currentItem != null) {
                // Update the existing item in the database
                main.updateItemInDatabase(currentItem.getItemID(), name, description, roundedPrice, brand, availability, imageData);
            } else {
                // Add the new item to the database
                main.addItemToDatabase(name, description, roundedPrice, brand, availability, imageData);
            }
            // Refresh the items in the main form
            main.testData();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error processing item data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Handle case where main object is null
        System.err.println("Main object is null! Cannot perform database operations.");
    }
    // Close the add item form
    this.dispose();
    }//GEN-LAST:event_ajouterActionPerformed

    private void jCheckBoxVariabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxVariabilityActionPerformed
        // TODO add your handling code here:
       if (currentItem != null) {
        currentItem.setDispo(jCheckBoxVariability.isSelected());
    }
    }//GEN-LAST:event_jCheckBoxVariabilityActionPerformed

    private void ouvrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ouvrirActionPerformed
       JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        try {
            // Read the image file and convert it to a byte array
            imageData = readImageFile(selectedFile);
            ImageIcon imageIcon = new ImageIcon(imageData);
            // Set the ImageIcon to a JLabel
            picBox.setImage(imageIcon.getImage());
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading image file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_ouvrirActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JRadioButton jCheckBoxVariability;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldBrand;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JButton ouvrir;
    private com.raven.swing.PictureBox picBox;
    // End of variables declaration//GEN-END:variables
}

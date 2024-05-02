/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import java.text.SimpleDateFormat;
/**
 *
 * @author RAVEN
 */
public class Form_2 extends javax.swing.JPanel {
private Connection conn;
    private DefaultTableModel tableModel;
    /**
     * Creates new form Form_1
     */
    public Form_2() {
        initComponents();
        initDatabase();
        loadRentalData();
        //loadData();
        
    }
private void initDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/caftansshop", "root", "");
            System.out.println("Driver Success");            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadRentalData() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM rental");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = metaData.getColumnName(i);
            }

            tableModel = new DefaultTableModel(columnNames, 0);
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(rowData);
            }

            jTable1.setModel(tableModel);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     private void ADD(java.awt.event.ActionEvent evt) {                                       
        String n,ic, icf, query;
        
        //connect to database
        try {
            Statement st = conn.createStatement();
            if("".equals(id_caftan.getText())){
             
                JOptionPane.showMessageDialog(new JFrame(), "ID du caftan est nécessaire", "Dialog",
                                     JOptionPane.ERROR_MESSAGE);
            }else if("".equals(id_client.getText())){
             
                JOptionPane.showMessageDialog(new JFrame(), "ID du client est nécessaire", "Dialog",
                                     JOptionPane.ERROR_MESSAGE);
            }else if(date_start.getDate()==null){
             
                JOptionPane.showMessageDialog(new JFrame(), "Date de début est nécessaire", "Dialog",
                                     JOptionPane.ERROR_MESSAGE);
            }else if(date_end.getDate()==null){
             
                JOptionPane.showMessageDialog(new JFrame(), "Date de fin est nécessaire", "Dialog",
                                     JOptionPane.ERROR_MESSAGE);
            }else {
                int s = 0;
                n = id.getText();
                icf = id_caftan.getText();
                ic = id_client.getText();
                double sommeValue = 0.0; // Replace 0.0 with the desired decimal value
                query = "INSERT INTO `rental`(`rental_id`, `item_id`, `user_id`, `start_date`, `end_date`, `somme`)"
                        + "VALUES ('"+s+"','"+icf+"','"+ic+"','"+new SimpleDateFormat("yyyy-MM-dd").format(date_start.getDate())+"','"+new SimpleDateFormat("yyyy-MM-dd").format(date_end.getDate())+"', '"+sommeValue+"')";
               
               st.executeUpdate(query);
               id_caftan.setText("");
               id_client.setText("");
               date_start.setDate(null);
               date_end.setDate(null);
               showMessageDialog(null, "Ajout avec succés.");
               loadRentalData();
               //conn.close();
            }   
        }catch(Exception e){
            System.out.println("Error "+ e.getMessage());
            
        }}
       
     private void update(java.awt.event.ActionEvent evt) {                                       
        String ID;
        int notFound = 0;
        String ic, icf;
        try {
            Statement st = conn.createStatement();
            
            ID = id.getText();
            if("".equals(ID)){
              JOptionPane.showMessageDialog(new JFrame(), "ID est nécessaire", "Dialog",
                                     JOptionPane.ERROR_MESSAGE);
            }else {
               String sql = "SELECT * FROM rental WHERE rental_id="+ID;
               ResultSet rs = st.executeQuery(sql);
               while(rs.next()){
                 notFound = 1;
                icf = id_caftan.getText();
                ic = id_client.getText();
                double sommeValue = 0.0;
                //String sql2 = "UPDATE `rental` SET `item_id`='"+icf+"', user_id='"+ic+"', start_date='"+new SimpleDateFormat("yyyy-MM-dd").format(date_start.getDate())+"',end_date='"+new SimpleDateFormat("yyyy-MM-dd").format(date_end.getDate())+"', somme='"+sommeValue+"' WHERE rental_id="+ID;
                 String sql3 ="UPDATE `rental` r " +
              "JOIN `caftan` c ON r.item_id = c.item_id " +
              "SET r.`item_id`='" + icf + "', " +
              "r.user_id='" + ic + "', " +
              "r.start_date='" + new SimpleDateFormat("yyyy-MM-dd").format(date_start.getDate()) + "', " +
              "r.end_date='" + new SimpleDateFormat("yyyy-MM-dd").format(date_end.getDate()) + "', " +
              "r.somme = DATEDIFF('" + new SimpleDateFormat("yyyy-MM-dd").format(date_end.getDate()) + "', '" + new SimpleDateFormat("yyyy-MM-dd").format(date_start.getDate()) + "') * c.price " +
              "WHERE r.rental_id=" + ID;
                 st.executeUpdate(sql3); 
                 showMessageDialog(null, "Modifié avec succés.");
                 loadRentalData();
                 //con.close();
               }
               if(notFound == 0){
                  JOptionPane.showMessageDialog(new JFrame(), "invalid ID", "Dialog",
                                     JOptionPane.ERROR_MESSAGE);
               }
            }
        }catch(Exception e){
            System.out.println("Error "+ e.getMessage());
            
        } 
    }
     
     private void delete(java.awt.event.ActionEvent evt) {                                       
        String ID;
        int notFound = 0;
        try {
            Statement st = conn.createStatement();
            
            ID = id.getText();
            if("".equals(ID)){
              JOptionPane.showMessageDialog(new JFrame(), "ID est nécessaire", "Dialog",
                                     JOptionPane.ERROR_MESSAGE);
            }else {
               String sql = "SELECT * FROM rental WHERE rental_id="+ID;
               ResultSet rs = st.executeQuery(sql);
               while(rs.next()){
                 notFound = 1;
                 String sql2 = "DELETE FROM rental WHERE rental_id="+ID;
                 st.executeUpdate(sql2); 
                 showMessageDialog(null, "Supprimmé avec succés.");
                 loadRentalData();
                 //con.close();
               }
               if(notFound == 0){
                  JOptionPane.showMessageDialog(new JFrame(), "invalid ID", "Dialog",
                                     JOptionPane.ERROR_MESSAGE);
               }
            }
        }catch(Exception e){
            System.out.println("Error "+ e.getMessage());
            
        }  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        id_caftan = new javax.swing.JTextField();
        id_client = new javax.swing.JTextField();
        ajouter = new javax.swing.JButton();
        date_start = new com.toedter.calendar.JDateChooser();
        date_end = new com.toedter.calendar.JDateChooser();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID du caftan", "ID du client", "Date de début", "Date de fin", "Somme"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setPreferredSize(new java.awt.Dimension(400, 300));
        jTable1.setRowHeight(50);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("ID");

        jLabel2.setText("ID du caftan");

        jLabel3.setText("ID du client");

        jLabel4.setText("Date de début");

        jLabel5.setText("Date de fin");

        id.setCaretColor(new java.awt.Color(142, 38, 57));
        id.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        id_caftan.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        id_client.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        ajouter.setBackground(new java.awt.Color(255, 255, 204));
        ajouter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ajouter.setBorder(null);
        ajouter.setLabel("Ajouter");

        date_start.setBackground(new java.awt.Color(255, 255, 255));

        date_end.setBackground(new java.awt.Color(255, 255, 255));

        update.setBackground(new java.awt.Color(153, 204, 255));
        update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        update.setText("Modifier");
        update.setBorder(null);

        delete.setBackground(new java.awt.Color(255, 102, 102));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete.setText("Supprimer");
        delete.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(date_start, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(id_caftan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_client, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(date_end, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(id_caftan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(id_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(date_start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(date_end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(delete)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(update)
                        .addGap(56, 56, 56))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ajouter, delete, update});

        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 128, 128));
        jLabel6.setText("Gestion des Réservations");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed


        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private com.toedter.calendar.JDateChooser date_end;
    private com.toedter.calendar.JDateChooser date_start;
    private javax.swing.JButton delete;
    private javax.swing.JTextField id;
    private javax.swing.JTextField id_caftan;
    private javax.swing.JTextField id_client;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}

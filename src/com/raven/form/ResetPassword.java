package com.raven.form;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class ResetPassword extends JFrame {

    private JTextField emailField;
    private JPasswordField newPasswordField;
    private JPasswordField confirmPasswordField;

    public ResetPassword() {
        super("Réinitialisation du mot de passe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 300);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 238, 238));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblEmail.setBounds(50, 50, 65, 20);
        contentPane.add(lblEmail);

        JLabel lblNewPassword = new JLabel("Nouveau mot de passe:");
        lblNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewPassword.setBounds(50, 100, 150, 20);
        contentPane.add(lblNewPassword);

        JLabel lblConfirmPassword = new JLabel("Confirmer le mot de passe:");
        lblConfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblConfirmPassword.setBounds(50, 150, 180, 20);
        contentPane.add(lblConfirmPassword);

        emailField = new JTextField();
        emailField.setBounds(250, 50, 200, 25);
        contentPane.add(emailField);
        emailField.setColumns(10);

        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(250, 100, 200, 25);
        contentPane.add(newPasswordField);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(250, 150, 200, 25);
        contentPane.add(confirmPasswordField);

        JButton resetButton = new JButton("Réinitialiser");
        resetButton.setForeground(Color.WHITE);
        resetButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        resetButton.setBackground(new Color(255, 128, 128));
        resetButton.setBounds(150, 200, 120, 30);
        contentPane.add(resetButton);

        JButton backButton = new JButton("Retour");
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        backButton.setBackground(new Color(255, 128, 128));
        backButton.setBounds(300, 200, 120, 30);
        contentPane.add(backButton);

        // ActionListener pour le bouton "Réinitialiser"
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String newPassword = new String(newPasswordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (newPassword.equals(confirmPassword)) {
                    // Mettre à jour le mot de passe dans la base de données
                    boolean updated = updatePassword(email, newPassword);
                    if (updated) {
                        JOptionPane.showMessageDialog(null, "Mot de passe mis à jour avec succès !");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erreur lors de la mise à jour du mot de passe !");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Les mots de passe ne correspondent pas !");
                }
            }
        });

        // ActionListener pour le bouton "Retour"
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre de réinitialisation du mot de passe
                dispose();
                // Afficher la page de connexion
                new connexion();
            }
        });

        setVisible(true);
    }

    // Méthode pour établir la connexion à la base de données
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/caftansshop?user=root&password=");
    }

    // Méthode pour mettre à jour le mot de passe dans la base de données
    private boolean updatePassword(String email, String newPassword) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE login SET Password = ? WHERE Email = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, newPassword);
                statement.setString(2, email);
                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ResetPassword();
            }
        });
    }
}


package Login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class connexion extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JPanel panel;
    private Connection connection;

    public connexion() {
        super("Connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 476);

        final JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 238, 238));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBackground(new Color(255, 238, 238));
        panel.setBounds(0, 0, 429, 439);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("");
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setIcon(new ImageIcon(connexion.class.getResource("/image/logo.png")));
        label.setBounds(0, 0, 440, 439);
        panel.add(label);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 238, 238));
        panel_1.setBounds(440, 0, 494, 439);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblEmail.setBounds(60, 100, 65, 20);
        panel_1.add(lblEmail);

        JLabel lblMotDePasse = new JLabel("Mot de passe:");
        lblMotDePasse.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblMotDePasse.setBounds(60, 150, 90, 20);
        panel_1.add(lblMotDePasse);

        emailField = new JTextField();
        emailField.setBounds(180, 100, 250, 25);
        panel_1.add(emailField);
        emailField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 150, 250, 25);
        panel_1.add(passwordField);

        JButton loginButton = new JButton("Connexion");
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        loginButton.setBackground(new Color(255, 128, 128));
        loginButton.setBounds(60, 210, 370, 42);
        panel_1.add(loginButton);

        JButton forgotPasswordButton = new JButton("Mot de passe oublié");
        forgotPasswordButton.setForeground(new Color(255, 255, 255));
        forgotPasswordButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        forgotPasswordButton.setBackground(new Color(255, 128, 128));
        forgotPasswordButton.setBounds(60, 270, 370, 42);
        panel_1.add(forgotPasswordButton);

        // Connexion à la base de données
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/caftansshop?user=root&password=");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(connexion.this, "Erreur de connexion à la base de données !");
            System.exit(1);
        }

        // ActionListener pour le bouton "Connexion"
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Vérifier les informations d'authentification dans la base de données
                boolean authenticated = authenticate(email, password);
                if (authenticated) {
                    JOptionPane.showMessageDialog(connexion.this, "Authentification réussie !");
                    // Redirigez l'utilisateur vers une autre page après l'authentification si nécessaire
                } else {
                    JOptionPane.showMessageDialog(connexion.this, "Email ou mot de passe incorrect !");
                }
            }
        });

        // ActionListener pour le bouton "Mot de passe oublié"
        forgotPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
                // Ouvrir la fenêtre de réinitialisation du mot de passe
                ResetPassword resetPasswordFrame = new ResetPassword();
            }
        });

        setVisible(true);
    }

    // Méthode pour authentifier l'utilisateur
    private boolean authenticate(String email, String password) {
        try {
            String query = "SELECT * FROM login WHERE Email=? AND Password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(connexion.this, "Erreur lors de l'authentification !");
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new connexion();
            }
        });
    }
}


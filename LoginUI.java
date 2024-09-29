import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;

public class LoginUI extends JFrame {

  
  private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
  private static final String DB_USER = "turf_rent";
  private static final String DB_PASSWORD = "turf_rent";
  private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";



    public LoginUI() {
        setTitle("DATA_BASE");
        setSize(600, 500);
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.gray);
        add(mainPanel);
        placeComponents(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

      
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);
        frame.setLayout(new BorderLayout());


        panel.setLayout(null);  
        panel.setBackground(new Color(230, 240, 255));  




        JLabel userLabel1 = new JLabel("DATABASE PROJECT");
        userLabel1.setFont(new Font("Arial", Font.BOLD, 14));
        userLabel1.setBounds(165, 50, 180, 25);
        panel.add(userLabel1);






        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userLabel.setBounds(80, 150, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(180, 150, 165, 25);
        panel.add(userText);

     
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setBounds(80, 200, 80, 25);
        panel.add(passwordLabel);

  
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(180, 200, 165, 25);
        panel.add(passwordText);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(155, 270, 165, 30);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(0, 120, 215));  // A blue button
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

               checkUserCredentials(username, password);
            }
        });

      
        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); 
    }
    

        private void checkUserCredentials(String username, String password) {
            String userQuery = "SELECT * FROM user_table WHERE user_name=? AND PASSWORD=?";
            try {
                Class.forName(DB_DRIVER);
                try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                     PreparedStatement statement = conn.prepareStatement(userQuery)) {

                    statement.setString(1, username);
                    statement.setString(2, password);

                    try (ResultSet result = statement.executeQuery()) {
                        if (result.next()) {
                            JOptionPane.showMessageDialog(null, "Login successful!");
                            // Code to start Start.java
                            new Start(); // Assuming Start is another JFrame or main class
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
      

    public static void main(String[] args) {
        new LoginUI();
    }

}
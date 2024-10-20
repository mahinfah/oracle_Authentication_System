import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Turf Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(620, 410);
       
JButton loginButton = new JButton("Login");
JButton registerButton = new JButton("Register");

registerButton.setFont(new Font("Arial", Font.PLAIN, 20));
registerButton.setBackground(Color.BLACK);
registerButton.setForeground(Color.gray);
registerButton.setBounds(340, 220, 200, 100);
registerButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                // Add action for register button here
                new Register();
                frame.dispose();
                new Register().setVisible(true);
               // System.out.println("Register button clicked");
        }
});

      loginButton.setFont(new Font("Arial", Font.PLAIN, 20));
      loginButton.setBackground(Color.BLACK);
      loginButton.setForeground(Color.gray);
      loginButton.setBounds(140, 100, 200, 100);
      loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
 
            new LoginUI();
            frame.dispose(); // Close the current frame
            }
        });

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Create a panel
        JPanel panel = new JPanel();
        panel.setOpaque(false); // Make the panel transparent
        panel.setLayout(new FlowLayout());
    
        // Add the login button to the panel
        panel.add(loginButton);

        // Add the register button to the panel
        panel.add(registerButton);

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("lol.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());

        // Add components to the background label
        backgroundLabel.add(panel, BorderLayout.CENTER);
        frame.setContentPane(backgroundLabel);

        frame.setVisible(true);
    }
}
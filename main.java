import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Oracle Authentication System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 410);
        // Create a login button
        JButton loginButton = new JButton("Login");
    
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // Open Start.java
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
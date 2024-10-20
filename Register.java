import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    private JTextField nameField;
    private JTextField nidField;
    private JTextField phoneField;
    private JPasswordField passField;
    private JButton registerButton;

    public Register() {
        setTitle("Register");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        JLabel titleLabel = new JLabel("DATABASE PROJECT");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(120, 20, 200, 25);
        panel.add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setBounds(50, 60, 80, 25);
        panel.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(150, 60, 200, 25);
        panel.add(nameField);

        JLabel nidLabel = new JLabel("NID:");
        nidLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nidLabel.setBounds(50, 100, 80, 25);
        panel.add(nidLabel);

        nidField = new JTextField(20);
        nidField.setBounds(150, 100, 200, 25);
        panel.add(nidField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 14));
        phoneLabel.setBounds(50, 140, 80, 25);
        panel.add(phoneLabel);

        phoneField = new JTextField(20);
        phoneField.setBounds(150, 140, 200, 25);
        panel.add(phoneField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passLabel.setBounds(50, 180, 80, 25);
        panel.add(passLabel);

        passField = new JPasswordField(20);
        passField.setBounds(150, 180, 200, 25);
        panel.add(passField);

        registerButton = new JButton("Register");
        registerButton.setBounds(150, 220, 100, 25);
        panel.add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle registration logic here
                String name = nameField.getText();
                String nid = nidField.getText();
                String phone = phoneField.getText();
                String password = new String(passField.getPassword());

                // For now, just print the values to the console
                System.out.println("Name: " + name);
                System.out.println("NID: " + nid);
                System.out.println("Phone: " + phone);
                System.out.println("Password: " + password);
            }
        });
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Register().setVisible(true);
            }
        });
    }
}
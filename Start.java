import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Start extends JFrame {
    private JTextField searchField;
    private JLabel labelTurfNameData;
    private JLabel labelCapacityData;
    private JLabel labelEmailData;
    private JLabel labelLocationData;
    private JLabel labelPhoneNumberData;
    private JLabel labelDurationData;
    private JLabel labelRentPriceData;
    private JLabel labelAdminNameData;

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DB_USER = "turf_rent";
    private static final String DB_PASSWORD = "turf_rent";
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";

    private static final String SQL_QUERY = "SELECT * FROM turf WHERE turf_name=?";

    public Start() {
        setTitle("Turf Search");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.gray);
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        setLocationRelativeTo(null);
         JLabel title = new JLabel("Turf Details");
        title.setBounds(230, 20, 150, 25);
        panel.add(title);


        JLabel searchLabel = new JLabel("Enter Turf Name:");
        searchLabel.setBounds(10, 50, 150, 25);
        panel.add(searchLabel);

        searchField = new JTextField(20);
        searchField.setBounds(160, 50, 165, 25);
        panel.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(380, 50, 150, 25);
        panel.add(searchButton);

        labelTurfNameData = new JLabel("Turf Name: ");
        labelTurfNameData.setBounds(10, 80, 300, 25);
        panel.add(labelTurfNameData);

        labelCapacityData = new JLabel("Capacity: ");
        labelCapacityData.setBounds(10, 110, 300, 25);
        panel.add(labelCapacityData);

        labelEmailData = new JLabel("Email: ");
        labelEmailData.setBounds(10, 140, 300, 25);
        panel.add(labelEmailData);

        labelLocationData = new JLabel("Location: ");
        labelLocationData.setBounds(10, 170, 300, 25);
        panel.add(labelLocationData);

        labelPhoneNumberData = new JLabel("Phone Number: ");
        labelPhoneNumberData.setBounds(10, 200, 300, 25);
        panel.add(labelPhoneNumberData);

        labelDurationData = new JLabel("Duration: ");
        labelDurationData.setBounds(10, 230, 300, 25);
        panel.add(labelDurationData);

        labelRentPriceData = new JLabel("Rent Price: ");
        labelRentPriceData.setBounds(10, 260, 300, 25);
        panel.add(labelRentPriceData);

        labelAdminNameData = new JLabel("Admin Name: ");
        labelAdminNameData.setBounds(10, 290, 300, 25);
        panel.add(labelAdminNameData);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText();
                if (searchText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a turf name");
                } else {
                    searchTurf(searchText);
                }
            }
        });
    }

    private void searchTurf(String searchText) {
        try {
      
            Class.forName(DB_DRIVER);

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement statement = conn.prepareStatement(SQL_QUERY)) {

    
                statement.setString(1, searchText);

                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                      
                        labelTurfNameData.setText("Turf Name: " + result.getString("turf_name"));
                        labelCapacityData.setText("Capacity: " + result.getInt("capacity"));
                        labelEmailData.setText("Email: " + result.getString("email"));
                        labelLocationData.setText("Location: " + result.getString("location"));
                        labelPhoneNumberData.setText("Phone Number: " + result.getLong("phone_number"));
                        labelDurationData.setText("Duration: " + result.getString("duration"));
                        labelRentPriceData.setText("Rent Price: " + result.getInt("rent_price"));
                        labelAdminNameData.setText("Admin Name: " + result.getString("admin_name"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Turf not found");
                    }
                }
            }
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "No turf available " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Start();
    }
}

package ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VolEquipementUI extends JFrame {
    private JTextField serialNumberField, brandField, modelField, ownerField;
    private JButton addButton, searchButton;
    private JTable equipmentTable;
    private DefaultTableModel tableModel;
    private Connection connection;

    public VolEquipementUI(Connection conn) {
        this.connection = conn;

        setTitle("Système de gestion des équipements volés");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Numéro de Série :"));
        serialNumberField = new JTextField();
        panel.add(serialNumberField);

        panel.add(new JLabel("Marque :"));
        brandField = new JTextField();
        panel.add(brandField);

        panel.add(new JLabel("Modèle :"));
        modelField = new JTextField();
        panel.add(modelField);

        panel.add(new JLabel("Propriétaire :"));
        ownerField = new JTextField();
        panel.add(ownerField);

        addButton = new JButton("Enregistrer");
        panel.add(addButton);

        searchButton = new JButton("Rechercher");
        panel.add(searchButton);

        tableModel = new DefaultTableModel(new String[] {"Numéro de Série", "Marque", "Modèle", "Propriétaire", "Statut"}, 0);
        equipmentTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(equipmentTable);
        
        add(panel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String serialNumber = serialNumberField.getText();
                String brand = brandField.getText();
                String model = modelField.getText();
                String owner = ownerField.getText();

                try {
                    String query = "INSERT INTO Equipement (serial_number, brand, model, owners, statut) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement stmt = connection.prepareStatement(query);
                    stmt.setString(1, serialNumber);
                    stmt.setString(2, brand);
                    stmt.setString(3, model);
                    stmt.setString(4, owner);
                    stmt.setString(5, "Non volé");
                    stmt.executeUpdate();
                    tableModel.addRow(new Object[]{serialNumber, brand, model, owner, "Non volé"});
                    serialNumberField.setText("");
                    brandField.setText("");
                    modelField.setText("");
                    ownerField.setText("");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String serialNumber = serialNumberField.getText();
                try {
                    String query = "SELECT * FROM Equipement WHERE serial_number = ?";
                    PreparedStatement stmt = connection.prepareStatement(query);
                    stmt.setString(1, serialNumber);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        String brand = rs.getString("brand");
                        String model = rs.getString("model");
                        String owner = rs.getString("owner");
                        String status = rs.getString("status");

                        tableModel.setRowCount(0); 
                        tableModel.addRow(new Object[]{serialNumber, brand, model, owner, status});
                    } else {
                        JOptionPane.showMessageDialog(null, "Aucun équipement trouvé avec ce numéro de série.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        setVisible(true);
    }
}

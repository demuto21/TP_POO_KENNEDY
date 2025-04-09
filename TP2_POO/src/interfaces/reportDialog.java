package interfaces;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

import ui.RepertoireEquipements;

public class reportDialog extends JDialog {
    public reportDialog(RepertoireEquipements repertoire, DefaultTableModel tableModel) {
        setTitle("Signaler un équipement volé");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setModal(true);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        JTextField codeField = new JTextField();
        JTextField nomObjetField = new JTextField();
        JButton signalerBtn = new JButton("Signaler");

        panel.add(new JLabel("Code de l'équipement :"));
        panel.add(codeField);
        panel.add(new JLabel("Nom de l'équipement :"));
        panel.add(nomObjetField);
        panel.add(new JLabel());
        panel.add(signalerBtn);

        add(panel);

        signalerBtn.addActionListener(e -> {
            String code = codeField.getText().trim();
            String nom = nomObjetField.getText().trim();

            if (code.isEmpty() || nom.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tous les champs sont requis.");
                return;
            }

            JOptionPane.showMessageDialog(this, "Équipement signalé avec succès !");
            dispose();
        });

        setVisible(true);
    }
}

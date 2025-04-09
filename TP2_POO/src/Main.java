import ui.VolEquipementUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/EquipementDB", "root", "TonMotDePasseIci");
            new VolEquipementUI(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
package dao;

import model.Equipement;
import model.Telephone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipementDAO {

    private Connection conn;

    public EquipementDAO(Connection conn) {
        this.conn = conn;
    }

    public void ajouterEquipement(Equipement e) {
        String sql = "INSERT INTO equipement_voles (type_equiment, marque, modele, numero_serie, date_vol, lieu_vol, proprietaire_nom, proprietaire_contact, statut) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.gettype_equiment());
            stmt.setString(2, e.getMarque());
            stmt.setString(3, e.getModele());
            stmt.setString(4, e.getNumeroSerie());
            stmt.setDate(5, new java.sql.Date(e.getDateVol().getTime()));
            stmt.setString(6, e.getLieuVol());
            stmt.setString(7, e.getProprietaireNom());
            stmt.setString(8, e.getProprietaireContact());
            stmt.setString(9, e.getStatut());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Equipement rechercherParNumeroSerie(String numeroSerie) {
        String sql = "SELECT * FROM equipement_voles WHERE numero_serie = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, numeroSerie);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Telephone(
                        rs.getString("marque"),
                        rs.getString("modele"),
                        rs.getString("numero_serie"),
                        rs.getDate("date_vol"),
                        rs.getString("lieu_vol"),
                        rs.getString("proprietaire_nom"),
                        rs.getString("proprietaire_contact"),
                        rs.getString("statut")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Equipement> listerEquipements() {
        List<Equipement> equipements = new ArrayList<>();
        String sql = "SELECT * FROM equipement_voles";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Equipement e = new Telephone(
                        rs.getString("marque"),
                        rs.getString("modele"),
                        rs.getString("numero_serie"),
                        rs.getDate("date_vol"),
                        rs.getString("lieu_vol"),
                        rs.getString("proprietaire_nom"),
                        rs.getString("proprietaire_contact"),
                        rs.getString("statut")
                );
                equipements.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return equipements;
    }
}

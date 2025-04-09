package model;

import java.util.Date;

public class Telephone extends Equipement {
    public Telephone(String marque, String modele, String numeroSerie, Date dateVol,
                     String lieuVol, String proprietaireNom, String proprietaireContact, String statut) {
        super("Téléphone", marque, modele, numeroSerie, dateVol, lieuVol, proprietaireNom, proprietaireContact, statut);
    }
}

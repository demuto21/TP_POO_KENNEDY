package model;

import java.util.Date;

public abstract class Equipement {
    protected int id;
    protected String type_equiment;
    protected String marque;
    protected String modele;
    protected String numeroSerie;
    protected Date dateVol;
    protected String lieuVol;
    protected String proprietaireNom;
    protected String proprietaireContact;
    protected String statut;

    public Equipement(String type_equiment, String marque, String modele, String numeroSerie, Date dateVol,
            String lieuVol, String proprietaireNom, String proprietaireContact, String statut) {
        this.type_equiment = type_equiment;
        this.marque = marque;
        this.modele = modele;
        this.numeroSerie = numeroSerie;
        this.dateVol = dateVol;
        this.lieuVol = lieuVol;
        this.proprietaireNom = proprietaireNom;
        this.proprietaireContact = proprietaireContact;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gettype_equiment() {
        return type_equiment;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public Date getDateVol() {
        return dateVol;
    }

    public String getLieuVol() {
        return lieuVol;
    }

    public String getProprietaireNom() {
        return proprietaireNom;
    }

    public String getProprietaireContact() {
        return proprietaireContact;
    }

    public String getStatut() {
        return statut;
    }

    public void settype_equiment(String type_equiment) {
        this.type_equiment = type_equiment;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public void setDateVol(Date dateVol) {
        this.dateVol = dateVol;
    }

    public void setLieuVol(String lieuVol) {
        this.lieuVol = lieuVol;
    }

    public void setProprietaireNom(String proprietaireNom) {
        this.proprietaireNom = proprietaireNom;
    }

    public void setProprietaireContact(String proprietaireContact) {
        this.proprietaireContact = proprietaireContact;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}

class Utilisateur {
    private String nom;
    private String email;
    private String telephone;

    public Utilisateur(String nom, String email, String telephone) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

class DeclarationVol {
    private Equipement equipement;
    private Utilisateur proprietaire;
    private Date dateDeclaration;

    public DeclarationVol(Equipement equipement, Utilisateur proprietaire, Date dateDeclaration) {
        this.equipement = equipement;
        this.proprietaire = proprietaire;
        this.dateDeclaration = dateDeclaration;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Date getDateDeclaration() {
        return dateDeclaration;
    }

    public void setDateDeclaration(Date dateDeclaration) {
        this.dateDeclaration = dateDeclaration;
    }
}

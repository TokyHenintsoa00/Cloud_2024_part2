package com.example.cloud_project.Models;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ParcelleModel {

    int id_parcelle;
    double dimension;
    int nb_pieds;
    Double prix;
    int id_tp;
    int id_utilisateur;
    String nom;
    double stat_parcelle;
    int id_terrain;
    int id_categorie;
    String nom_categorie;
    int id_type;
    String nom_type;
    int rendement_par_pieds;
    Double prix_unitaire;
    double prix_parcelle;
    
    public double getPrix_parcelle() {
        return prix_parcelle;
    }

    public void setPrix_parcelle(double prix_parcelle) {
        this.prix_parcelle = prix_parcelle;
    }

    public Double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public int getRendement_par_pieds() {
        return rendement_par_pieds;
    }
    public void setRendement_par_pieds(int rendement_par_pieds) {
        this.rendement_par_pieds = rendement_par_pieds;
    }

    public String getNom_type() {
        return nom_type;
    }
    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }

    public int getId_type() {
        return id_type;
    }
    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }
    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }
    
   public double getStat_parcelle() {
       return stat_parcelle;
   }
   public void setStat_parcelle(double stat_parcelle) {
       this.stat_parcelle = stat_parcelle;
   }

   public int getId_categorie() {
       return id_categorie;
   }
   public void setId_categorie(int id_categorie) {
       this.id_categorie = id_categorie;
   }

    public int getId_parcelle() {
        return id_parcelle;
    }
    public void setId_parcelle(int id_parcelle) {
        this.id_parcelle = id_parcelle;
    }
    public double getDimension() {
        return dimension;
    }
    public void setDimension(double dimension) {
        this.dimension = dimension;
    }
    public Double getPrix() {
        return prix;
    }
    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public int getNb_pieds() {
        return nb_pieds;
    }
    public void setNb_pieds(int nb_pieds) {
        this.nb_pieds = nb_pieds;
    }
    public int getId_tp() {
        return id_tp;
    }
    public void setId_tp(int id_tp) {
        this.id_tp = id_tp;
    }
    public int getId_utilisateur() {
        return id_utilisateur;
    }
    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getId_terrain() {
        return id_terrain;
    }
    public void setId_terrain(int id_terrain) {
        this.id_terrain = id_terrain;
    }

    public ParcelleModel(int id_parcelle, double dimension, int nb_pieds, Double prix) {
        this.id_parcelle = id_parcelle;
        this.dimension = dimension;
        this.nb_pieds = nb_pieds;
        this.prix = prix;
       
    }

    public ParcelleModel(int id_parcelle, double dimension, int nb_pieds, int id_tp, int id_utilisateur, String nom,
    int id_terrain) {
    this.id_parcelle = id_parcelle;
    this.dimension = dimension;
    this.nb_pieds = nb_pieds;
    this.id_tp = id_tp;
    this.id_utilisateur = id_utilisateur;
    this.nom = nom;
    this.id_terrain = id_terrain;
}


    public ParcelleModel(double stat_parcelle, int id_terrain) {
        this.stat_parcelle = stat_parcelle;
        this.id_terrain = id_terrain;
    }


    public ParcelleModel() {
    }

    public ParcelleModel[] select_parcelle()
    {
        List<ParcelleModel> resultatList = new ArrayList<>();

        try 
        {
            Conn c = new Conn();
            Connection conn = c.getConnex();
            
                Statement stmnt = conn.createStatement();
                ResultSet result = stmnt.executeQuery("select * from parcelle");

                while (result.next()) 
                {
                    int id_parcelle = result.getInt(1);
                    Double dimension = result.getDouble(2);
                    int nb_pieds = result.getInt(3);
                    Double prix = result.getDouble(4);
                    
                    ParcelleModel p = new ParcelleModel(id_parcelle,dimension,nb_pieds,prix);
                    resultatList.add(p);
                }

                result.close();
                conn.close();
            
        } 
        catch (Exception e) 
        {
            // TODO: handle exception
            e.printStackTrace();
        }

        return resultatList.toArray(new ParcelleModel[resultatList.size()]);
    }

    public ParcelleModel[] stat_parcelle()
    {
        List<ParcelleModel> resultatList = new ArrayList<>();

        try 
        {
            Conn c = new Conn();
            Connection conn = c.getConnex();
            
                Statement stmnt = conn.createStatement();
                ResultSet result = stmnt.executeQuery("select * from stat_parcelle");

                while (result.next()) 
                {
                    double stat_parcelle = result.getDouble(1);
                    int id_terrain = result.getInt(2);
                    
                    ParcelleModel p = new ParcelleModel(stat_parcelle,id_terrain);
                    resultatList.add(p);
                }

                result.close();
                conn.close();
            
        } 
        catch (Exception e) 
        {
            // TODO: handle exception
            e.printStackTrace();
        }

        return resultatList.toArray(new ParcelleModel[resultatList.size()]);
    }



    
    public void insert_parcelle(Double dimension , int nb_pieds , Double prix)
    {
        try 
        {
            Conn c = new Conn();
            Connection conn = c.getConnex();
            
            
                PreparedStatement pstmt = conn.prepareStatement("insert into parcelle(dimension,nb_pieds,prix)values(?,?,?)");
                // pstmt.setInt(1, wallet);
                // pstmt.setInt(2, wallet);
                pstmt.setDouble(1, dimension);
                pstmt.setInt(2, nb_pieds);
                pstmt.setDouble(3, prix);
                
                pstmt.executeUpdate();
                conn.close();
                System.out.println("insert parcelle sucessfully");
            
            
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    
}

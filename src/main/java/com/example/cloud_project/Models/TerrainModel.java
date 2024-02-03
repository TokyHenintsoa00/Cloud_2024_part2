package com.example.cloud_project.Models;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TerrainModel {
    
    

    int id_terrain;
    String description;
    String latitude;
    String longitude;
    String photo;
    int id_type;
    int id_parcelle;
    int id_categorie;
    double dimension;
    int nb_pieds;
    Double prix;
    int id_tp;
    int id_utilisateur;
    String nom;
    double stat_parcelle;
    String nom_categorie;
    String nom_type;
    int rendement_par_pieds;
    Double prix_unitaire;
    double prix_parcelle;
    Timestamp date;
    String date_format;
    int id_user_demande;
    String nom_user_demande;
    String img;

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }

    public String getNom_user_demande() {
        return nom_user_demande;
    }
    public void setNom_user_demande(String nom_user_demande) {
        this.nom_user_demande = nom_user_demande;
    }

    public int getId_user_demande() {
        return id_user_demande;
    }

    public void setId_user_demande(int id_user_demande) {
        this.id_user_demande = id_user_demande;
    }


    public String getDate_format() {
        return date_format;
    }

    public void setDate_format(String date_format) {
        this.date_format = date_format;
    }


    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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

    public int getId_terrain() {
        return this.id_terrain;
    }

    public void setId_terrain(int id_terrain) {
        this.id_terrain = id_terrain;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }
    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getId_type() {
        return id_type;
    }
    public void setId_type(int id_type) {
        this.id_type = id_type;
    }


    public double getDimension() {
        return dimension;
    }
    public void setDimension(double dimension) {
        this.dimension = dimension;
    }
    public int getNb_pieds() {
        return nb_pieds;
    }
    public void setNb_pieds(int nb_pieds) {
        this.nb_pieds = nb_pieds;
    }
    public Double getPrix() {
        return prix;
    }
    public void setPrix(Double prix) {
        this.prix = prix;
    }
    public int getId_tp() {
        return id_tp;
    }
    public void setId_tp(int id_tp) {
        this.id_tp = id_tp;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getStat_parcelle() {
        return stat_parcelle;
    }
    public void setStat_parcelle(double stat_parcelle) {
        this.stat_parcelle = stat_parcelle;
    }
    public String getNom_categorie() {
        return nom_categorie;
    }
    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }
    public String getNom_type() {
        return nom_type;
    }
    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }
    public int getRendement_par_pieds() {
        return rendement_par_pieds;
    }
    public void setRendement_par_pieds(int rendement_par_pieds) {
        this.rendement_par_pieds = rendement_par_pieds;
    }
    public Double getPrix_unitaire() {
        return prix_unitaire;
    }
    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }
    public double getPrix_parcelle() {
        return prix_parcelle;
    }
    public void setPrix_parcelle(double prix_parcelle) {
        this.prix_parcelle = prix_parcelle;
    }

    public TerrainModel(int id_terrain, String description, String latitude, String longitude, String photo) {
        this.id_terrain = id_terrain;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.photo = photo;
    }

    public TerrainModel(int id_tp,int id_utilisateur, String nom,int id_parcelle,int id_terrain,
            int id_categorie,String nom_categorie,
            int id_type, String nom_type, int rendement_par_pieds, Double prix_unitaire,
            double dimension, int nb_pieds,  
            double prix_parcelle,String date_format) {
        this.id_tp = id_tp;
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.id_parcelle = id_parcelle;
        this.id_terrain = id_terrain;
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.id_type = id_type;
        this.nom_type = nom_type;
        this.rendement_par_pieds = rendement_par_pieds;
        this.prix_unitaire = prix_unitaire;
        this.dimension = dimension;
        this.nb_pieds = nb_pieds;
        this.prix_parcelle = prix_parcelle;
        this.date_format = date_format;
    }

    
    public TerrainModel() {

    }
    
    public TerrainModel[] select_terrain()
    {
        List<TerrainModel> lists = new ArrayList<>();

        try 
        {
            Conn c = new Conn();
            Connection conn = c.getConnex();

            
                Statement stmnt = conn.createStatement();
                ResultSet result = stmnt.executeQuery("select * from terrain");

                while (result.next()) 
                {
                    int id_terrain = result.getInt(1);
                    String description = result.getString(2);
                    String latitude = result.getString(3);
                    String longitude = result.getString(4);
                    String photo= result.getString(5);
                    TerrainModel t = new TerrainModel(id_terrain,description,latitude, longitude, photo);
                    lists.add(t);
                }

                result.close();
                conn.close();
            
        } 
        catch (Exception e) 
        {
            // TODO: handle exception
            e.printStackTrace();
        }

        return lists.toArray(new TerrainModel[lists.size()]);
    }



    



    public TerrainModel[] v_information_parcelle_par_terrain_par_utilisateur(int id_utilisateur)
    {
        List<TerrainModel> resultatList = new ArrayList<>();
        
         try{
                 
                    Conn c = new Conn();
                    Connection conn = c.getConnex();
                        
                    String sql = "select * from v_information_parcelle_par_terrain where id_utilisateur="+id_utilisateur+"";
                    System.out.println(sql);
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                   
                    ResultSet result = pstmt.executeQuery();
                    while (result.next()) 
                    {
                        
                        int id_tp = result.getInt(1);
                        int id_user = result.getInt(2);
                        String nom = result.getString(3);
                        int id_parcelle = result.getInt(4);
                        int id_terrain = result.getInt(5);
                        int id_categorie = result.getInt(6);
                        String nom_categorie = result.getString(7);
                        int id_type = result.getInt(8);
                        String nom_tpye = result.getString(9);
                        int rendement_par_pieds = result.getInt(10);
                        double prix_unitaire = result.getDouble(11);
                        double dimension = result.getDouble(12);
                        int nb_pieds = result.getInt(13);
                        double prix_parcelle = result.getDouble(14);

                        TerrainModel parcelle = new TerrainModel();
                        parcelle.setId_tp(id_tp);
                        parcelle.setId_utilisateur(id_user);
                        parcelle.setNom(nom);
                        parcelle.setId_parcelle(id_parcelle);
                        parcelle.setId_terrain(id_terrain);
                        parcelle.setId_categorie(id_categorie);
                        parcelle.setNom_categorie(nom_categorie);
                        parcelle.setId_type(id_type);
                        parcelle.setNom_type(nom_tpye);
                        parcelle.setRendement_par_pieds(rendement_par_pieds);
                        parcelle.setPrix_unitaire(prix_unitaire);
                        parcelle.setDimension(dimension);
                        parcelle.setNb_pieds(nb_pieds);
                        parcelle.setPrix_parcelle(prix_parcelle);

                        resultatList.add(parcelle);
                    }

                    result.close();
                    pstmt.close();
                    conn.close();
                
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        return resultatList.toArray(new TerrainModel[resultatList.size()]);
    }

    public TerrainModel[] v_information_parcelle_par_terrain()
    {
        List<TerrainModel> resultatList = new ArrayList<>();
        
         try{
                 
                    Conn c = new Conn();
                    Connection conn = c.getConnex();
                        
                    String sql = "select * from v_information_parcelle_par_terrain";
                    System.out.println(sql);
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                   
                    ResultSet result = pstmt.executeQuery();
                    while (result.next()) 
                    {
                        
                        int id_tp = result.getInt(1);
                        int id_user = result.getInt(2);
                        String nom = result.getString(3);
                        int id_parcelle = result.getInt(4);
                        int id_terrain = result.getInt(5);
                        int id_categorie = result.getInt(6);
                        String nom_categorie = result.getString(7);
                        int id_type = result.getInt(8);
                        String nom_tpye = result.getString(9);
                        int rendement_par_pieds = result.getInt(10);
                        double prix_unitaire = result.getDouble(11);
                        double dimension = result.getDouble(12);
                        int nb_pieds = result.getInt(13);
                        double prix_parcelle = result.getDouble(14);

                        TerrainModel parcelle = new TerrainModel();
                        parcelle.setId_tp(id_tp);
                        parcelle.setId_utilisateur(id_user);
                        parcelle.setNom(nom);
                        parcelle.setId_parcelle(id_parcelle);
                        parcelle.setId_terrain(id_terrain);
                        parcelle.setId_categorie(id_categorie);
                        parcelle.setNom_categorie(nom_categorie);
                        parcelle.setId_type(id_type);
                        parcelle.setNom_type(nom_tpye);
                        parcelle.setRendement_par_pieds(rendement_par_pieds);
                        parcelle.setPrix_unitaire(prix_unitaire);
                        parcelle.setDimension(dimension);
                        parcelle.setNb_pieds(nb_pieds);
                        parcelle.setPrix_parcelle(prix_parcelle);

                        resultatList.add(parcelle);
                    }

                    result.close();
                    pstmt.close();
                    conn.close();
                
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        return resultatList.toArray(new TerrainModel[resultatList.size()]);
    }

    public TerrainModel[] v_information_parcelle_par_terrain_par_parcelle(int id_parcelle)
    {
        List<TerrainModel> resultatList = new ArrayList<>();
        
         try{
                 
                    Conn c = new Conn();
                    Connection conn = c.getConnex();
                        
                    String sql = "select * from v_information_parcelle_par_terrain where id_parcelle="+id_parcelle+"";
                    System.out.println(sql);
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                   
                    ResultSet result = pstmt.executeQuery();
                    while (result.next()) 
                    {
                        
                        int id_tp = result.getInt(1);
                        int id_user = result.getInt(2);
                        String nom = result.getString(3);
                        int id_parcelles = result.getInt(4);
                        int id_terrain = result.getInt(5);
                        int id_categorie = result.getInt(6);
                        String nom_categorie = result.getString(7);
                        int id_type = result.getInt(8);
                        String nom_tpye = result.getString(9);
                        int rendement_par_pieds = result.getInt(10);
                        double prix_unitaire = result.getDouble(11);
                        double dimension = result.getDouble(12);
                        int nb_pieds = result.getInt(13);
                        double prix_parcelle = result.getDouble(14);

                        TerrainModel parcelle = new TerrainModel();
                        parcelle.setId_tp(id_tp);
                        parcelle.setId_utilisateur(id_user);
                        parcelle.setNom(nom);
                        parcelle.setId_parcelle(id_parcelles);
                        parcelle.setId_terrain(id_terrain);
                        parcelle.setId_categorie(id_categorie);
                        parcelle.setNom_categorie(nom_categorie);
                        parcelle.setId_type(id_type);
                        parcelle.setNom_type(nom_tpye);
                        parcelle.setRendement_par_pieds(rendement_par_pieds);
                        parcelle.setPrix_unitaire(prix_unitaire);
                        parcelle.setDimension(dimension);
                        parcelle.setNb_pieds(nb_pieds);
                        parcelle.setPrix_parcelle(prix_parcelle);

                        resultatList.add(parcelle);
                    }

                    result.close();
                    pstmt.close();
                    conn.close();
                
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        return resultatList.toArray(new TerrainModel[resultatList.size()]);
    }

    public TerrainModel[] v_information_parcelle_par_terrain_par_categorie(int id_categorie)
    {
        List<TerrainModel> resultatList = new ArrayList<>();
        
         try{
                 
                    Conn c = new Conn();
                    Connection conn = c.getConnex();
                        
                    String sql = "select * from v_information_parcelle_par_terrain where id_categorie="+id_categorie+"";
                    System.out.println(sql);
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                   
                    ResultSet result = pstmt.executeQuery();
                    while (result.next()) 
                    {
                        
                        int id_tp = result.getInt(1);
                        int id_user = result.getInt(2);
                        String nom = result.getString(3);
                        int id_parcelle = result.getInt(4);
                        int id_terrain = result.getInt(5);
                        int id_categories = result.getInt(6);
                        String nom_categorie = result.getString(7);
                        int id_type = result.getInt(8);
                        String nom_tpye = result.getString(9);
                        int rendement_par_pieds = result.getInt(10);
                        double prix_unitaire = result.getDouble(11);
                        double dimension = result.getDouble(12);
                        int nb_pieds = result.getInt(13);
                        double prix_parcelle = result.getDouble(14);

                        TerrainModel parcelle = new TerrainModel();
                        parcelle.setId_tp(id_tp);
                        parcelle.setId_utilisateur(id_user);
                        parcelle.setNom(nom);
                        parcelle.setId_parcelle(id_parcelle);
                        parcelle.setId_terrain(id_terrain);
                        parcelle.setId_categorie(id_categories);
                        parcelle.setNom_categorie(nom_categorie);
                        parcelle.setId_type(id_type);
                        parcelle.setNom_type(nom_tpye);
                        parcelle.setRendement_par_pieds(rendement_par_pieds);
                        parcelle.setPrix_unitaire(prix_unitaire);
                        parcelle.setDimension(dimension);
                        parcelle.setNb_pieds(nb_pieds);
                        parcelle.setPrix_parcelle(prix_parcelle);

                        resultatList.add(parcelle);
                    }

                    result.close();
                    pstmt.close();
                    conn.close();
                
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        return resultatList.toArray(new TerrainModel[resultatList.size()]);
    }

    public TerrainModel[] v_information_parcelle_par_terrain_par_nom(String nom)
    {
        List<TerrainModel> resultatList = new ArrayList<>();
        
         try{
                 
                    Conn c = new Conn();
                    Connection conn = c.getConnex();
                        
                    String sql = "SELECT * FROM v_information_parcelle_par_terrain WHERE nom LIKE ?";                    System.out.println(sql);
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, "%" + nom + "%");
                    
                    ResultSet result = pstmt.executeQuery();
                  
                    while (result.next()) 
                    {
                        
                        int id_tp = result.getInt(1);
                        int id_user = result.getInt(2);
                        String noms = result.getString(3);
                        int id_parcelle = result.getInt(4);
                        int id_terrain = result.getInt(5);
                        int id_categories = result.getInt(6);
                        String nom_categorie = result.getString(7);
                        int id_type = result.getInt(8);
                        String nom_tpye = result.getString(9);
                        int rendement_par_pieds = result.getInt(10);
                        double prix_unitaire = result.getDouble(11);
                        double dimension = result.getDouble(12);
                        int nb_pieds = result.getInt(13);
                        double prix_parcelle = result.getDouble(14);

                        TerrainModel parcelle = new TerrainModel();
                        parcelle.setId_tp(id_tp);
                        parcelle.setId_utilisateur(id_user);
                        parcelle.setNom(noms);
                        parcelle.setId_parcelle(id_parcelle);
                        parcelle.setId_terrain(id_terrain);
                        parcelle.setId_categorie(id_categories);
                        parcelle.setNom_categorie(nom_categorie);
                        parcelle.setId_type(id_type);
                        parcelle.setNom_type(nom_tpye);
                        parcelle.setRendement_par_pieds(rendement_par_pieds);
                        parcelle.setPrix_unitaire(prix_unitaire);
                        parcelle.setDimension(dimension);
                        parcelle.setNb_pieds(nb_pieds);
                        parcelle.setPrix_parcelle(prix_parcelle);

                        resultatList.add(parcelle);
                    }

                    result.close();
                    pstmt.close();
                    conn.close();
                
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        return resultatList.toArray(new TerrainModel[resultatList.size()]);
    }

    public TerrainModel[] v_information_parcelle_par_terrain_par_type(int id_type)
    {
        List<TerrainModel> resultatList = new ArrayList<>();
        
         try{
                 
                    Conn c = new Conn();
                    Connection conn = c.getConnex();
                        
                    String sql = "select * from v_information_parcelle_par_terrain where id_type="+id_type+"";
                    System.out.println(sql);
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                   
                    ResultSet result = pstmt.executeQuery();
                    while (result.next()) 
                    {
                        
                        int id_tp = result.getInt(1);
                        int id_user = result.getInt(2);
                        String nom = result.getString(3);
                        int id_parcelle = result.getInt(4);
                        int id_terrain = result.getInt(5);
                        int id_categories = result.getInt(6);
                        String nom_categorie = result.getString(7);
                        int id_types = result.getInt(8);
                        String nom_tpye = result.getString(9);
                        int rendement_par_pieds = result.getInt(10);
                        double prix_unitaire = result.getDouble(11);
                        double dimension = result.getDouble(12);
                        int nb_pieds = result.getInt(13);
                        double prix_parcelle = result.getDouble(14);

                        TerrainModel parcelle = new TerrainModel();
                        parcelle.setId_tp(id_tp);
                        parcelle.setId_utilisateur(id_user);
                        parcelle.setNom(nom);
                        parcelle.setId_parcelle(id_parcelle);
                        parcelle.setId_terrain(id_terrain);
                        parcelle.setId_categorie(id_categories);
                        parcelle.setNom_categorie(nom_categorie);
                        parcelle.setId_type(id_types);
                        parcelle.setNom_type(nom_tpye);
                        parcelle.setRendement_par_pieds(rendement_par_pieds);
                        parcelle.setPrix_unitaire(prix_unitaire);
                        parcelle.setDimension(dimension);
                        parcelle.setNb_pieds(nb_pieds);
                        parcelle.setPrix_parcelle(prix_parcelle);

                        resultatList.add(parcelle);
                    }

                    result.close();
                    pstmt.close();
                    conn.close();
                
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        return resultatList.toArray(new TerrainModel[resultatList.size()]);
    }


    public void insert_terrain(String description, String latitude, String longitude, String photo) {
        try {
                Conn c = new Conn();
                Connection conn = c.getConnex();

            
                String query = "INSERT INTO terrain (description, latitude, longitude, photo) VALUES (?, ?,  ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                    preparedStatement.setString(1, description);
                    preparedStatement.setString(2, latitude);
                    preparedStatement.setString(3, longitude);
                    preparedStatement.setString(4, photo);
                    
                    preparedStatement.executeUpdate();
                    System.out.println("insert terrain successfully");
                    conn.close();
                }
                conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
       
    }

    public void insert_parcelle_terrain(int id_utilisateur ,int id_parcelle , int id_terrain , int id_categorie , int id_type)
    {
        try 
        {
            Conn c = new Conn();
            Connection conn = c.getConnex();
            
            
                PreparedStatement pstmt = conn.prepareStatement("insert into parcelle_par_terrain(id_utilisateur,id_parcelle,id_terrain,id_categorie,id_type)values(?,?,?,?,?)");
                pstmt.setInt(1, id_utilisateur);
                pstmt.setInt(2, id_parcelle);
                pstmt.setInt(3, id_terrain);
                pstmt.setInt(4, id_categorie);
                pstmt.setInt(5,id_type);
                pstmt.executeUpdate();
                System.out.println("insert parcelle_terrain sucessfully");
                conn.close();
            
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }



    public void validation_terrain_admin(int id_utilisateur ,int id_parcelle , int id_terrain , int id_categorie , int id_type)
    {
        try 
        {
            Conn c = new Conn();
            Connection conn = c.getConnex();
            
            
                PreparedStatement pstmt = conn.prepareStatement("insert into validation_admin_terrain(id_utilisateur,id_parcelle,id_terrain,id_categorie,id_type,date)values(?,?,?,?,?,CURRENT_TIMESTAMP)");
                pstmt.setInt(1, id_utilisateur);
                pstmt.setInt(2, id_parcelle);
                pstmt.setInt(3, id_terrain);
                pstmt.setInt(4, id_categorie);
                pstmt.setInt(5,id_type);
                pstmt.executeUpdate();
                System.out.println("insert validation sucessfully");
                conn.close();
            
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public TerrainModel[] select_validation_admin()
    {
        List<TerrainModel> lists = new ArrayList<>();

        try 
        {
            Conn c = new Conn();
            Connection conn = c.getConnex();

            
                Statement stmnt = conn.createStatement();
                ResultSet result = stmnt.executeQuery("select * from v_validation_admin_terrain");

                while (result.next()) 
                {
                    int id_tp = result.getInt(1);
                    int id_user = result.getInt(2);
                    String nom = result.getString(3);
                    int id_parcelle = result.getInt(4);
                    int id_terrain = result.getInt(5);
                    int id_categorie = result.getInt(6);
                    String nom_categorie = result.getString(7);
                    int id_type = result.getInt(8);
                    String nom_tpye = result.getString(9);
                    int rendement_par_pieds = result.getInt(10);
                    double prix_unitaire = result.getDouble(11);
                    double dimension = result.getDouble(12);
                    int nb_pieds = result.getInt(13);
                    double prix_parcelle = result.getDouble(14);
                    Timestamp date = result.getTimestamp(15);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String formattedDate = dateFormat.format(date);
                    TerrainModel t = new TerrainModel(id_tp,id_user,nom,id_parcelle,id_terrain,id_categorie,nom_categorie,id_type,nom_tpye,rendement_par_pieds,prix_unitaire,dimension,nb_pieds,prix_parcelle,formattedDate);
                    lists.add(t);
                }

                result.close();
                conn.close();
            
        } 
        catch (Exception e) 
        {
            // TODO: handle exception
            e.printStackTrace();
        }

        return lists.toArray(new TerrainModel[lists.size()]);
    }




    public TerrainModel[] suggestion_terrain(int id_utilisateur) {
        List<TerrainModel> resultatList = new ArrayList<>();
        
        try {
            
            Conn c = new Conn();
            Connection conn = c.getConnex();
           
            String sql = "SELECT * FROM v_information_Parcelle_par_terrain WHERE id_utilisateur <> ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
        
            pstmt.setInt(1, id_utilisateur);
         
        
            ResultSet result = pstmt.executeQuery();
        
            while (result.next()) {
                int id_tp = result.getInt(1);
                int id_user = result.getInt(2);
                String nom = result.getString(3);
                int id_parcelle = result.getInt(4);
                int id_terrain = result.getInt(5);
                int id_categorie = result.getInt(6);
                String nom_categorie = result.getString(7);
                int id_type = result.getInt(8);
                String nom_tpye = result.getString(9);
                int rendement_par_pieds = result.getInt(10);
                double prix_unitaire = result.getDouble(11);
                double dimension = result.getDouble(12);
                int nb_pieds = result.getInt(13);
                double prix_parcelle = result.getDouble(14);
                Timestamp date = result.getTimestamp(15);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = dateFormat.format(date);

                TerrainModel terrain = new TerrainModel();
                terrain.setId_tp(id_tp);
                terrain.setId_utilisateur(id_user);
                terrain.setNom(nom);
                terrain.setId_parcelle(id_parcelle);
                terrain.setId_terrain(id_terrain);
                terrain.setId_categorie(id_categorie);
                terrain.setNom_categorie(nom_categorie);
                terrain.setId_type(id_type);
                terrain.setNom_type(nom_tpye);
                terrain.setRendement_par_pieds(rendement_par_pieds);
                terrain.setPrix_unitaire(prix_unitaire);
                terrain.setDimension(dimension);
                terrain.setNb_pieds(nb_pieds);
                terrain.setPrix_parcelle(prix_parcelle);
                terrain.setDate_format(formattedDate);

                resultatList.add(terrain);
            }

            result.close();
            pstmt.close();
            conn.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resultatList.toArray(new TerrainModel[resultatList.size()]);
    }


    public void demande_terrain(int id_utilisateur ,int id_utilisateur_demande,int id_parcelle , int id_terrain , int id_categorie , int id_type)
    {
        try 
        {
            Conn c = new Conn();
            Connection conn = c.getConnex();
            
            
                PreparedStatement pstmt = conn.prepareStatement("insert into demande_terrain(id_utilisateur,id_utilisateur_demande,id_parcelle,id_terrain,id_categorie,id_type,date)values(?,?,?,?,?,?,CURRENT_TIMESTAMP)");
                pstmt.setInt(1, id_utilisateur);
                pstmt.setInt(2, id_utilisateur_demande);
                pstmt.setInt(3, id_parcelle);
                pstmt.setInt(4, id_terrain);
                pstmt.setInt(5, id_categorie);
                pstmt.setInt(6,id_type);
                pstmt.executeUpdate();
                System.out.println("demande sucessfully");
                conn.close();
            
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    } 



    public TerrainModel[] v_demande_terrain(int id_utilisateur) {
        List<TerrainModel> resultatList = new ArrayList<>();
        
        try {
            
            Conn c = new Conn();
            Connection conn = c.getConnex();
           
            String sql = "SELECT * FROM v_demande_terrain WHERE id_utilisateur = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
        
            pstmt.setInt(1, id_utilisateur);
         
        
            ResultSet result = pstmt.executeQuery();
        
            while (result.next()) {
                int id_tp = result.getInt(1);
                int id_user = result.getInt(2);
                String nom = result.getString(3);
                int id_user_demande = result.getInt(4);
                String nom_demande = result.getString(5);
                double dimension = result.getDouble(6);
                int nb_pieds = result.getInt(7);
                String description_terrain = result.getString(8);
                String longitude = result.getString(9);
                String latitude = result.getString(10);
                String img =result.getString(11);
                String nom_Categorie = result.getString(12);
                String nom_type = result.getString(13);
                Timestamp date = result.getTimestamp(14);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = dateFormat.format(date);

                TerrainModel terrain = new TerrainModel();
                terrain.setId_tp(id_tp);
                terrain.setId_utilisateur(id_user);
                terrain.setNom(nom);
                terrain.setId_user_demande(id_user_demande);
                terrain.setNom_user_demande(nom_demande);
                terrain.setDimension(dimension);
                terrain.setNb_pieds(nb_pieds);
                terrain.setDescription(description_terrain);
                terrain.setLongitude(longitude);
                terrain.setLatitude(latitude);
                terrain.setImg(img);
                terrain.setNom_categorie(nom_Categorie);
                terrain.setNom_type(nom_type);
                terrain.setDate_format(formattedDate);

                resultatList.add(terrain);
            }

            result.close();
            pstmt.close();
            conn.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resultatList.toArray(new TerrainModel[resultatList.size()]);
    }




}
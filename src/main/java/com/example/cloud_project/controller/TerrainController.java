package com.example.cloud_project.controller;

import org.springframework.web.bind.annotation.RestController;


import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.cloud_project.Models.TerrainModel;
import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

import com.example.cloud_project.Models.PersonneModel;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TerrainController {
    @CrossOrigin(origins = "*")
    @GetMapping("/listsTerrain")
    public ResponseEntity<TerrainModel[]> list_terrain()
    {
        TerrainModel t = new TerrainModel();
        TerrainModel list_terrain[]=t.select_terrain();
        return ResponseEntity.ok().body(list_terrain);
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/suggestion_terrain")
    public ResponseEntity<TerrainModel[]> select_parcelle_par_Terrain_personne(HttpSession session)
    {
        TerrainModel t = new TerrainModel();
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        TerrainModel list_terrain[]=t.suggestion_terrain(loggedInUserId);
        return ResponseEntity.ok().body(list_terrain);
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/demande_terrain")
    public ResponseEntity<TerrainModel> demandeterrain(@RequestBody TerrainModel terrain,HttpSession session)
    {
        int id_utilisateur = terrain.getId_utilisateur();
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        int id_parcelle = terrain.getId_parcelle();
        int id_terrain = terrain.getId_terrain();
        int id_categorie = terrain.getId_categorie();
        int id_type = terrain.getId_type();
        terrain.demande_terrain(id_utilisateur,loggedInUserId, id_parcelle, id_terrain, id_categorie,id_type);
        return ResponseEntity.ok(terrain);
    }

    @CrossOrigin(origins = "*") 
    @GetMapping("/list_demande")
    public ResponseEntity<TerrainModel[]> v_demande_terrain(HttpSession session)
    {
        TerrainModel t = new TerrainModel();
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        TerrainModel list_terrain[]=t.v_demande_terrain(loggedInUserId);
        return ResponseEntity.ok().body(list_terrain);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/insert_validation_parcelle_terrain_admin")
    public ResponseEntity<TerrainModel> validation_terrain_admin(@RequestBody TerrainModel terrain,HttpSession session)    
    {
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        int id_parcelle = terrain.getId_parcelle();
        int id_terrain = terrain.getId_terrain();
        int id_categorie = terrain.getId_categorie();
        int id_type = terrain.getId_type();
    
       terrain.validation_terrain_admin(loggedInUserId,id_parcelle, id_terrain ,id_categorie,id_type);
       return ResponseEntity.ok(terrain);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/v_validation_admin_terrain")
    public ResponseEntity<TerrainModel[]> v_validation_admin_terrain()
    {
        TerrainModel t = new TerrainModel();
        TerrainModel list_terrain[]=t.select_validation_admin();
        return ResponseEntity.ok().body(list_terrain);
    }

    
    @CrossOrigin(origins = "*")
    @GetMapping("/list_parcelleterrain")
    public ResponseEntity<TerrainModel[]> listParcelleterrain()
    {
        TerrainModel p = new TerrainModel();
        TerrainModel list_parcelle[]=p.v_information_parcelle_par_terrain();
        return ResponseEntity.ok().body(list_parcelle);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/information_parcelle_par_terrain_utilisateur")
    public ResponseEntity<TerrainModel[]> v_information_parcelle_par_terrain_par_utilisateur(
        HttpSession session){
        TerrainModel p = new TerrainModel();
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        TerrainModel stat[]=p.v_information_parcelle_par_terrain_par_utilisateur(loggedInUserId);
        return ResponseEntity.ok().body(stat);
    }
  @CrossOrigin(origins = "*")
    @GetMapping("/information_parcelle_par_terrain_parcelle")
    public ResponseEntity<TerrainModel[]> v_information_parcelle_par_terrain_par_parcelle(
        @RequestParam int id_parcelle){
        TerrainModel p = new TerrainModel();
        TerrainModel stat[]=p.v_information_parcelle_par_terrain_par_parcelle(id_parcelle);
        return ResponseEntity.ok().body(stat);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/information_parcelle_par_terrain_categorie")
    public ResponseEntity<TerrainModel[]> v_information_parcelle_par_terrain_par_categorie(
        @RequestParam int id_categorie){
        TerrainModel p = new TerrainModel();
        TerrainModel stat[]=p.v_information_parcelle_par_terrain_par_categorie(id_categorie);
        return ResponseEntity.ok().body(stat);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/filtre_nom")
    public ResponseEntity<TerrainModel[]> v_information_parcelle_par_terrain_par_nom(
        @RequestParam String nom){
        TerrainModel p = new TerrainModel();
        TerrainModel stat[]=p.v_information_parcelle_par_terrain_par_nom(nom);
        System.out.println("test nom bien");
        return ResponseEntity.ok().body(stat);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/filtre_information_par_terrain")
    public ResponseEntity<TerrainModel[]> filtre_v_information_parcelle_par_terrain(@RequestParam Integer id_categorie,@RequestParam Integer id_type){
        TerrainModel p = new TerrainModel();
        // TerrainModel stat[]=p.v_information_parcelle_par_terrain_par_categorie(id_categorie);
        // return ResponseEntity.ok().body(stat);

        if(id_type == null && id_categorie == null || id_type == 0 && id_categorie == 0)
        {
            
            TerrainModel stat[] = p.v_information_parcelle_par_terrain();
            System.out.println("test");
            return ResponseEntity.ok().body(stat);
        }
        if(id_categorie ==null || id_categorie == 0)
        {
            TerrainModel stat[]=p.v_information_parcelle_par_terrain_par_type(id_type);
            System.out.println("test1");
            return ResponseEntity.ok().body(stat);
        }
        if(id_type ==null || id_type ==0)
        {
            TerrainModel stat[]=p.v_information_parcelle_par_terrain_par_categorie(id_categorie);
            System.out.println("test2");
            return ResponseEntity.ok().body(stat);
        }

        else
        {
            // Autres cas non pris en charge
            return ResponseEntity.badRequest().body(new TerrainModel[0]);
        }
    }



    @CrossOrigin(origins = "*")
    @PostMapping("/insertTerrain")
    public ResponseEntity<TerrainModel> insertTerrain(@RequestBody TerrainModel terrain)
    {
        String description = terrain.getDescription();
        String longitude = terrain.getLongitude();
        String latitude = terrain.getLatitude();
        String photo = terrain.getPhoto();
        terrain.insert_terrain(description, latitude, longitude, photo);
        return ResponseEntity.ok(terrain);
    }

    

    @CrossOrigin(origins = "*")
    @PostMapping("/insert_parcelle_terrain")
    public ResponseEntity<TerrainModel> insert_parcelle_terrain(@RequestBody TerrainModel terrain)    
    {
        int id_utilisateur = terrain.getId_utilisateur();
        int id_parcelle = terrain.getId_parcelle();
        int id_terrain = terrain.getId_terrain();
        int id_categorie = terrain.getId_categorie();
        int id_type = terrain.getId_type();
    
       terrain.insert_parcelle_terrain(id_utilisateur,id_parcelle, id_terrain ,id_categorie,id_type);
       return ResponseEntity.ok(terrain);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/updateTerrain")
    public ResponseEntity<TerrainModel> updatePwd(@RequestBody TerrainModel terrain) {
        // Met à jour le mot de passe
        String description = terrain.getDescription();
        String photo = terrain.getPhoto();
        int id_terrain = terrain.getId_terrain();
        terrain.update_terrain(description, photo,id_terrain);
        return new ResponseEntity<>(HttpStatus.OK); 
    }

   
}
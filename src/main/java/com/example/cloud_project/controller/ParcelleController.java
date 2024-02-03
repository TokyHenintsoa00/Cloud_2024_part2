package com.example.cloud_project.controller;

import org.springframework.web.bind.annotation.RestController;
import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.cloud_project.Models.CategorieModel;
import com.example.cloud_project.Models.ParcelleModel;
import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

import com.example.cloud_project.Models.PersonneModel;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ParcelleController {
    @CrossOrigin(origins = "*")
    @GetMapping("/lists_parcelle")
    public ResponseEntity<ParcelleModel[]> listParcelles()
    {
        ParcelleModel p = new ParcelleModel();
        ParcelleModel list_parcelle[]=p.select_parcelle();
        return ResponseEntity.ok().body(list_parcelle);
    }
    
  @CrossOrigin(origins = "*")
    @GetMapping("/stat_parcelle")
    public ResponseEntity<ParcelleModel[]> stat_parcelle()
    {
        ParcelleModel p = new ParcelleModel();
        ParcelleModel stat[]=p.stat_parcelle();
        return ResponseEntity.ok().body(stat);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/insert_parcelle")
    public ResponseEntity<ParcelleModel> insert_parcelle(@RequestBody ParcelleModel parcelle)
    {
        double dimension = parcelle.getDimension();
        int nb_pieds = parcelle.getNb_pieds();
        double prix = parcelle.getPrix();

        parcelle.insert_parcelle(dimension, nb_pieds, prix);
        return ResponseEntity.ok(parcelle);
    }

    
}

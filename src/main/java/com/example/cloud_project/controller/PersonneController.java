package com.example.cloud_project.controller;
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

import com.example.cloud_project.Models.CategorieModel;
import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.example.cloud_project.Models.PersonneModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class PersonneController {
    @CrossOrigin(origins = "*")
    @GetMapping("/listsPersonne")
    public ResponseEntity<PersonneModel[]> listPersonnes() {
        // Get the list of personnes
        PersonneModel p = new PersonneModel();
        PersonneModel[] personnes = p.list_user();

        // Return a ResponseEntity with the JSON response
        return ResponseEntity.ok().body(personnes);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/insertPersonne_client")  
    public ResponseEntity<PersonneModel> insert_personne_client(@RequestBody PersonneModel personne){
        
        String nom = personne.getNom();
        String sexe = personne.getSexe();
        Date dtn = personne.getDtn();
        String email = personne.getEmail();
        String pwd = personne.getPwd();
        personne.insert_user_client(nom, sexe, dtn, email, pwd);
        return ResponseEntity.ok(personne);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/insertPersonne_admin")  
    public ResponseEntity<PersonneModel> insert_personne_admin(@RequestBody PersonneModel personne){
        
        String nom = personne.getNom();
        String sexe = personne.getSexe();
        Date dtn = personne.getDtn();
        String email = personne.getEmail();
        String pwd = personne.getPwd();
        personne.insert_user_client(nom, sexe, dtn, email, pwd);
        return ResponseEntity.ok(personne);
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/selectPersonnewhere")
    public ResponseEntity<PersonneModel> listPersonnes(@RequestParam String email, @RequestParam String pwd) 
    {
        PersonneModel p = new PersonneModel();
        p = p.select_user(email, pwd);
        return ResponseEntity.ok().body(p); 
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/info_user")
    public ResponseEntity<PersonneModel> information_utilisateur(@RequestParam int id_utilisateur) 
    {
        PersonneModel p = new PersonneModel();
        p = p.info_user(id_utilisateur);
        return ResponseEntity.ok().body(p); 
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/updatePwd")
    public ResponseEntity<PersonneModel> updatePwd(@RequestBody PersonneModel personne,HttpSession session) {
        // Met à jour le mot de passe
        String pwd = personne.getPwd();
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        personne.update_pwd(pwd, loggedInUserId);

        return new ResponseEntity<>(HttpStatus.OK); 
    }
//
    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public int login(@RequestBody PersonneModel personne, HttpSession session) {
    
        String email = personne.getEmail();
        String pwd = personne.getPwd();
    
        PersonneModel user = new PersonneModel();
        PersonneModel p = user.select_user(email, pwd);
        if (p != null) {
            session.setAttribute("loggedInUserId", p.getId_utilisateur());
            return p.getId_utilisateur();
        } 
        else {
            return -1; 
        }
    }



    @CrossOrigin(origins = "*")
    @PostMapping("/logout")
    public int logout(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
                return 0;
            } else {
                return -1; 
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -2; 
        }
    }
}

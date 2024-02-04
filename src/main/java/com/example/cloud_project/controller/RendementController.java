package com.example.cloud_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud_project.Models.ParcelleModel;
import com.example.cloud_project.Models.PersonneModel;
import com.example.cloud_project.Models.RendementModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RendementController {
    
    @CrossOrigin(origins = "*")
    @GetMapping("/v_prix_rendement_prevision")
    public ResponseEntity<RendementModel[]> select_v_parcelle_where(HttpSession session)
    {
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        RendementModel r = new RendementModel();
        RendementModel rend_Model[] = r.v_prix_rendement_prevision_where(loggedInUserId);
        return ResponseEntity.ok().body(rend_Model);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/v_sum_prix_rendement_prevision")
    public ResponseEntity<RendementModel[]> v_sum_prix_rendement_prevision(HttpSession session)
    {
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        RendementModel r = new RendementModel();
        RendementModel rend_Model[] = r.v_sum_prix_rendement_prevision(loggedInUserId);
        return ResponseEntity.ok().body(rend_Model);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/v_rendement_par_qte")
    public ResponseEntity<RendementModel[]> v_rendement_par_qte(HttpSession session)
    {
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        RendementModel r = new RendementModel();
        RendementModel rend_Model[] = r.v_rendement_par_qte(loggedInUserId);
        return ResponseEntity.ok().body(rend_Model);
    }


}

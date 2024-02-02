package com.example.cloud_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud_project.Models.DiscussionModel;
import com.example.cloud_project.Models.DiscussionRepositoryModel;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class DiscussionController {
    
    @Autowired
    private DiscussionRepositoryModel discussionRepository;

    @CrossOrigin(origins = "*")
    @PostMapping("/send_message")
    public DiscussionModel sendMessage(@RequestBody DiscussionModel discusison)
    {
        int idSender=discusison.getIdSender();
        int idReceiver=discusison.getIdReceiver();
        String nom_sender = discusison.getNom_sender();
        String nom_receiver= discusison.getNom_receiver();
        String message_sender = discusison.getMessage_sender();
        DiscussionModel message = new DiscussionModel(idSender,idReceiver,nom_sender,nom_receiver,message_sender);
        System.out.println("message");
        return discussionRepository.save(message);
    }

     @CrossOrigin(origins = "*")
    @GetMapping("/get_message")
    public ResponseEntity<List<DiscussionModel>> listCategories(@RequestParam int idSender , @RequestParam int idReceiver)
    {
        List<DiscussionModel> sentDiscussion = discussionRepository.findByIdSenderAndIdReceiver(idSender, idReceiver);
        List<DiscussionModel> getDiscussion = discussionRepository.findByIdSenderAndIdReceiver(idReceiver, idSender);

        List<DiscussionModel> allDiscussion= new ArrayList<>();
        allDiscussion.addAll(sentDiscussion);
        allDiscussion.addAll(getDiscussion);
        return ResponseEntity.ok().body(allDiscussion);
    }
}

package com.example.cloud_project.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class DiscussionController {
    
    @Autowired
    private DiscussionRepositoryModel discussionRepository;

    @CrossOrigin(origins = "*")
    @PostMapping("/send_message")
    public DiscussionModel sendMessage(@RequestBody DiscussionModel discusison,HttpSession session)
    {
        Integer idSender = (Integer) session.getAttribute("loggedInUserId");
        int idReceiver=discusison.getIdReceiver();
        String message_sender = discusison.getMessage_sender();
        LocalDateTime currentTime = LocalDateTime.now();
        DiscussionModel message = new DiscussionModel(idSender,idReceiver,message_sender,currentTime);
        System.out.println("message");
        return discussionRepository.save(message);
    }

     @CrossOrigin(origins = "*")
    @GetMapping("/get_message")
    public ResponseEntity<List<DiscussionModel>> listCategories(@RequestParam int idReceiver , HttpSession session)
    {
        Integer idSender = (Integer) session.getAttribute("loggedInUserId");
        List<DiscussionModel> sentDiscussion = discussionRepository.findByIdSenderAndIdReceiverOrderByDateAsc(idSender, idReceiver);
        List<DiscussionModel> getDiscussion = discussionRepository.findByIdSenderAndIdReceiverOrderByDateAsc(idReceiver, idSender);

        List<DiscussionModel> allDiscussion= new ArrayList<>();
        allDiscussion.addAll(sentDiscussion);
        allDiscussion.addAll(getDiscussion);
        Collections.sort(allDiscussion, Comparator.comparing(DiscussionModel::getDate));

        System.out.println("getMessage");
        return ResponseEntity.ok().body(allDiscussion);
    }
}

package com.example.cloud_project.Models;

import java.sql.Time;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Discussion")
public class DiscussionModel {
    

    int idSender;
    int idReceiver;
    String nom_sender;
    String nom_receiver;
    String message_sender;


    LocalDateTime  date;
    public int getIdSender() {
        return idSender;
    }
    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }
    public int getIdReceiver() {
        return idReceiver;
    }
    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }
    public String getNom_sender() {
        return nom_sender;
    }
    public void setNom_sender(String nom_sender) {
        this.nom_sender = nom_sender;
    }
    public String getNom_receiver() {
        return nom_receiver;
    }
    public void setNom_receiver(String nom_receiver) {
        this.nom_receiver = nom_receiver;
    }
    public String getMessage_sender() {
        return message_sender;
    }
    public void setMessage_sender(String message_sender) {
        this.message_sender = message_sender;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    
    public DiscussionModel(int idSender, int idReceiver, String nom_sender, String nom_receiver,String message_sender) {
    this.idSender = idSender;
    this.idReceiver = idReceiver;
    this.nom_sender = nom_sender;
    this.nom_receiver = nom_receiver;
    this.message_sender = message_sender;
    }

    public DiscussionModel(int idSender, int idReceiver, String message_sender,LocalDateTime  date) {
        this.idSender = idSender;
        this.idReceiver = idReceiver;
        this.message_sender = message_sender;
        this.date = date;
    }

    public DiscussionModel() {
    }
        
}

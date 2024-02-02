package com.example.cloud_project.Models;

import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.MongoRepository;

@SpringBootApplication
public interface DiscussionRepositoryModel extends MongoRepository<DiscussionModel,String> 
{
    List<DiscussionModel> findByIdSenderAndIdReceiver(int idSender, int idReceiver);
}
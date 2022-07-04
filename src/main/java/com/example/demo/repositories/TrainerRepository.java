package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Trainer;

@Repository
public interface TrainerRepository extends MongoRepository<Trainer, String>{

}

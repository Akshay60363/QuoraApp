package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Answer;

@Repository

public interface AnsweRepository extends ReactiveMongoRepository<Answer, String> {

}

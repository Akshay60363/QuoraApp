package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Question;

@Repository
public interface QuestionRepo extends ReactiveMongoRepository<Question, String> {
//	Flux<Question> findByAuthorId(String authorId);

}

package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.QuestionRequestDTO;
import com.example.demo.DTO.QuestionResponseDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface IQuestionService {

	public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO question);

	public Mono<QuestionResponseDTO> getQuestionById(String id);

	public Flux<QuestionResponseDTO> getAllQuestions();

}

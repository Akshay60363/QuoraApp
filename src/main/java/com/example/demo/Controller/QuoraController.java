package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.QuestionRequestDTO;
import com.example.demo.DTO.QuestionResponseDTO;
import com.example.demo.Service.IQuestionService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quora/question")
public class QuoraController {
	private final IQuestionService iQuestionService;

	@PostMapping()
	public Mono<QuestionResponseDTO> createQuestion(@RequestBody QuestionRequestDTO question) {
		return iQuestionService.createQuestion(question)
				.doOnSuccess(q -> System.out.println("Question created successfully in Controller: " + q))
				.doOnError(e -> System.err.println("Error creating question in Controller: " + e.getMessage()));

	}

	@GetMapping("/{id}")
	public Mono<QuestionResponseDTO> getQuestionById(@PathVariable String id) {
		return iQuestionService.getQuestionById(id)
				.doOnSuccess(q -> System.out.println("Question retrieved successfully in Controller: " + q))
				.doOnError(e -> System.err.println("Error retrieving question in Controller: " + e.getMessage()));
	}

	@GetMapping()
	public Flux<QuestionResponseDTO> getAllQuestions() {
		return iQuestionService.getAllQuestions()
				.doOnComplete(() -> System.out.println("All questions retrieved successfully in Controller"))
				.doOnError(e -> System.err.println("Error retrieving all questions in Controller: " + e.getMessage()));
	}
}

package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.QuestionRequestDTO;
import com.example.demo.DTO.QuestionResponseDTO;
import com.example.demo.Mapper.QuestionMapper;
import com.example.demo.Mapper.QuestionResponsMapper;
import com.example.demo.Model.Question;
import com.example.demo.Repository.QuestionRepo;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService {
	private final QuestionRepo questionRepo;

	@Override
	public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO question) {
		return questionRepo.save(QuestionMapper.mapToQuestionResponse(question))
				.map(QuestionResponsMapper::questionResponsMapper)
				.doOnSuccess(q -> System.out.println("Question created successfully: " + q))
				.doOnError(e -> System.err.println("Error creating question: " + e.getMessage()));

	}

	@Override
	public Mono<QuestionResponseDTO> getQuestionById(String id) {
		// TODO Auto-generated method stub
		Mono<Question> question = questionRepo.findById(id);
		if (question == null) {
			return Mono.empty();
		}
		return question.map(QuestionResponsMapper::questionResponsMapper)
				.doOnSuccess(q -> System.out.println("Success" + q))
				.doOnError(e -> System.err.println("Error in fetching" + e));

	}

	@Override
	public Flux<QuestionResponseDTO> getAllQuestions() {
		Flux<Question> questions = questionRepo.findAll();
		if (questions == null) {
			return Flux.empty();
		}
		return questions.map(QuestionResponsMapper::questionResponsMapper)
				.doOnComplete(() -> System.out.println("All questions retrieved successfully"))
				.doOnError(e -> System.err.println("Error retrieving all questions: " + e.getMessage()));

	}

}

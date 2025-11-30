package com.example.demo.Mapper;

import java.time.LocalDateTime;

import com.example.demo.DTO.QuestionRequestDTO;
import com.example.demo.Model.Question;

public class QuestionMapper {

	public static Question mapToQuestionResponse(QuestionRequestDTO question) {
		return Question.builder().title(question.getTitle()).content(question.getContent())
				.createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now()).build();
	}

}

package com.example.demo.Mapper;

import com.example.demo.DTO.QuestionResponseDTO;
import com.example.demo.Model.Question;

public class QuestionResponsMapper {

	public static QuestionResponseDTO questionResponsMapper(Question question) {
		return QuestionResponseDTO.builder().title(question.getTitle()).content(question.getContent()).build();

	}

}

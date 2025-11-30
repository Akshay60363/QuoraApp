package com.example.demo.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionRequestDTO {
	@NotBlank(message = "Title is mandatory")
	@Size(min = 10, max = 200, message = "Title must be between 10 and 200 characters")
	private String title;
	@NotBlank(message = "Content is mandatory")
	@Size(min = 20, message = "Content must be at least 20 characters long")
	private String content;

}

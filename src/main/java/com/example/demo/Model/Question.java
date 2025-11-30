package com.example.demo.Model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "questions")
public class Question {
	@Id
	private String id;
	@NotBlank(message = "Title is mandatory")
	@Size(min = 10, max = 200, message = "Title must be between 10 and 200 characters")
	private String title;
	@NotBlank(message = "Content is mandatory")
	@Size(min = 20, message = "Content must be at least 20 characters long")
	private String content;
	@CreatedDate
	private LocalDateTime createdAt;
	@LastModifiedDate
	private LocalDateTime updatedAt;
}

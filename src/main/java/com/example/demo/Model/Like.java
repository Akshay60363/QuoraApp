package com.example.demo.Model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Like {
	@Id
	private String id;
	private Boolean isLiked;

	@CreatedDate
	private LocalDateTime createAt;

}

package com.example.demo.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Trainer {
	
	@Id
	private String id;
	private String trainerName;
	private List<Pokemon> pokemon;
	private String homeTown;

}

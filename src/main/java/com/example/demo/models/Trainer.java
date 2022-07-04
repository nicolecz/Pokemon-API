package com.example.demo.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document
public class Trainer {
	
	private String trainerName;
	private List<Pokemon> pokemon;
	private String homeTown;
	@Id
	private String id;
	
	
	public Trainer() {
	
	}
	
	

}

package com.example.demo.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Document
public class Trainer {
	
	@Id
	private String id;
	private String trainerName;
	private List<Pokemon> pokemon;
	private String homeTown;
	
	
	public Trainer() {
	
	}
}

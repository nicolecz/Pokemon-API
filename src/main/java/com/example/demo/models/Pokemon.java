package com.example.demo.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {
	
	private String name;
	private String type;
	private int health;
	// Pokemon can't have more than 4 moves
	private List<Move> moves;
	
}

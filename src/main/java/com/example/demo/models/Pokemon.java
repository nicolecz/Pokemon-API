package com.example.demo.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
public class Pokemon {
	
	private String name;
	private String type;
	private int health;
	// Pokemon can't have more than 4 moves
	private List<Move> moves;
	
	
//	@Override
//	public boolean equals(Object obj) {
//		if(obj == this) {
//			return true;
//		}
//		if(!(obj instanceof Pokemon)) {
//			return false;
//		}
//		Pokemon pokemon = (Pokemon) obj;
//		return name.equals(pokemon.name) && 
//				type.equals(pokemon.type) &&
//				health == (pokemon.health) &&
//				moves.equals(pokemon.moves);
//	}
	
}

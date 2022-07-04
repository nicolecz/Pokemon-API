package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
public class Move {
	
	private String name;
	private String type;
	private int damage;
	
	
//	@Override
//	public boolean equals(Object obj) {
//		if(obj == this) {
//			return true;
//		}
//		if(!(obj instanceof Move)) {
//			return false;
//		}
//		Move move = (Move) obj;
//		return name.equals(move.name) && 
//				type.equals(move.type) &&
//				damage == (move.damage);
//	}
	
	
	
}

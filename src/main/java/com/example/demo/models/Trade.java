package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trade {
	
	private String trainer1Id;
	private String trainer2Id;
	private Pokemon trainer1Pokemon;
	private Pokemon trainer2Pokemon;
	
	public Trade() {
		
	}

}

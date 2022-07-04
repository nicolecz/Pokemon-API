package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Trade {
	
	private String trainer1Id;
	private String trainer2Id;
	private Pokemon trainer1Pokemon;
	private Pokemon trainer2Pokemon;

}

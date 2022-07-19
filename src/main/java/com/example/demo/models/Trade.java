package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trade {
	
	private String trainer1Id;
	private String trainer2Id;
	private Pokemon trainer1Pokemon;
	private Pokemon trainer2Pokemon;

}

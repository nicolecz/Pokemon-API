package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Move;
import com.example.demo.models.Pokemon;
import com.example.demo.models.Trade;
import com.example.demo.models.Trainer;
import com.example.demo.services.TrainerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TrainerController {
	
	private final TrainerService trainerService;
	
	@GetMapping("/trainers")
	public List<Trainer> findAllTrainers() {
		return trainerService.findAllTrainers();
	}
	
	@PostMapping("/addtrainer")
	public Trainer addTrainer(@RequestBody Trainer trainer) {
		return trainerService.addTrainer(trainer);
	}
	
	@DeleteMapping("/deletetrainer/{id}")
	public void deleteTrainer(@PathVariable String id) {
		trainerService.deleteTrainer(id);
	}
	
	@GetMapping("/getpokemon/{id}")
	public List<Pokemon> getPokemonByTrainer(@PathVariable String id) {
		return trainerService.getPokemonByTrainer(id);
	}
	
	@PostMapping("/addpokemon/{id}")
	public Trainer addPokemonToTrainer(@PathVariable String id, @RequestBody Pokemon pokemon) {
		return trainerService.addPokemonToTrainer(id, pokemon);
	}
	
	@PostMapping("/deletepokemon/{id}")
	public Trainer deletePokemonFromTrainer(@PathVariable String id, @RequestBody Pokemon pokemon) {
		return trainerService.deletePokemonFromTrainer(id, pokemon);
	}
	
	@PostMapping("/trade")
	public void tradePokemon(@RequestBody Trade trade) {
		trainerService.tradePokemon(trade);
	}
	
	@PutMapping("/addmoves") 
	public Trainer addMoves(@RequestBody Trainer trainer ) {
		return trainerService.addMoves(trainer);
	}	
	
	@PutMapping("/deletemoves")
	public Trainer deleteMoves(@RequestBody Trainer trainer) {
		return trainerService.deleteMoves(trainer);
	}
}

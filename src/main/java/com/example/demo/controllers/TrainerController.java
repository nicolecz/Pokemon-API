package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Pokemon;
import com.example.demo.models.Trade;
import com.example.demo.models.Trainer;
import com.example.demo.repositories.TrainerRepository;
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
	public void addTrainer(@RequestBody Trainer trainer) {
		trainerService.addTrainer(trainer);
	}
	
	@DeleteMapping("/deletetrainer/{id}")
	public void deleteTrainer(@PathVariable(value = "id") String id) {
		trainerService.deleteTrainer(id);
	}
	
	@GetMapping("/getpokemon/{id}")
	public List<Pokemon> getPokemonByTrainer(@PathVariable(value = "id") String id) {
		return trainerService.getPokemonByTrainer(id);
	}
	
	@PostMapping("/addpokemon/{id}")
	public void addPokemonToTrainer(@PathVariable(value = "id") String id, @RequestBody Pokemon pokemon) {
		trainerService.addPokemonToTrainer(id, pokemon);
	}
	
	@PostMapping("/deletepokemon/{id}")
	public void deletePokemonFromTrainer(@PathVariable(value = "id") String id, @RequestBody Pokemon pokemon) {
		trainerService.deletePokemonFromTrainer(id, pokemon);
	}
	
	@PostMapping("/trade")
	public void tradePokemon(@RequestBody Trade trade) {
		trainerService.tradePokemon(trade);
	}
	
}

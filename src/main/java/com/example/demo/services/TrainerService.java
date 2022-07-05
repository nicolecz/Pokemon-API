package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Move;
import com.example.demo.models.Pokemon;
import com.example.demo.models.Trade;
import com.example.demo.models.Trainer;
import com.example.demo.repositories.TrainerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TrainerService {
	
	private final TrainerRepository trainerRepository;

	public List<Trainer> findAllTrainers() {
		return trainerRepository.findAll();
	}
	
	public void addTrainer(Trainer trainer) {
		trainerRepository.insert(trainer);
	}

	public void deleteTrainer(String id) {
		trainerRepository.deleteById(id);
	}

	public List<Pokemon> getPokemonByTrainer(String id) {
		Optional<Trainer> trainerOptional = trainerRepository.findById(id);
		Trainer trainer = trainerOptional.get();
		return trainer.getPokemon();
	}

	public void addPokemonToTrainer(String id, Pokemon pokemon) {
		Optional<Trainer> trainerOptional = trainerRepository.findById(id);
		Trainer trainer = trainerOptional.get();
		trainer.getPokemon().add(pokemon);
		trainerRepository.save(trainer);
	}

	public void deletePokemonFromTrainer(String id, Pokemon pokemon) {
		Optional<Trainer> trainerOptional = trainerRepository.findById(id);
		Trainer trainer = trainerOptional.get();
		trainer.getPokemon().remove(pokemon);
		trainerRepository.save(trainer);	
	}

	public void tradePokemon(Trade trade) {
		addPokemonToTrainer(trade.getTrainer1Id(), trade.getTrainer2Pokemon());
		deletePokemonFromTrainer(trade.getTrainer2Id(), trade.getTrainer2Pokemon());
		addPokemonToTrainer(trade.getTrainer2Id(), trade.getTrainer1Pokemon());
		deletePokemonFromTrainer(trade.getTrainer1Id(), trade.getTrainer1Pokemon());
		
	}

	public void addMoves(Trainer trainer) {
		trainerRepository.save(trainer);
		
	}

	public void deleteMoves(Trainer trainer) {
		trainerRepository.save(trainer);
	}

	public List<Move> getMoves(String id, Pokemon pokemon) {
		Optional<Trainer> trainerOptional = trainerRepository.findById(id);
		Trainer trainer = trainerOptional.get();
		Pokemon tempPokemon = trainer.getPokemon().get(trainer.getPokemon().indexOf(pokemon));
		return tempPokemon.getMoves();
	}
	
}

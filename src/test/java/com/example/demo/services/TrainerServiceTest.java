package com.example.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.models.Move;
import com.example.demo.models.Pokemon;
import com.example.demo.models.Trade;
import com.example.demo.models.Trainer;
import com.example.demo.repositories.TrainerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

@ExtendWith(MockitoExtension.class)
public class TrainerServiceTest {
	
	@Mock
	TrainerRepository trainerRepository;
	
	@InjectMocks
	TrainerService trainerService;
	
	@Test
	void whenFindingAllTrainers_thenReturnsListOfTrainers() {
		// GIVEN ===================================================
		List<Trainer> expectedList = new ArrayList<>();
		Trainer givenTrainer = new Trainer();
		givenTrainer.setId("123");
		expectedList.add(givenTrainer);
		
		given(trainerRepository.findAll()).willReturn(expectedList);
		
		// WHEN ====================================================
		List<Trainer> actualList = trainerService.findAllTrainers();
		
		// THEN ====================================================
		assertThat(actualList).isEqualTo(expectedList);
	}
	
	@Test
	void whenAddingTrainer_thenTrainerReturned() {
		// GIVEN ==================================================
		Trainer givenTrainer = new Trainer();
		
		given(trainerRepository.insert(givenTrainer)).willReturn(givenTrainer);
		
		// WHEN ===================================================
		trainerService.addTrainer(givenTrainer);
	}
	
	@Test
	void whenDeletingTrainer_thenTrainerDeleted() {
		// GIVEN ==================================================
		Trainer givenTrainer = new Trainer();
		givenTrainer.setId("12");
		String trainerId = givenTrainer.getId();
		
		doNothing().when(trainerRepository).deleteById(trainerId);
		
		// WHEN ===================================================
		trainerService.deleteTrainer(trainerId);
	}
	
	@Test
	void whenGettingPokemonByTrainer_thenReturnListOfPokemon() {
		// GIVEN ==================================================
		Trainer givenTrainer = new Trainer();
		givenTrainer.setId("123");
		String trainerId = givenTrainer.getId();
		List<Pokemon> givenTrainerPokemon = new ArrayList<>();
		Pokemon pokemon = new Pokemon();
		pokemon.setName("Charmander");
		givenTrainerPokemon.add(pokemon);
		givenTrainer.setPokemon(givenTrainerPokemon);
		Optional<Trainer> trainerOptional = Optional.of(givenTrainer);
		
		given(trainerRepository.findById(trainerId)).willReturn(trainerOptional);
		
		// WHEN ====================================================
		trainerService.getPokemonByTrainer(trainerId);
		
	}
	
	@Test
	void whenAddingPokemonToTrainer_thenReturnTrainer() {
		// GIVEN ===================================================
		Trainer givenTrainer = new Trainer();
		givenTrainer.setId("12");
		String trainerId = givenTrainer.getId();
		List<Pokemon> givenTrainerPokemon = new ArrayList<>();
		Pokemon pokemon = new Pokemon();
		givenTrainer.setPokemon(givenTrainerPokemon);
		givenTrainerPokemon.add(pokemon);
		
		Optional<Trainer> trainerOptional = Optional.of(givenTrainer);
		
		given(trainerRepository.findById(trainerId)).willReturn(trainerOptional);
		given(trainerRepository.save(givenTrainer)).willReturn(givenTrainer);
		
		// WHEN ====================================================
		trainerService.addPokemonToTrainer(trainerId, pokemon);
	}
	
	@Test
	void whenDeletingPokemonFromTrainer_thenReturnTrainer() {
		// GIVEN ===================================================
		Trainer givenTrainer = new Trainer();
		givenTrainer.setId("12");
		String trainerId = givenTrainer.getId();
		List<Pokemon> givenTrainerPokemon = new ArrayList<>();
		Pokemon pokemon = new Pokemon();
		givenTrainer.setPokemon(givenTrainerPokemon);
		givenTrainerPokemon.add(pokemon);
		
		Optional<Trainer> trainerOptional = Optional.of(givenTrainer);
		
		given(trainerRepository.findById(trainerId)).willReturn(trainerOptional);
		given(trainerRepository.save(givenTrainer)).willReturn(givenTrainer);
		
		// WHEN ====================================================
		trainerService.deletePokemonFromTrainer(trainerId, pokemon);
	}
	
	@Test
	void whenTradingPokemon_thenReturnNothing() {
		// GIVEN ===================================================
		Pokemon pokemon1 = Pokemon.builder()
				.name("Charmander")
				.build();
		
		List<Pokemon> trainer1Pokemon = new ArrayList<>();
		trainer1Pokemon.add(pokemon1);
		
		Trainer trainer1 = Trainer.builder()
				.id("1")
				.pokemon(trainer1Pokemon)
				.build();

		Optional<Trainer> trainer1Optional = Optional.of(trainer1);
		
		Pokemon pokemon2 = Pokemon.builder()
				.name("Pikachu")
				.build();
		
		List<Pokemon> trainer2Pokemon = new ArrayList<>();
		trainer2Pokemon.add(pokemon2);
		
		Trainer trainer2 = Trainer.builder()
				.id("2")
				.pokemon(trainer2Pokemon)
				.build();
			
		Optional<Trainer> trainer2Optional = Optional.of(trainer2);
		
		Trade trade = new Trade(trainer1.getId(), trainer2.getId(), pokemon1, pokemon2);
		
		given(trainerRepository.findById(trainer1.getId())).willReturn(trainer1Optional);
		given(trainerRepository.findById(trainer2.getId())).willReturn(trainer2Optional);
		given(trainerRepository.save(trainer1)).willReturn(trainer1);
		given(trainerRepository.save(trainer2)).willReturn(trainer2);
		
		// WHEN ====================================================
		trainerService.tradePokemon(trade);
	}
	
	@Test
	void whenAddingMoves_thenReturnTrainer() {
		// GIVEN =======================================================
		Trainer trainer = new Trainer();
		
		given(trainerRepository.save(trainer)).willReturn(trainer);
		
		// WHEN ========================================================
		trainerService.addMoves(trainer);
	}
}

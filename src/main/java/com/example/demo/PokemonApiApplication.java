package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.Move;
import com.example.demo.models.Pokemon;
import com.example.demo.models.Trainer;
import com.example.demo.repositories.TrainerRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
public class PokemonApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonApiApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner runner(TrainerRepository repository) {
//		return args -> {
//			Move fly = new Move("fly",5,"wingflap");
//			
//			List<Move> moves = new ArrayList<>();
//			moves.add(fly);
//			
//			List<Pokemon> ashPokemon = new ArrayList<>();
//			
//			Pokemon charmander = new Pokemon("Charmander", "fire", 50, moves);
//			
//			ashPokemon.add(charmander);
//			
//			Trainer trainer = new Trainer("Ash", ashPokemon, "Ashville");
//		}
//	}

}

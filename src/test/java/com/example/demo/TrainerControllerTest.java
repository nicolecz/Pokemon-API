package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controllers.TrainerController;
import com.example.demo.models.Trainer;
import com.example.demo.services.TrainerService;
import com.fasterxml.jackson.databind.ObjectMapper;

// this spins up everything needed for the controller to work
//@WebMvcTest(controllers = TrainerController.class) ** spins up Spring context
@ExtendWith(MockitoExtension.class) // preferable, doesn't spin up Spring context
class TrainerControllerTest {

	// this comes from the @WebMvcTest. This sends requests
//	@Autowired ** can't do since not spinning up the Spring context
	MockMvc mockMvc;
	
	// this turns objects into json or json into objects
//	@Autowired
	ObjectMapper objectMapper;
	
	@Mock // don't use mockbean when doing unit testing since not spinning up the Spring context
	TrainerService trainerService;
	
	@InjectMocks
	TrainerController trainerController;
	
	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(trainerController).build();
		objectMapper = new ObjectMapper();
	}
	
	@Test
	void whenValidInput_thenReturns200() throws Exception {
		
		// GIVEN ===================================================
		
		List<Trainer> expectedTrainerList = new ArrayList<>(); 
		Trainer givenTrainer1 = new Trainer();
		givenTrainer1.setHomeTown("balh");
		
		// WHEN ====================================================
		
		// when this service gets called, just return the givenTrainerList
		when(trainerService.findAllTrainers())
			.thenReturn(expectedTrainerList);
		
		// this is the thing that sends a request to the controller
		MvcResult mvcResult = mockMvc.perform(get("/trainers"))
		        .andExpect(status().isOk())
		        .andReturn();
		
		// THEN ======================================================
		
		// get the response from the above call and turn it into a list of Trainer objects
		String response = mvcResult.getResponse().getContentAsString();
		List<Trainer> actualTrainersReturned = objectMapper.readValue(response, List.class); 
		
		assertThat(actualTrainersReturned).isEqualTo(expectedTrainerList);
	}
	
	@Test
	void whenValidInputAddingTrainer_thenReturns200() throws Exception {
		// GIVEN =====================================================

		Trainer expectedTrainer = new Trainer();
		expectedTrainer.setTrainerName("Ash");
		
		// WHEN ======================================================
		doNothing().when(trainerService).addTrainer(expectedTrainer);
		
		mockMvc.perform(post("/addtrainer")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(expectedTrainer)))
				.andExpect(status().isOk());
	}
	
	@Test
	void  whenDeletingTrainer_thenReturns200() throws Exception {
		// GIVEN ======================================================
		String trainerId = "11";
		
		// WHEN =======================================================
		doNothing().when(trainerService).deleteTrainer(trainerId);
		
		mockMvc.perform(delete("/deletetrainer/{id}",trainerId))
				.andExpect(status().isOk());
	
		}
	}


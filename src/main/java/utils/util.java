package utils;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Trainee;
import domain.Trainer;

public class util {
	public static String convertTrainerToJSON(Trainer incTrainer) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(incTrainer);
	}
	
	public static Trainer convertJSONtoTrainer(String incomingJSONString) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(incomingJSONString, Trainer.class);
	}
	public static String convertTraineeToJSON(Trainee incTrainee) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(incTrainee);
	}
	
	public static Trainee convertJSONtoTrainee(String incomingJSONString) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(incomingJSONString, Trainee.class);
	}
}

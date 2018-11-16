package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domain.Trainee;
import domain.Trainer;

public class gsonutil {
	private Gson gson;
	public gsonutil() {
		gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	public String toGSON(Trainee o) {
		return gson.toJson(o);
	}
	
	public String toGSON(Trainer o) {
		return gson.toJson(o);
	}
	
	public Trainer toTrainer(String s) {
		return gson.fromJson(s, Trainer.class);
	}
	
	public Trainee toTrainee(String s) {
		return gson.fromJson(s, Trainee.class);
	}
}

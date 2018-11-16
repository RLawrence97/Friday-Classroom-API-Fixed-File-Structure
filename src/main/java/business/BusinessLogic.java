package business;

import java.util.List;

import javax.inject.Inject;

import domain.Trainee;
import domain.Trainer;
import utils.gsonutil;
import repository.TraineeRepository;
import repository.TrainerRepository;

public class BusinessLogic {
	@Inject
	private TrainerRepository trainerManager;
	@Inject
	private TraineeRepository traineeManager;
	@Inject
	private gsonutil gutil;
	
	public String getAllTrainers() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		List<Trainer> trainerList = trainerManager.getAllTrainers();
		for(Trainer t : trainerList) {
			sb.append(gutil.toGSON(t) + ", ");
		}
		sb.append(" }");
		return sb.toString();
	}
	
	public String getAllTrainee() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		List<Trainee> traineeList = traineeManager.getAllTrainees();
		for(Trainee t : traineeList) {
			sb.append(gutil.toGSON(t) + ", ");
		}
		sb.append(" }");
		return sb.toString();
	}
	public String getTrainerByID(long incomingID) {
		return gutil.toGSON(trainerManager.findTrainerByID(incomingID));
	}
	
	public String updateByTrainer(Trainer incoming) {
		Trainer a = trainerManager.findTrainerByID(incoming.getTrainerID());
		return gutil.toGSON(trainerManager.updateTrainer(a));
	}
	

	public String deleteTrainer(long incomingID) {
		return "{\" deleted account\" : \"" +trainerManager.deleteTrainer(incomingID) + "\"}";
	}

	public String addTrainer(Trainer incoming) {
		return gutil.toGSON(trainerManager.addTrainer(incoming));
	}
	public String getTraineeByID(long incomingID) {
		return gutil.toGSON(traineeManager.findTraineeByID(incomingID));
	}
	
	public String updateByTrainee(Trainee incoming) {
		Trainee a = traineeManager.findTraineeByID(incoming.getTraineeID());
		return gutil.toGSON(traineeManager.updateTrainee(a));
	}
	

	public String deleteTrainee(long incomingID) {
		return "{\" deleted account\" : \"" +traineeManager.deleteTrainee(incomingID) + "\"}";
	}

	public String addTrainee(Trainee incoming) {
		return gutil.toGSON(traineeManager.addTrainee(incoming));
	}
	
	public String addTraineeToClass(long incomingID, Trainee t) {
		return gutil.toGSON(trainerManager.addTraineeToID(incomingID, t));
	}
	
	public String removeTraineeFromClass(long incomingID, Trainee t) {
		return gutil.toGSON(trainerManager.removeTraineeToID(incomingID, t));
	}
	
	public String numberOfStudentsByID(long trainerID) {
		Trainer t = trainerManager.findTrainerByID(trainerID);
		return "{ " +  t.getFirstName() + " " + t.getLastName() + " : " + t.getTraineeList().size() + " students }";
	}
}

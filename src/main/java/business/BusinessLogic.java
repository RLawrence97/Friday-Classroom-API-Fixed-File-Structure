package business;

import java.util.List;

import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonProcessingException;

import domain.Trainee;
import domain.Trainer;
import utils.util;
import repository.TraineeRepository;
import repository.TrainerRepository;

public class BusinessLogic {
	@Inject
	private TrainerRepository trainerManager;
	@Inject
	private TraineeRepository traineeManager;
	
	public String getAllTrainers() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		List<Trainer> trainerList = trainerManager.getAllTrainers();
		for(Trainer t : trainerList) {
			try {
				sb.append(util.convertTrainerToJSON(t) + ", ");
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				sb.append("Failed to convert!");
			}
		}
		sb.append(" }");
		return sb.toString();
	}
	
	public String getAllTrainee() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		List<Trainee> traineeList = traineeManager.getAllTrainees();
		for(Trainee t : traineeList) {
			try {
				sb.append(util.convertTraineeToJSON(t) + ", ");
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				sb.append("Failed to convert!");
			}
		}
		sb.append(" }");
		return sb.toString();
	}
	public String getTrainerByID(long incomingID) {
		try {
			return util.convertTrainerToJSON(trainerManager.findTrainerByID(incomingID));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String updateByTrainer(Trainer incoming) {
		Trainer a = trainerManager.findTrainerByID(incoming.getTrainerID());
		try {
			return util.convertTrainerToJSON(trainerManager.updateTrainer(a));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public String deleteTrainer(long incomingID) {
		return "{\" deleted account\" : \"" +trainerManager.deleteTrainer(incomingID) + "\"}";
	}

	public String addTrainer(Trainer incoming) {
		try {
			return util.convertTrainerToJSON(trainerManager.addTrainer(incoming));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getTraineeByID(long incomingID) {
		try {
			return util.convertTraineeToJSON(traineeManager.findTraineeByID(incomingID));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String updateByTrainee(Trainee incoming) {
		Trainee a = traineeManager.findTraineeByID(incoming.getTraineeID());
		try {
			return util.convertTraineeToJSON(traineeManager.updateTrainee(a));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public String deleteTrainee(long incomingID) {
		return "{\" deleted account\" : \"" +traineeManager.deleteTrainee(incomingID) + "\"}";
	}

	public String addTrainee(Trainee incoming) {
		try {
			return util.convertTraineeToJSON(traineeManager.addTrainee(incoming));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String addTraineeToClass(long incomingID, Trainee t) {
		try {
			return util.convertTrainerToJSON(trainerManager.addTraineeToID(incomingID, t));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String removeTraineeFromClass(long incomingID, Trainee t) {
		try {
			return util.convertTrainerToJSON(trainerManager.removeTraineeToID(incomingID, t));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String numberOfStudentsByID(long trainerID) {
		Trainer t = trainerManager.findTrainerByID(trainerID);
		return "{ " +  t.getFirstName() + " " + t.getLastName() + " : " + t.getTraineeList().size() + " students }";
	}
}
